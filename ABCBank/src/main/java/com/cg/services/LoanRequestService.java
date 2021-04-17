package com.cg.services;

import java.util.List;

import com.cg.entities.LoanRequest;

public interface LoanRequestService{
	
	public void addloanRequest(LoanRequest request);
	public List<LoanRequest> verifyLoanRequest(LoanRequest request);
	public List<LoanRequest> deleteloanRequest(Integer id);
	public List<LoanRequest> viewAllLoanRequests();
	public LoanRequest getRequestById(Integer id);

}
