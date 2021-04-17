package com.cg.exceptions;

import javax.servlet.http.HttpServletRequest;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AbcBankGlobalExceptionHandler {
	
	
    @ExceptionHandler(CustomerNotFoundException.class)
    @ResponseStatus( value = HttpStatus.NOT_FOUND)
    @ResponseBody
	public ErrorInfo handleCustomerNotFoundException(CustomerNotFoundException e, HttpServletRequest request) {
		
		System.out.println("In Controller advice to find the empId");
		
		ErrorInfo error = new ErrorInfo();
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
