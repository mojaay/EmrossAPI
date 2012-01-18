package emross.http;

public class ServerCodeException extends Exception {
	private static final long serialVersionUID = 1L;

	private int code;

	public final int getCode() {
		return code;
	}

	public ServerCodeException(int code) {
		this.code = code;
	}

}
