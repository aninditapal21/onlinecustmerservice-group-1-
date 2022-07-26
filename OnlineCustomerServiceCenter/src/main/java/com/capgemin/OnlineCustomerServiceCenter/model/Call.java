package com.capgemin.OnlineCustomerServiceCenter.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
@Entity
@Table(name="call_table")

public class Call {
	@Id
	private int callId;
	private Date callDate;
	private double callDuration;
	@Pattern(regexp="[789]{1}[0-9]{9}",message="the mobile number should be start with 7 or 8 or 9 and it should be 10 digit in call table")
	private String phoneNumber;
	@OneToOne
	@JoinColumn(name="customer_Id")
	private Customer customer;
	@OneToOne
	@JoinColumn(name="operator_Id")
	private Operator operator;

	public Operator getOperator() {
		return operator;
	}
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	public int getCallId() {
		return callId;
	}
	public void setCallId(int callId) {
		this.callId = callId;
	}
	public Date getCallDate() {
		return callDate;
	}
	public void setCallDate(Date callDate) {
		this.callDate = callDate;
	}
	public double getCallDuration() {
		return callDuration;
	}
	public void setCallDuration(double callDuration) {
		this.callDuration = callDuration;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
