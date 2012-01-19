package emross;

import java.util.List;

import emross.action.Action;
import emross.action.ActionImp;
import emross.action.Path;
import emross.http.ServerCodeException;
import emross.json.bean.ServerInfo;
import emross.json.bean.UserInfo;

public class Client {

	private Action action = new ActionImp();
	private final String key;
	private final String server;

	private List<City> city;

	public Client(final String user, final String password)
			throws ServerCodeException {

		ServerInfo serverInfo = action.queryServerInfo(Path.MASTER_HOST, user);

		server = serverInfo.getServer();

		key = action.login(server, serverInfo.getUser(), password).getKey();

		UserInfo userInfo = action.getUserInfo(server, key);
		// serverInfo.get
	}

}
