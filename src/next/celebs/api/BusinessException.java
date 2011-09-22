package next.celebs.api;

/**
 * Propagates on business errors (4xx http status).
 */
@SuppressWarnings("serial")
public class BusinessException extends RuntimeException {

	private int code;
	private String msg;

	public BusinessException(int code) {
		this.code = code;
	}

	public BusinessException(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return msg;
	}

}
