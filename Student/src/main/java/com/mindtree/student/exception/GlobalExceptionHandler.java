package com.mindtree.student.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(StudentAppException.class)
	public String handleStudentException(StudentAppException se, WebRequest wr, Model m) {
		ErrorDetails ed = new ErrorDetails(se.getMessage(), new Date(), wr.getDescription(false));
		m.addAttribute("errors", ed.getMessage());
		System.out.println(ed.getMessage());
		return "error";
	}
	
	@ExceptionHandler(StudentException.class)
	public ResponseEntity<String> handleFetchException(StudentException fe, WebRequest wr,Model m) {
		ErrorDetails ed = new ErrorDetails(fe.getMessage(), new Date(), wr.getDescription(false));
		m.addAttribute("errors",ed.getMessage());
		System.out.println(ed);
		return new ResponseEntity<String>(ed.getMessage(),HttpStatus.BAD_REQUEST);
	}

}
