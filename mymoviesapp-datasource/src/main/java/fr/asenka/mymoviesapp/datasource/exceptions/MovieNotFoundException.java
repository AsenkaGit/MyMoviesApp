package fr.asenka.mymoviesapp.datasource.exceptions;

/**
 * Exception to throw when at least one movie should be returned by a service and there is no result.
 */
@SuppressWarnings("serial")
public class MovieNotFoundException extends Exception {

	/**
	 * @param message the explanation of the error
	 */
	public MovieNotFoundException(String message) {

		super(message);
	}

	/**
	 * @param cause the cause of the error
	 */
	public MovieNotFoundException(Throwable cause) {

		super(cause);
	}
}
