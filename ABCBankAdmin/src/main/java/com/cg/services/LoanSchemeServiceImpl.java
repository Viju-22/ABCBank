package com.cg.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.LoanSchemeDao;
import com.cg.entities.LoanScheme;

@Service("loanschemeservice")
public class LoanSchemeServiceImpl implements LoanSchemeService {
	
	@Autowired
	LoanSchemeDao schemedao;

	@Override
	public LoanScheme addLoanScheme(LoanScheme ls) {
		schemedao.saveAndFlush(ls);
		return ls;
	}

	@Override
	public LoanScheme updateLoanScheme(LoanScheme ls) {
		schemedao.saveAndFlush(ls);
		return ls;
	}

	@Override
	public Boolean deleteLoanScheme(Integer id) {
		schemedao.deleteById(id);
		return true;
	}

	@Override
	public List<LoanScheme> viewAllScheme() {
		
		return schemedao.findAll();
	}

	@Override
	public LoanScheme getSchemeById(Integer id) {
		Optional<LoanScheme> scheme = schemedao.findById(id);
		return scheme.get();
	}

}

