package emross.json.bean;

public class ServerInfo {

	private String server;
	private String user;
	private String referer;
	private String refercode;

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getReferer() {
		return referer;
	}

	public void setReferer(String referer) {
		this.referer = referer;
	}

	public String getRefercode() {
		return refercode;
	}

	public void setRefercode(String refercode) {
		this.refercode = refercode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[server=").append(server).append(", user=")
				.append(user).append(", referer=").append(referer)
				.append(", refercode=").append(refercode).append("]");
		return builder.toString();
	}

}
