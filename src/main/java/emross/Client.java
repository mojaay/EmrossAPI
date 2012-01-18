package emross;

import emross.action.Action;
import emross.action.Path;
import emross.http.HttpEngine;
import emross.http.ServerCodeException;
import emross.json.bean.LoginInfo;
import emross.json.bean.ServerInfo;
import emross.json.bean.UserInfo;

public class Client {

	private ServerInfo serverInfo;
	private LoginInfo loginInfo;

	public Client(final String user, final String password)
			throws ServerCodeException {

		Action action = new Action(HttpEngine.getInstance());
		serverInfo = action.getServerInfo(Path.MASTER_HOST, user);
		loginInfo = action.getKey(serverInfo.getServer(), serverInfo.getUser(),
				password);

		UserInfo userInfo = action.getInfo(serverInfo.getServer(),
				loginInfo.getKey());
		// serverInfo.get
	}
}
