package resume.bexysuttx.exception;

public class CantCompleteClientRequestException extends RuntimeException {
	private static final long serialVersionUID = -6889651058820454336L;

	public CantCompleteClientRequestException() {
	}

	public CantCompleteClientRequestException(String message) {
		super(message);
	}

	public CantCompleteClientRequestException(Throwable cause) {
		super(cause);
	}

	public CantCompleteClientRequestException(String message, Throwable cause) {
		super(message, cause);
	}

}
