package com.cg.adminservicetest;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.dao.LoanSchemeDao;

import com.cg.entities.LoanScheme;
import com.cg.services.LoanSchemeServiceImpl;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
public class LoanSchemeServiceTest {

	@InjectMocks
	LoanSchemeServiceImpl service;

	@Mock
	LoanSchemeDao dao;

	@Test
	public void addLoanSchemeTest() {

		LoanScheme ls = new LoanScheme(1, "Home Loan", 10);

		when(dao.saveAndFlush(ls)).thenReturn(ls);

		assertEquals(ls, service.addLoanScheme(ls));

	}

	@Test
	public void updateLoanSchemeTest() {

		LoanScheme ls = new LoanScheme(1, "Home Loan", 10);
		when(dao.saveAndFlush(ls)).thenReturn(ls);

		assertEquals(ls, service.updateLoanScheme(ls));

	}

	@Test
	public void getAllLoanSchemesTest() {

		List<LoanScheme> list = new ArrayList<>();
		LoanScheme ls1 = new LoanScheme(1, "Home Loan", 10);
		LoanScheme ls2 = new LoanScheme(2, "Car Loan", 15);
		list.add(ls2);
		list.add(ls1);

		when(dao.findAll()).thenReturn(list);
		List<LoanScheme> loanschemeList = service.viewAllScheme();
		assertEquals(2, loanschemeList.size());
		verify(dao, times(1)).findAll();

	}
	
	@Test 
	public void getLoanSchemById() {
		 
		LoanScheme ls1 = new LoanScheme(1,"Home Loan",10);
		LoanScheme ls2 = new LoanScheme(2,"Car Loan",15);
		dao.saveAndFlush(ls1);
		dao.saveAndFlush(ls2);
	
	     when(dao.findById(ls1.getLoanid())).thenReturn(Optional.of(ls1));
	     
	     assertEquals(ls1,service.getSchemeById(ls1.getLoanid()));
	}
}