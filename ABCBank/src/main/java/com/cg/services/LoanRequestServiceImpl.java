package com.cg.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.LoanRequestDao;
import com.cg.entities.LoanRequest;

@Service("loanrequestservice")
public class LoanRequestServiceImpl implements LoanRequestService{
	
	@Autowired
	LoanRequestDao requestdao;

	@Override
	public void addloanRequest(LoanRequest request) {
		requestdao.saveAndFlush(request);
		
	}

	@Override
	public List<LoanRequest> verifyLoanRequest(LoanRequest request) {
		
		LoanRequest result = request;
		if(request.getAge() >=20 && request.getAge()<=40 && request.getIncome()>50000) {
			result.setStatus("Approved");
		}else {
			result.setStatus("Rejected");
		}
		requestdao.saveAndFlush(result);
		return requestdao.findAll();
	}

	@Override
	public List<LoanRequest> deleteloanRequest(Integer id) {
		requestdao.deleteById(id);
		return requestdao.findAll();
	}

	@Override
	public List<LoanRequest> viewAllLoanRequests() {
		return requestdao.findAll();
	}

	@Override
	public LoanRequest getRequestById(Integer id) {
		Optional<LoanRequest> loanrequest = requestdao.findById(id);
		return loanrequest.get();
	}

}
