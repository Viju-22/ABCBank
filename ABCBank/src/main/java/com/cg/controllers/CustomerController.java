package com.cg.controllers;

import java.util.List;





import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.entities.Customer;
import com.cg.entities.LoanRequest;
import com.cg.exceptions.CustomerNotFoundException;
import com.cg.services.CustomerService;
import com.cg.services.LoanRequestService;

import io.swagger.annotations.Api;

@Api
@RestController
@RequestMapping("/customer")
public class CustomerController {

	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	CustomerService custservice;

	@Autowired
	LoanRequestService requestservice;

	@Autowired
	RestTemplate restTemplate;

	@PostMapping("/applyforloan")
	public String applyForLoan(@RequestBody LoanRequest request) {
		logger.info("Applying for a Loan Scheme");
		requestservice.addloanRequest(request);
		return "Applied Successfully";
	}

	@PostMapping("/addcustomer")
	public List<Customer> addCustomer(@RequestBody Customer c) {

		return custservice.addCustomer(c);

	}

	@PutMapping("/updatecustomer")
	public List<Customer> updateCustomer(@RequestBody Customer c) {
		return custservice.updateCustomer(c);
	}
	
	@GetMapping("/getcustomerbyid")
	public Customer getCustomerbyId(@PathVariable Integer id) throws CustomerNotFoundException {
		
		logger.info("In Customer Controller to retrieve an Customer by Id ..>!!!");
		 
		Customer cust = null;
		try{
			logger.info("Customer Id to be searched..."+id);
			cust = custservice.getCustomerById(id);
		}catch(Exception e) {

			throw new CustomerNotFoundException("Enter valid Customer id ");
		}	
		return cust;
	}

	@DeleteMapping("/removecustomer/{id}") 
	public List<Customer> removeCustomer(@PathVariable Integer id) throws CustomerNotFoundException {
		logger.info("In Customer Controller to remove Customer by Id..>!!!");
		Customer cust = null;
		try{
			logger.info("Customer Id to be searched..."+id);
			cust = custservice.getCustomerById(id);
		}catch(Exception e) {
			
			throw new CustomerNotFoundException("Enter valid Customer id ");
		}
		
		return custservice.removeCustomer(id);	
	
	}

	@GetMapping(value = "/getschemefromadmin")
	public ResponseEntity<String> getSchemes() {
		String schemes = restTemplate.getForObject("http://localhost/admins/admin/viewallscheme", String.class);
		return ResponseEntity.ok(schemes);
	}

}

