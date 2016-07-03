package libraryapp.domain.exceptions;

public class BookIsReservedException extends RuntimeException {

	public BookIsReservedException() {
		super();
	}

	public BookIsReservedException(String message) {
		super(message);
	}

	public BookIsReservedException(Throwable cause) {
		super(cause);
	}

	public BookIsReservedException(String message, Throwable cause) {
		super(message, cause);
	}

	public BookIsReservedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
