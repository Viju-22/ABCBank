package com.cg.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entities.LoanScheme;
import com.cg.exceptions.LoanSchemeNotFoundException;
import com.cg.services.LoanSchemeService;

import io.swagger.annotations.Api;

@Api
@RestController()
@RequestMapping("/admin")
public class AdminController {
    
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	LoanSchemeService loanschemeservice;
	
	@PostMapping("/addscheme")
	public List<LoanScheme> addLoanScheme(@RequestBody LoanScheme l){
		
		return loanschemeservice.addLoanScheme(l);
		
	}
	
	@PutMapping("/updatescheme")
	public List<LoanScheme> updateLoanScheme(@RequestBody LoanScheme l){
		
		return loanschemeservice.updateLoanScheme(l);
		
	}
	
	public LoanScheme getLoanSchemeById(@PathVariable Integer id) throws LoanSchemeNotFoundException {
		logger.info("In Admin Controller to retrieve an Loan Scheme by Id ..>!!!");
		 
		LoanScheme l = null;
		try{
			logger.info("LoanScheme Id to be searched..."+id);
			l = loanschemeservice.getSchemeById(id);
		}catch(Exception e) {
			
			throw new LoanSchemeNotFoundException("Enter valid LoanScheme id ");
		}
		
		return l;
	}
	
	@DeleteMapping("/deletescheme/{id}")
	public List<LoanScheme> deleteLoanScheme(@PathVariable Integer id) throws LoanSchemeNotFoundException{
		
		logger.info("In Admin Controller to delete LoanScheme by Id ..>!!!");
		
	
		try{
			logger.info("LoanScheme Id to be deleted..."+id);
			loanschemeservice.getSchemeById(id);
		}catch(Exception e) {
			logger.info("In catch block of DeleteAdminById() ...!");
			throw new LoanSchemeNotFoundException("Enter an existing  LoanRequest id to be deleted  ");
		}
		
		
		return loanschemeservice.deleteLoanScheme(id);
		
	}
	
	@GetMapping("/viewallscheme")
	public List<LoanScheme> viwlAllLoanSchemes(){
		return loanschemeservice.viewAllScheme();
	}
	
	
	
	
}
