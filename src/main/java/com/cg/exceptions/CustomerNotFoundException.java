package com.cg.exceptions;

public class CustomerNotFoundException extends Exception{
	
	public CustomerNotFoundException() {
		
	}
	
	public CustomerNotFoundException(String message) {
		super(message);
		System.out.println("Inside CustomerNotFoundException");
	}

}
