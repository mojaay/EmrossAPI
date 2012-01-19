package emross.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;

import emross.http.ServerCodeException;
import emross.json.bean.LoginInfo;
import emross.json.bean.ServerInfo;
import emross.json.bean.UserInfo;

public class ActionImp extends AbstractAction {

	@Override
	public ServerInfo queryServerInfo(String host, String user)
			throws ServerCodeException {
		final List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(pair("action", "login"));
		params.add(pair("user", user));
		params.add(pair("pvp", 0));

		return readValue(host, Path.MASTER_QUERY, params, ServerInfo.class);
	}

	@Override
	public LoginInfo login(String host, String user, String password)
			throws ServerCodeException {
		final List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(pair("username", user));
		params.add(pair("password", password));
		return readValue(host, Path.FUNC_LOGIN, params, LoginInfo.class);
	}

	@Override
	public UserInfo getUserInfo(String host, String key)
			throws ServerCodeException {
		final List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(pair("key", key));

		return readValue(host, Path.FUNC_GETUSERINFO, params, UserInfo.class);
	}

}
