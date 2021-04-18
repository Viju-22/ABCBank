package com.cg.exceptions;

public class LoanSchemeNotFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoanSchemeNotFoundException() {
		
	}
	
	public LoanSchemeNotFoundException(String msg) {
		
		super(msg);
		System.out.println("Inside LoanSchemeNotFoundException");
	}

}
