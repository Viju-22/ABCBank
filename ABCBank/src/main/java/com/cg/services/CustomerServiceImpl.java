package com.cg.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.CustomerDao;
import com.cg.dao.LoanRequestDao;
import com.cg.entities.Customer;
import com.cg.entities.LoanRequest;

@Service("customerservice")
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerDao cdao;
	
	@Autowired
	LoanRequestDao requestdao;

	@Override
	public Customer addCustomer(Customer c) {
		cdao.saveAndFlush(c);
		return c;
	}

	@Override
	public Customer getCustomerById(Integer id) {
		Optional<Customer> customer = cdao.findById(id);
		return customer.get();
	}

	@Override
	public String applyForLoan(LoanRequest request) {
		requestdao.saveAndFlush(request);
		return "Applied Successfully";
	}

	@Override
	public List<Customer> viewAllCustomers() {
		
		return cdao.findAll();
	}

	@Override
	public double checkEmi(String scheme, double amount, double period) {
		double emi=0;
		double rate=0;
		double am = amount;
		double time= period;
		
		switch(scheme) {
		
		case "Home Loan":
			
			rate=(am*12)/100;
			emi = (am + rate)/time;
		    break;
		
		case "Car Loan":
			
			rate=(am*15)/100;
			emi = (am + rate)/time;
		    break;
		
		case "Medical Loan":
			rate=(am* 14)/100;
			emi = (am + rate)/time;
		    break;
		    
		case "Education Loan":
			rate=(am*8)/100;
			emi = (am + rate)/time;
		    break;
		}
		
		return emi;
	
	}


}
