package com.mindtree.franchise.exception;

import java.util.Date;

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
		return "error";
	}

}
