package com.cg.controllers;

import java.io.Serializable;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entities.LoanRequest;
import com.cg.exceptions.LoanRequestNotFoundException;
import com.cg.services.CustomerService;
import com.cg.services.LoanRequestService;

import io.swagger.annotations.Api;

@Api("Api for LadController")
@RestController()
@RequestMapping("/lad")
@Validated
public class LadController implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private static final Logger logger = LoggerFactory.getLogger(LadController.class);
	
	
	@Autowired
	LoanRequestService requestservice;
	
	
	@PutMapping("/verifyloanrequest")
	public String verifyLoanRequest(@Valid @RequestBody LoanRequest request){
		return requestservice.verifyLoanRequest(request);	
		
	}
	
	@GetMapping("/getloanrequestbyid/{id}")
	public LoanRequest getRequestById(@PathVariable Integer id) throws LoanRequestNotFoundException {
		
		LoanRequest req = null;
		try{
			logger.info("LoanRequest Id to be searched..."+id);
			req = requestservice.getRequestById(id);
		}catch(Exception e) {
			
			throw new LoanRequestNotFoundException("Enter valid LoanRequest id ");
		}
		
		return req;
	}
	
	
	
	@GetMapping("/viewallrequests")
	public List<LoanRequest> viewAllLoanRequests(){
		return requestservice.viewAllLoanRequests();
	}
	
	

}
