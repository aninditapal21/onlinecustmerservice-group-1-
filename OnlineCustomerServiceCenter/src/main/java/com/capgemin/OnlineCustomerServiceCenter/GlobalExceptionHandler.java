package com.capgemin.OnlineCustomerServiceCenter;

import java.time.LocalDateTime;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capgemin.OnlineCustomerServiceCenter.exception.CustomerCreationException;
import com.capgemin.OnlineCustomerServiceCenter.exception.DepartmentCreationException;
import com.capgemin.OnlineCustomerServiceCenter.exception.ErrorMessage;
import com.capgemin.OnlineCustomerServiceCenter.exception.InvalidCustomerException;
import com.capgemin.OnlineCustomerServiceCenter.exception.InvalidDepartmentException;
import com.capgemin.OnlineCustomerServiceCenter.exception.InvalidLoginException;
import com.capgemin.OnlineCustomerServiceCenter.exception.InvalidOperatorException;
import com.capgemin.OnlineCustomerServiceCenter.exception.IssueCreationException;
import com.capgemin.OnlineCustomerServiceCenter.exception.OperatorCreationException;

//import com.capgemini.May10thSpringBootDemo3.exception.BookCreationException;
//import com.capgemini.May10thSpringBootDemo3.exception.ErrorMessage;
//import com.capgemini.May10thSpringBootDemo3.exception.InvalidBookException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(DepartmentCreationException.class)
	public @ResponseBody ErrorMessage checkDepartmentCreationException(DepartmentCreationException e) {
		ErrorMessage error1=new ErrorMessage(LocalDateTime.now(), e.getMessage());
		return error1;
	}
	@ExceptionHandler(InvalidDepartmentException.class)
	public @ResponseBody ErrorMessage checkInvalidDepartmentException(InvalidDepartmentException e){
		ErrorMessage error1=new ErrorMessage(LocalDateTime.now(), e.getMessage());
		return error1;
	}
	@ExceptionHandler(CustomerCreationException.class)
	public @ResponseBody ErrorMessage checkCustomerCreationException(CustomerCreationException e) {
		ErrorMessage error1=new ErrorMessage(LocalDateTime.now(), e.getMessage());
		return error1;
	}
	@ExceptionHandler(InvalidCustomerException.class)
	public @ResponseBody ErrorMessage checkInvalidCustomerException(InvalidCustomerException e) {
		ErrorMessage error1=new ErrorMessage(LocalDateTime.now(), e.getMessage());
		return error1;
	}
	
	@ExceptionHandler(OperatorCreationException.class)
	public @ResponseBody ErrorMessage checkOperationCreationException(OperatorCreationException e) {
		ErrorMessage error1=new ErrorMessage(LocalDateTime.now(), e.getMessage());
		return error1;
	}
	@ExceptionHandler(InvalidOperatorException.class)
	public @ResponseBody ErrorMessage checkInvalidOperatorException(InvalidOperatorException e) {
		ErrorMessage error1=new ErrorMessage(LocalDateTime.now(), e.getMessage());
		return error1;
	}
	@ExceptionHandler(IssueCreationException.class)
	public @ResponseBody ErrorMessage checkIssueCreationException(IssueCreationException e) {
		ErrorMessage error1=new ErrorMessage(LocalDateTime.now(), e.getMessage());
		return error1;
	}
	@ExceptionHandler(InvalidLoginException.class)
	public @ResponseBody ErrorMessage checkInvalidLoginException(InvalidLoginException e){
		ErrorMessage error1=new ErrorMessage(LocalDateTime.now(), e.getMessage());
		return error1;
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public @ResponseBody ErrorMessage checkValidation(MethodArgumentNotValidException e) {
		ErrorMessage error1=new ErrorMessage(LocalDateTime.now(), e.getMessage(),e.getBindingResult().toString());
		return error1;
	}
	
}
