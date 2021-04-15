package com.cg.services;

import java.util.List;

import com.cg.entities.LoanRequest;

public interface LoanRequestService{
	
	public List<LoanRequest> addloanRequest(LoanRequest request);
	public List<LoanRequest> updateloanRequest(LoanRequest request);
	public List<LoanRequest> deleteloanRequest(Integer id);
	public List<LoanRequest> viewAllLoanRequests();

}
