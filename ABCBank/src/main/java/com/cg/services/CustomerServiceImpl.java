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
	public List<Customer> addCustomer(Customer c) {
		cdao.saveAndFlush(c);
		return cdao.findAll();
	}

	@Override
	public List<Customer> updateCustomer(Customer c) {
		cdao.saveAndFlush(c);
		return cdao.findAll();
	}

	@Override
	public List<Customer> removeCustomer(Integer id) {
		cdao.deleteById(id);
		return cdao.findAll();
	}

	@Override
	public void applyForLoan(LoanRequest request) {
		requestdao.saveAndFlush(request);
	}

	@Override
	public Customer getCustomerById(Integer id) {
		Optional<Customer> customer = cdao.findById(id);
		return customer.get();
	}


}
