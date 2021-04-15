package com.cg.services;

import java.util.List;

import com.cg.entities.Customer;

public interface CustomerService {
	
	public List<Customer> addCustomer(Customer c);
	public List<Customer> updateCustomer(Customer c);
	public List<Customer> removeCustomer(Integer id);
	public List<Customer> viewAllCustomers();

}
