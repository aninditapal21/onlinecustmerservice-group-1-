package com.capgemin.OnlineCustomerServiceCenter.exception;

public class InvalidDepartmentException extends Exception{
	public InvalidDepartmentException() {
		super();
	}
	public InvalidDepartmentException(String errorMsg) {
		super(errorMsg);
	}
}
