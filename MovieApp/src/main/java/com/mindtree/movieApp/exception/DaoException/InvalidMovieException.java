package com.mindtree.movieApp.exception.DaoException;

import com.mindtree.movieApp.exception.MovieAppServiceException;

public class InvalidMovieException extends MovieAppServiceException {

	public InvalidMovieException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvalidMovieException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public InvalidMovieException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidMovieException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidMovieException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
