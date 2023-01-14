package com.mindtree.airlineReservation.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(InvalidFlightException.class)
	public ResponseEntity<?> handleInvalidPassportException(InvalidFlightException e, WebRequest wr) {
		ErrorDetails ed = new ErrorDetails(new Date(), e.getMessage(), wr.getDescription(false));
		return new ResponseEntity<ErrorDetails>(ed,HttpStatus.BAD_REQUEST);
	}
}
