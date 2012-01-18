package emross.http;

import java.io.IOException;
import java.net.URI;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpEngine {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	private static final HttpEngine SESSION = new HttpEngine();

	private static final String USER_AGENT = "Mozilla/5.0 (Linux; U; Android 2.2; zh-cn; Nexus One Build/FRF91) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";

	public static HttpEngine getInstance() {
		return SESSION;
	}

	private final HttpClient client;

	private HttpEngine() {

		final HttpParams params = new BasicHttpParams();

		HttpConnectionParams.setTcpNoDelay(params, true);
		HttpConnectionParams.setSocketBufferSize(params, 8192);

		HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
		HttpProtocolParams.setContentCharset(params, HTTP.UTF_8);
		HttpProtocolParams.setUseExpectContinue(params, false);
		HttpProtocolParams.setUserAgent(params, USER_AGENT);

		SchemeRegistry schemeRegistry = new SchemeRegistry();
		schemeRegistry.register(new Scheme("http", 80, PlainSocketFactory
				.getSocketFactory()));

		ClientConnectionManager cm = new ThreadSafeClientConnManager(
				schemeRegistry);
		client = new DefaultHttpClient(cm, params);
	}

	public String doAction(URI uri) {

		HttpGet httpGet = new HttpGet(uri);

		HttpResponse response;
		try {
			response = client.execute(httpGet);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		try {
			return trim(EntityUtils.toString(response.getEntity(), HTTP.UTF_8));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

	public void shutdown() {
		this.client.getConnectionManager().shutdown();
	}

	private String trim(final String val) {
		return StringUtils.substringBetween(val, "(", ")");
	}

}
