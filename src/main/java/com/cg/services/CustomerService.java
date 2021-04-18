package com.cg.services;

import java.util.List;

import com.cg.entities.Customer;
import com.cg.entities.LoanRequest;

public interface CustomerService {
	
	public Customer addCustomer(Customer c);
	public Customer getCustomerById(Integer id);
    public String applyForLoan(LoanRequest request);
    public List<Customer> viewAllCustomers();
    
    public double checkEmi(String scheme, double amount, double period);
   
}
