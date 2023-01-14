package com.mindtree.collegeManagement.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(InvalidCollegeException.class)
	public ResponseEntity<?> handleInvalidCollegeException(InvalidCollegeException e, WebRequest wr) {
		ErrorDetails ed = new ErrorDetails(new Date(), e.getMessage(), wr.getDescription(false));
		return new ResponseEntity<ErrorDetails>(ed,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidStudentException.class)
	public ResponseEntity<?> handleInvalidStudentException(InvalidStudentException e, WebRequest wr) {
		ErrorDetails ed = new ErrorDetails(new Date(), e.getMessage(), wr.getDescription(false));
		return new ResponseEntity<ErrorDetails>(ed,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(StudentServiceException.class)
	public ResponseEntity<?> handleStudentServiceException(StudentServiceException e, WebRequest wr) {
		ErrorDetails ed = new ErrorDetails(new Date(), e.getMessage(), wr.getDescription(false));
		return new ResponseEntity<ErrorDetails>(ed,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CollegeServiceException.class)
	public ResponseEntity<?> handleCollegeServiceException(CollegeServiceException e, WebRequest wr) {
		ErrorDetails ed = new ErrorDetails(new Date(), e.getMessage(), wr.getDescription(false));
		return new ResponseEntity<ErrorDetails>(ed,HttpStatus.BAD_REQUEST);
	}
}
