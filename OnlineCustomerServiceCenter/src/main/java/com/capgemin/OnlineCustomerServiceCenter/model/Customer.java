package com.capgemin.OnlineCustomerServiceCenter.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="customer_table")
public class Customer {
	@Id
	private int customerId;
	@NotBlank(message="customer name should not be null")
	private String firstName;
	private String lastName;
	@Pattern(regexp="[A-Za-z0-9_]+[@]{1}[a-zA-Z]+[.]{1}[a-z]{3}",message="The email id should be proper email format")
	private String email;
	@Pattern(regexp="[789]{1}[0-9]{9}",message="the mobile number should be start with 7 or 8 or 9 and it should be 10 digit")
	private String mobile;
	private String city;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Login login;
	
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
}
