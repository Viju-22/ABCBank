package com.cg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.LoanSchemeDao;
import com.cg.entities.LoanScheme;

@Service("loanschemeservice")
public class LoanSchemeServiceImpl implements LoanSchemeService {
	
	@Autowired
	LoanSchemeDao schemedao;

	@Override
	public List<LoanScheme> addLoanScheme(LoanScheme ls) {
		schemedao.saveAndFlush(ls);
		return schemedao.findAll();
	}

	@Override
	public List<LoanScheme> updateLoanScheme(LoanScheme ls) {
		schemedao.saveAndFlush(ls);
		return schemedao.findAll();
	}

	@Override
	public List<LoanScheme> deleteLoanScheme(Integer id) {
		schemedao.deleteById(id);
		return schemedao.findAll();
	}

	@Override
	public List<LoanScheme> viewAllScheme() {
		
		return schemedao.findAll();
	}

}
