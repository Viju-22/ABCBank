package com.cg.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cust_id;
	private String name;
	private String address;
	private int age;
	private long income;
	private String pan;
	private long mobile;
	private String email;
	private long acc_no;
	private Date date;
	
	
	public Customer(int cust_id, String name, String address, int age, long income, String pan, long mobile,
			String email, long acc_no, Date date) {
		super();
		this.cust_id = cust_id;
		this.name = name;
		this.address = address;
		this.age = age;
		this.income = income;
		this.pan = pan;
		this.mobile = mobile;
		this.email = email;
		this.acc_no = acc_no;
		this.date = date;
	}


	public Customer() {
		
	}


	public int getCust_id() {
		return cust_id;
	}


	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
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


	public String getPan() {
		return pan;
	}


	public void setPan(String pan) {
		this.pan = pan;
	}


	public long getMobile() {
		return mobile;
	}


	public void setMobile(long mobile) {
		this.mobile = mobile;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public long getAcc_no() {
		return acc_no;
	}


	public void setAcc_no(long acc_no) {
		this.acc_no = acc_no;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "Customer [cust_id=" + cust_id + ", name=" + name + ", address=" + address + ", age=" + age + ", pan="
				+ pan + ", acc_no=" + acc_no + "]";
	}
	
	
	
	
	

}
