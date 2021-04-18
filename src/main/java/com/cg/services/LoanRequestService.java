package com.cg.services;

import java.util.List;

import com.cg.entities.LoanRequest;

public interface LoanRequestService{
	
	public String addloanRequest(LoanRequest request);
	
	public String verifyLoanRequest(LoanRequest request);
	
	
	public List<LoanRequest> viewAllLoanRequests();
	
	public LoanRequest getRequestById(Integer id);

}
