package com.cg.services;

import java.util.List;

import com.cg.entities.LoanScheme;


public interface LoanSchemeService {
	
	public List<LoanScheme> addLoanScheme(LoanScheme ls);
	public List<LoanScheme> updateLoanScheme(LoanScheme ls);
	public List<LoanScheme> deleteLoanScheme(Integer id);
	public List<LoanScheme> viewAllScheme();

}
