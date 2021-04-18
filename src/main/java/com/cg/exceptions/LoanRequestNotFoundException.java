package com.cg.exceptions;

public class LoanRequestNotFoundException extends Exception{
	
	public LoanRequestNotFoundException() {
		
	}
	
	public LoanRequestNotFoundException(String message) {
		super(message);
		System.out.println("Inside LoanRequestNotFoundException");
	}

}
