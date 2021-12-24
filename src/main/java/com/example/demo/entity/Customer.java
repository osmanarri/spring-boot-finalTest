package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long customerId;
	
	@NotNull
	@Size(min=2, max=30)
	private String customerFirstName;
	
	@NotNull
	@Size(min=1, max=30)
	private String customerLastName;
	
	
	@Min(1960)
	@Max(1990)
	private int birthDateYear;
	
	@NotEmpty
	private String address;
	
	@NotEmpty
	private String language;

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public int getBirthDateYear() {
		return birthDateYear;
	}

	public void setBirthDateYear(int birthDateYear) {
		this.birthDateYear = birthDateYear;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Customer(String customerFirstName, String customerLastName, int birthDateYear, String address,
			String language) {
		super();
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.birthDateYear = birthDateYear;
		this.address = address;
		this.language = language;
	}
	
	public Customer() {
		
	}

}
