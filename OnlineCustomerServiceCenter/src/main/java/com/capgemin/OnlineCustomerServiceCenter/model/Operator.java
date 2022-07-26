package com.capgemin.OnlineCustomerServiceCenter.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
@Entity
@Table(name="operator_table")
public class Operator {
	@Id
	private int operatorId;
	//@NotBlank(message="operator name should not be null")
	private String firstName;
	private String lastName;
	@Pattern(regexp="[A-Za-z0-9_]+[@]{1}[a-zA-Z]+[.]{1}[a-z]{3}",message="The email id should be proper email format")
	private String email;
	@Pattern(regexp="[789]{1}[0-9]{9}",message="the mobile number should be start with 7 or 8 or 9 and it should be 10 digit")
	private String mobile;
	private String city;
	
	private String deletedFlag="N";
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="department_Id")
	private Department department;
	
	public int getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(int operatorId) {
		this.operatorId = operatorId;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
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
	public String getDeletedFlag() {
		return deletedFlag;
	}
	public void setDeletedFlag(String deletedFlag) {
		this.deletedFlag = deletedFlag;
	}
	
	
}
