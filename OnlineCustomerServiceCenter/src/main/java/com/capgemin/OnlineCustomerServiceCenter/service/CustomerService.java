package com.capgemin.OnlineCustomerServiceCenter.service;

import java.util.List;

import com.capgemin.OnlineCustomerServiceCenter.exception.CustomerCreationException;
import com.capgemin.OnlineCustomerServiceCenter.exception.InvalidCustomerException;
import com.capgemin.OnlineCustomerServiceCenter.exception.InvalidLoginException;
import com.capgemin.OnlineCustomerServiceCenter.model.Customer;
import com.capgemin.OnlineCustomerServiceCenter.model.Issue;
import com.capgemin.OnlineCustomerServiceCenter.model.Login;

public interface CustomerService {
	
	public String login(Login login) throws InvalidLoginException;
	public String registerCustomer(Customer customer)throws CustomerCreationException;
	public Issue viewIssueById(int customerId)throws InvalidCustomerException;
	public Issue reopenIssue(int customerId) throws InvalidCustomerException;
	public List<Issue> viewAllIssue();
	public String changePassword(Login login,int custId);
	public String forgotPassword(int customerId) throws InvalidCustomerException;
	public Customer emailPassword(int customerId);
	
	//public Customer lockCustomer(int customerId);
	
	
	
}
