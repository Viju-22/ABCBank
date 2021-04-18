package com.cg.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="loanscheme")
public class LoanScheme {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int loanid;
	
	@NotBlank(message = "Loan type is mandatory")
	private String loantype;
	
	@NotNull
	private float rate;
	
	
	public LoanScheme() {
	
	}


	public LoanScheme(int loanid, @NotBlank(message = "Loan type is mandatory") String loantype, @NotNull float rate) {
		super();
		this.loanid = loanid;
		this.loantype = loantype;
		this.rate = rate;
	}


	public int getLoanid() {
		return loanid;
	}


	public void setLoanid(int loanid) {
		this.loanid = loanid;
	}


	public String getLoantype() {
		return loantype;
	}


	public void setLoantype(String loantype) {
		this.loantype = loantype;
	}


	public float getRate() {
		return rate;
	}


	public void setRate(float rate) {
		this.rate = rate;
	}


	@Override
	public String toString() {
		return "LoanScheme [loanid=" + loanid + ", loantype=" + loantype + ", rate=" + rate + "]";
	}
	
	

}