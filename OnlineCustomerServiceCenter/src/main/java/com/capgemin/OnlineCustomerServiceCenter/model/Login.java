package com.capgemin.OnlineCustomerServiceCenter.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

//import org.hibernate.usertype.UserType;

//import org.hibernate.usertype.UserType;
@Entity
@Table(name="login_table")
public class Login {
	@Id
	private int username;
	//@Pattern(regexp="[A-Z]{1}[0-9]{2}[A-Za-z]{1}",message="first character should be apphabet and uppercase,next two characters shoulbe be digit,password must conatin atleast one special character,password should have min length shoule be 5 and the last character in password should be only one alphabet")
	//@NotBlank(message="password should not be null")
	private String password;
	//@Enumerated(EnumType.STRING)
	private String type;
	//private UserType type;
	private boolean isActive;
	public int getUsername() {
		return username;
	}
	public void setUsername(int username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
}
