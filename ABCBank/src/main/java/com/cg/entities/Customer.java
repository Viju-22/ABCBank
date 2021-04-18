package com.cg.entities;

import java.io.Serializable;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="customer")
public class Customer implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int custid;
	
	@NotBlank( message ="Customer Name is Mandatory")
	@Size(min=5 , max = 20 , message ="Customer Name must be between 5-20 characters")
	private String name;
	
	@NotBlank(message="Contact Number is mandatory")
	@Pattern(regexp= "[0-9]{10}", message ="Enter Valid Contact Number")
	private String mobile;
	
	@NotBlank(message="Email is mandatory")
	@Pattern(regexp= "[A-Za-z0-9]+@[A-Za-z0-9.-]+[.][A-Za-z]{2,4}", message ="Invalid Pattern for Email")
	private String email;
	
	@NotBlank(message="Password is mandatory")
	@Pattern(regexp= "[A-Za-z]+@[0-9]+", message ="Invalid Pattern for Password")
	private String password;

	public Customer(int custid,
			@NotBlank(message = "Customer Name is Mandatory") @Size(min = 5, max = 20, message = "Customer Name must be between 5-20 characters") String name,
			@NotBlank(message = "Contact Number is mandatory") @Pattern(regexp = "[0-9]{10}", message = "Enter Valid Contact Number") String mobile,
			@NotBlank(message = "Email is mandatory") @Pattern(regexp = "[A-Za-z0-9]+@[A-Za-z0-9.-]+[.][A-Za-z]{2,4}", message = "Invalid Pattern for Email") String email,
			@NotBlank(message = "Password is mandatory") @Pattern(regexp = "[A-Za-z]+@[0-9]+", message = "Invalid Pattern for Password") String password) {
		super();
		this.custid = custid;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
	}

	public Customer() {
		
	}

	public int getCustid() {
		return custid;
	}

	public void setCustid(int custid) {
		this.custid = custid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String string) {
		this.mobile = string;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Customer [custid=" + custid + ", name=" + name + ", mobile=" + mobile + ", email=" + email
				+ ", password=" + password + "]";
	}
	
	
	
}