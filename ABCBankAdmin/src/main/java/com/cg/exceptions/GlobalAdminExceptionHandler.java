package com.cg.exceptions;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalAdminExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(GlobalAdminExceptionHandler.class);
	
	@ExceptionHandler(LoanSchemeNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ResponseBody
	public ErrorInfo handleLoanSchemeNotFoundException(LoanSchemeNotFoundException e, HttpServletRequest request) {
		
		logger.info("In controller advice to find the AdminId");
		
		ErrorInfo error = new ErrorInfo();    // create instance of ErrorInfo
		error.setUrl(request.getRequestURI());   
		error.setMessage(e.getMessage()); 
		
		return error;
	}
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<String> handleContraintViolationException(ConstraintViolationException e) {
		return new ResponseEntity<String>("Validation error on path parameter :" + e.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
}

