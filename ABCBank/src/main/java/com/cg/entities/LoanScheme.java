package com.cg.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="loanscheme")
public class LoanScheme {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int loan_id;
	private String loan_type;
	
	
	public LoanScheme() {
	
	}

	public LoanScheme(int loan_id, String loan_type) {
		super();
		this.loan_id = loan_id;
		this.loan_type = loan_type;
	}

	public int getLoan_id() {
		return loan_id;
	}

	public void setLoan_id(int loan_id) {
		this.loan_id = loan_id;
	}

	public String getLoan_type() {
		return loan_type;
	}

	public void setLoan_type(String loan_type) {
		this.loan_type = loan_type;
	}

	@Override
	public String toString() {
		return "LoanScheme [loan_id=" + loan_id + ", loan_type=" + loan_type + "]";
	}
	
	
	
	

}
