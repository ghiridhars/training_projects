package com.mindtree.movieApp.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MovieAppException.class)
	public ResponseEntity<?> handleMovieAppException(MovieAppException me, WebRequest wr){
		ErrorDetails ed = new ErrorDetails(me.getMessage(), wr.getDescription(false),new Date());
		return new ResponseEntity<ErrorDetails>(ed,HttpStatus.BAD_REQUEST);
	}

}
