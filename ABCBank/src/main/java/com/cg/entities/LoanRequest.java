package com.cg.entities;

import java.util.Date;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.ws.rs.DefaultValue;

import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name="loanrequest")
public class LoanRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int loan_sid;
	private String loantype;
	private int cust_id;
	private String cust_name;
	private int age;
	private long income;
	private String address;
	private long adhar_no;
	private Date date;
	private String status;
	
	public LoanRequest() {
		
	}

	public LoanRequest(int loan_sid, String loantype, int cust_id, String cust_name, int age, long income,
			String address, long adhar_no, Date date, String status) {
		super();
		this.loan_sid = loan_sid;
		this.loantype = loantype;
		this.cust_id = cust_id;
		this.cust_name = cust_name;
		this.age = age;
		this.income = income;
		this.address = address;
		this.adhar_no = adhar_no;
		this.date = date;
		this.status = status;
	}

	public int getLoan_sid() {
		return loan_sid;
	}

	public void setLoan_sid(int loan_sid) {
		this.loan_sid = loan_sid;
	}

	public String getLoantype() {
		return loantype;
	}

	public void setLoantype(String loantype) {
		this.loantype = loantype;
	}

	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getIncome() {
		return income;
	}

	public void setIncome(long income) {
		this.income = income;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getAdhar_no() {
		return adhar_no;
	}

	public void setAdhar_no(long adhar_no) {
		this.adhar_no = adhar_no;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "LoanRequest [loan_sid=" + loan_sid + ", loantype=" + loantype + ", cust_id=" + cust_id + ", cust_name="
				+ cust_name + ", age=" + age + ", income=" + income + ", address=" + address + ", adhar_no=" + adhar_no
				+ ", date=" + date + ", status=" + status + "]";
	}
	
	
	

}
