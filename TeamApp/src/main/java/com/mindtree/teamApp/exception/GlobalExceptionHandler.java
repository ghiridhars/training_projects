package com.mindtree.teamApp.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(FranchiseAppException.class)
	public String handleAppException(FranchiseAppException fe, WebRequest wr,Model m) {
		ErrorDetails ed = new ErrorDetails(fe.getMessage(), new Date(), wr.getDescription(false));
		m.addAttribute("errors",ed);
		System.out.println(ed);
		return "error";
	}

	@ExceptionHandler(FranchiseServiceException.class)
	public ResponseEntity<String> handleFetchException(FranchiseServiceException fe, WebRequest wr,Model m) {
		ErrorDetails ed = new ErrorDetails(fe.getMessage(), new Date(), wr.getDescription(false));
		m.addAttribute("errors",ed.getMessage());
		System.out.println(ed);
		return new ResponseEntity<String>(ed.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
}
