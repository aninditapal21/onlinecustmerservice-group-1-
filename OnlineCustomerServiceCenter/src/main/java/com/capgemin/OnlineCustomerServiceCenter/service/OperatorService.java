package com.capgemin.OnlineCustomerServiceCenter.service;

import java.util.List;

import com.capgemin.OnlineCustomerServiceCenter.exception.InvalidCustomerException;
import com.capgemin.OnlineCustomerServiceCenter.exception.InvalidLoginException;
import com.capgemin.OnlineCustomerServiceCenter.exception.InvalidOperatorException;
import com.capgemin.OnlineCustomerServiceCenter.exception.IssueCreationException;
import com.capgemin.OnlineCustomerServiceCenter.model.Customer;
import com.capgemin.OnlineCustomerServiceCenter.model.Issue;
import com.capgemin.OnlineCustomerServiceCenter.model.Login;

public interface OperatorService {
	public String login(Login login) throws InvalidLoginException;
	public Issue addCustomerIssue(Issue issue) throws IssueCreationException;
	public String sendIntimationEmailToCustomer(int customerId,int operatorId) throws InvalidCustomerException;
	public Issue modifyCustomerIssue(Issue issue);
	public String sendModificationEmailToCustomer(int customerId,int operatorId) throws InvalidOperatorException,InvalidCustomerException;
	public Issue closeCustomerIssue(int optId);
	public Customer findCustomerById(int operatorId) throws InvalidOperatorException;
	public List<Customer> findCustomerByName(String optFirstName);
	public Customer findCustomerByEmail(String email);
	public Customer lockCustomer(int customerId);
	
	public List<Issue> findAllIssue();
	
	public Issue findIssueById(int optId);
	public List<Customer> findAllCustomer();
	
	public int findOperatorById(int custId);
	
	
	
}
