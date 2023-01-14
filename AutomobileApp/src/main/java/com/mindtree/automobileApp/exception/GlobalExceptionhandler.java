package com.mindtree.automobileApp.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionhandler {

	@ExceptionHandler(AutomobileCompanyAppException.class)
	public ResponseEntity<ErrorDetails> handleAppException(AutomobileCompanyAppException ae, WebRequest wr) {
		ErrorDetails er = new ErrorDetails(ae.getMessage(), new Date(), wr.getDescription(false));
		return new ResponseEntity<ErrorDetails>(er, HttpStatus.BAD_REQUEST);
	}

}
