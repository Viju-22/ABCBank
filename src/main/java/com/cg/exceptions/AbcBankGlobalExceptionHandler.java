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
    

    @ExceptionHandler(LoanRequestNotFoundException.class)
    @ResponseStatus( value = HttpStatus.NOT_FOUND)
    @ResponseBody
	public ErrorInfo handleLoanRequestNotFoundException(LoanRequestNotFoundException e, HttpServletRequest request) {
		
		System.out.println("In Controller advice to find the requestId");
		
		ErrorInfo error = new ErrorInfo();
		error.setUrl(request.getRequestURI());
		error.setMessage(e.getMessage());
		return error;	

	}
    

}
