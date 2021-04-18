package com.cg.entities;

import java.io.Serializable;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Entity
@Table(name="loanrequest")
public class LoanRequest implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int requestid;
	
	@NotBlank( message ="Loan type is Mandatory")
	private String loantype;
	
	@NotNull
	private int custid;
	
	@NotBlank(message="Customer Name is mandatory")
	private String custname;
	
	@NotNull
	private int age;
	
	@NotNull
	private double income;
	
	@NotBlank(message="Address is mandatory")
	private String address;
	
	@NotBlank(message="Contact Number is mandatory")
	@Pattern(regexp= "[0-9]{12}", message ="Enter Valid Adhar Number")
	private String adharno;
	
	private Date date;
	
	 @Column(columnDefinition = "varchar(255) default 'Pending'")
	 private String status;



	public LoanRequest() {
	
	}



	public LoanRequest(int requestid, @NotBlank(message = "Loan type is Mandatory") String loantype,
			@NotNull int custid, @NotBlank(message = "Customer Name is mandatory") String custname, @NotNull int age,
			@NotNull double income, @NotBlank(message = "Address is mandatory") String address,
			@NotBlank(message = "Contact Number is mandatory") @Pattern(regexp = "[0-9]{12}", message = "Enter Valid Adhar Number") String adharno,
			Date date, String status) {
		super();
		this.requestid = requestid;
		this.loantype = loantype;
		this.custid = custid;
		this.custname = custname;
		this.age = age;
		this.income = income;
		this.address = address;
		this.adharno = adharno;
		this.date = date;
		this.status = status;
	}



	public int getRequestid() {
		return requestid;
	}



	public void setRequestid(int requestid) {
		this.requestid = requestid;
	}



	public String getLoantype() {
		return loantype;
	}



	public void setLoantype(String loantype) {
		this.loantype = loantype;
	}



	public int getCustid() {
		return custid;
	}



	public void setCustid(int custid) {
		this.custid = custid;
	}



	public String getCustname() {
		return custname;
	}



	public void setCustname(String custname) {
		this.custname = custname;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public double getIncome() {
		return income;
	}



	public void setIncome(double income) {
		this.income = income;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getAdharno() {
		return adharno;
	}



	public void setAdharno(String adharno) {
		this.adharno = adharno;
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



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public String toString() {
		return "LoanRequest [requestid=" + requestid + ", loantype=" + loantype + ", custid=" + custid + ", custname="
				+ custname + ", age=" + age + ", income=" + income + ", address=" + address + ", adharno=" + adharno
				+ ", date=" + date + ", status=" + status + "]";
	}
	
	

}
