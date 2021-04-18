package com.cg.loanrequestservicetest;

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

import com.cg.dao.LoanRequestDao;
import com.cg.entities.LoanRequest;
import com.cg.services.LoanRequestServiceImpl;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
public class Loanrequestservicetest {
	

	@InjectMocks
	LoanRequestServiceImpl requestservice;
	
	@Mock
	LoanRequestDao ldao;
	
	@Test
	public void addLoanRequestTest() {

    Date date = new Date();
    LoanRequest req = new LoanRequest(1,"Home Loan",2,"Vijay",23,60000,"Aurangabad","844415706785",date,"Pending" );
    
    when(ldao.saveAndFlush(req)).thenReturn(req);
   
    assertEquals("Applied Successfully", requestservice.addloanRequest(req));
    
}
    @Test
	public void getLoanRequestByIdTest() {
    	
     Date date = new Date();
     LoanRequest req = new LoanRequest(1,"Home Loan",2,"Vijay",23,60000,"Aurangabad","844415706785",date,"Pending" );
     Date date2 = new Date();
     LoanRequest req2 = new LoanRequest(2,"Car Loan",3,"Rahul",23,50000,"Panvel","844415706785",date2,"Pending" );
	 ldao.saveAndFlush(req);
	 ldao.saveAndFlush(req2);
     when(ldao.findById(req.getCustid())).thenReturn(Optional.of(req));
     assertEquals(req, requestservice.getRequestById(req.getCustid()));
    }
    
    
	
    @Test
    public void viewAllLoanRequestsTest() {
    	
 	  List<LoanRequest> list = new ArrayList<>();
 	   
 	  Date date1 = new Date();
      LoanRequest req1 = new LoanRequest(1,"Home Loan",2,"Vijay",23,60000,"Aurangabad","844415706785",date1,"Pending" );
      
      Date date2 = new Date();
      LoanRequest req2 = new LoanRequest(2,"Car Loan",3,"Rahul",23,50000,"Panvel","844415706785",date2,"Pending" );
      list.add(req1);
      list.add(req2);
      
      when(ldao.findAll()).thenReturn(list);
      List<LoanRequest> requestList = requestservice.viewAllLoanRequests();
      assertEquals(2, requestList.size());
      verify(ldao, times(1)).findAll();

    }
    
    
    @Test
    public void verifyLoanRequestTest() {
    	Date date = new Date();
        LoanRequest req  = new LoanRequest(1,"Home Loan",2,"Vijay",23,60000,"Aurangabad","844415706785",date,"Pending" );
       
        assertEquals("Approved", requestservice.verifyLoanRequest(req));
    	
    }
	
	
	
	
}