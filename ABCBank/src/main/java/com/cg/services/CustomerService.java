package com.cg.services;

import java.util.List;

import com.cg.entities.Customer;
import com.cg.entities.LoanRequest;

public interface CustomerService {
	
	public List<Customer> addCustomer(Customer c);
	public List<Customer> updateCustomer(Customer c);
	public List<Customer> removeCustomer(Integer id);
	public Customer getCustomerById(Integer id);
    public void applyForLoan(LoanRequest request);
    
   
}
