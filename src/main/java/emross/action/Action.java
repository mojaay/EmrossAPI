package emross.action;

import emross.http.ServerCodeException;
import emross.json.bean.LoginInfo;
import emross.json.bean.ServerInfo;
import emross.json.bean.UserInfo;

public interface Action {

	public abstract ServerInfo queryServerInfo(String host, String user)
			throws ServerCodeException;

	public abstract LoginInfo login(String host, String user, String password)
			throws ServerCodeException;

	public abstract UserInfo getUserInfo(String host, String key)
			throws ServerCodeException;

}