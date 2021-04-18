package com.cg.customerservicetest;



import static org.junit.Assert.assertEquals;


import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.entities.Customer;
import com.cg.entities.LoanRequest;
import com.cg.dao.CustomerDao;
import com.cg.dao.LoanRequestDao;
import com.cg.services.CustomerServiceImpl;
import com.cg.services.LoanRequestServiceImpl;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
public class CustomerServiceTest {

	@InjectMocks
	CustomerServiceImpl service;
	
	@Mock
	CustomerDao dao;
	
	
	@InjectMocks
	LoanRequestServiceImpl requestservice;
	
	@Mock
	LoanRequestDao ldao;

   @Test
   public void getAllCustomersTest(){

	   List<Customer> list = new ArrayList<Customer>();
       Customer c1 = new Customer(1,"Rahul","9881637389","khanerahul98@gmail.com","Itachi@7");
       Customer c2 = new Customer(2,"Rohit","9481637689","khanerohit98@gmail.com","Hitachi@7");
       Customer c3 = new Customer(3,"Akash","9281637389","khaneakash98@gmail.com","Otachi@7");
       list.add(c1);
       list.add(c2);
       list.add(c3);
       
       when(dao.findAll()).thenReturn(list);
       List<Customer> empList = service.viewAllCustomers();
       assertEquals(3, empList.size());
       verify(dao, times(1)).findAll();

}
   
   @Test
   public void addCustomerTest() {
	   
	   Customer c = new Customer(1,"Rahul","9881637389","khanerahul98@gmail.com","Itachi@7");
	   
	   when(dao.saveAndFlush(c)).thenReturn(c);
	
	   assertEquals(c, service.addCustomer(c));
   }
   
   @Test
   public void applyForLoan() {
	   Date date = new Date();
	   LoanRequest req = new LoanRequest(1,"Home Loan",2,"Vijay",23,60000,"Aurangabad","844415706785",date,"Pending" );
	   
	   when(ldao.saveAndFlush(req)).thenReturn(req);
	   
	   assertEquals("Applied Successfully", requestservice.addloanRequest(req));
   }
   
   @Test
   public void getCustomerById() {
	   
	   Customer c =  new Customer(2,"Rahul","9881637389","khanerahul98@gmail.com","Itachi@7");
	   Customer c2 = new Customer(3,"Rahul","9881637389","khanerahul98@gmail.com","Itachi@7");
	 
	   dao.saveAndFlush(c);
	   dao.saveAndFlush(c2);
	   when(dao.findById(c.getCustid())).thenReturn(Optional.of(c));
	   assertEquals(c, service.getCustomerById(c.getCustid()));
   }
   
  
}
   
