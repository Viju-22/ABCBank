package com.cg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.CustomerDao;
import com.cg.entities.Customer;

@Service("customerservice")
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerDao cdao;

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
	public List<Customer> viewAllCustomers() {
		return cdao.findAll();
	}
	
	

}
