package emross.action;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import emross.http.HttpEngine;
import emross.http.ServerCodeException;

public abstract class AbstractAction implements Action {

	protected final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	private final static ObjectMapper mapper = new ObjectMapper();

	private final HttpEngine engine;

	public AbstractAction() {
		engine = HttpEngine.getInstance();
	}

	public AbstractAction(HttpEngine engine) {
		this.engine = engine;
	}

	protected final <T> T readValue(String host, String path,
			List<NameValuePair> params, Class<T> entityClass)
			throws ServerCodeException {

		try {
			JsonNode node = mapper.readValue(
					engine.doAction(this.createUri(host, path, params)),
					JsonNode.class);
			if (node.path("code").getIntValue() != 0) {
				throw new ServerCodeException(node.path("code").getIntValue());
			}
			return mapper.readValue(node.path("ret"), entityClass);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private final List<NameValuePair> makeParams(List<NameValuePair> Params) {
		final List<NameValuePair> params = new LinkedList<NameValuePair>();

		params.add(pair("jsonpcallback", "jQuery" + System.currentTimeMillis()));
		params.addAll(Params);
		/** language */
		params.add(pair("_l", "chs"));

		// params.add(pair("_p", "EW-DROID"));
		params.add(pair("_p", "SG-IPHONE-CHS"));
		params.add(pair("_", String.valueOf(System.currentTimeMillis())));

		return params;
	}

	private final URI createUri(String host, String path,
			List<NameValuePair> params) {
		try {
			return URIUtils
					.createURI(null, host, 0, path, URLEncodedUtils.format(
							this.makeParams(params), HTTP.UTF_8), null);
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}

	protected final NameValuePair pair(String name, Number value) {
		return this.pair(name, value.toString());
	}

	protected final NameValuePair pair(String name, String value) {
		return new BasicNameValuePair(name, value);
	}
}
