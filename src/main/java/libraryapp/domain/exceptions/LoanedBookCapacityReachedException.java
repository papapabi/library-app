package libraryapp.domain.exceptions;

public class LoanedBookCapacityReachedException extends RuntimeException {

	public LoanedBookCapacityReachedException() {
		super();
	}

	public LoanedBookCapacityReachedException(String message) {
		super(message);
	}

	public LoanedBookCapacityReachedException(Throwable cause) {
		super(cause);
	}

	public LoanedBookCapacityReachedException(String message, Throwable cause) {
		super(message, cause);
	}

	public LoanedBookCapacityReachedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
