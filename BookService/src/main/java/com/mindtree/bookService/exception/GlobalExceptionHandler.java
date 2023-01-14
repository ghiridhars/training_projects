package com.mindtree.bookService.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(BookAppException.class)
	public ResponseEntity<?> handleBookAppException(BookAppException be, WebRequest wr){
		ErrorDetails ed = new ErrorDetails(be.getMessage(), new Date(), wr.getDescription(false));
		return new ResponseEntity<>(ed, HttpStatus.BAD_GATEWAY);
	}

}
