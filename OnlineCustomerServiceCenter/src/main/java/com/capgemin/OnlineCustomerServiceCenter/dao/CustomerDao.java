package com.capgemin.OnlineCustomerServiceCenter.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemin.OnlineCustomerServiceCenter.exception.CustomerCreationException;
import com.capgemin.OnlineCustomerServiceCenter.exception.InvalidCustomerException;
import com.capgemin.OnlineCustomerServiceCenter.exception.InvalidLoginException;
import com.capgemin.OnlineCustomerServiceCenter.model.Customer;
import com.capgemin.OnlineCustomerServiceCenter.model.Issue;
import com.capgemin.OnlineCustomerServiceCenter.model.Login;
import com.capgemin.OnlineCustomerServiceCenter.model.UserType;
import com.capgemin.OnlineCustomerServiceCenter.repository.CustomerRepository;
import com.capgemin.OnlineCustomerServiceCenter.repository.IssueRepository;
import com.capgemin.OnlineCustomerServiceCenter.repository.LoginRepository;
import com.capgemin.OnlineCustomerServiceCenter.service.CustomerService;


@Service
public class CustomerDao implements CustomerService{

	@Autowired
	private CustomerRepository customerRepos;
	@Autowired 
	private LoginRepository loginRepos;
	@Autowired
	private IssueRepository issueRepos;
	@Override
	public String login(Login login) throws InvalidLoginException{
		int userName=login.getUsername();
		String passWord=login.getPassword();
		//login.getPassword(equals(passWord))
		
		int custId=customerRepos.getCustomerId(userName);
		if(passWord.equals(loginRepos.getCustomerPassword(custId)) && login.getType().equals("CUSTOMER")) {
			//Login l=loginRepos.save(login);
			System.out.println(login.getType());
			//if(l!=null)
				return "Login";
		}
		else 
			throw new InvalidLoginException("Password is not maching");
		//return "not login";
	}

	@Override
	public String registerCustomer(Customer customer) throws CustomerCreationException{
			if(customerRepos.existsById(customer.getCustomerId()))
				throw new CustomerCreationException("This customer already exits");
			else {
				Login log=customer.getLogin();
				Login l=loginRepos.save(log);
				Customer c=customerRepos.save(customer);
				if(c!=null)
					return "register";
				}
		//}
		//else
			//return "You are not customer";
		return "not register";
	}

	@Override
	public Issue viewIssueById(int customerId) throws InvalidCustomerException{
		// TODO Auto-generated method stub
		if(customerRepos.existsById(customerId)) {
			Issue i=customerRepos.getIssueByCustomerId(customerId);
			return i;
		}
		else
			throw new InvalidCustomerException("Customer Id not present");
		//return null;
	}

	@Override
	public List<Issue> viewAllIssue() {
		// TODO Auto-generated method stub
		List<Issue>issuelist=issueRepos.findAll();
		return issuelist;
	}

	@Override
	public String changePassword(Login login,int custId) {
		// TODO Auto-generated method stub
		int status=0;
		//int loginId=login.getUsername();
		//int custId=customerRepos.getCustomerId(loginId);
		//System.out.println(custId);
		String newPassword=login.getPassword();
		status=customerRepos.changePasswordById(newPassword, custId);
		if(status>=1)
			return "Successfully change";
		return "not change";
	}

	@Override
	public String forgotPassword(int customerId) throws InvalidCustomerException{
		// TODO Auto-generated method stub
		if(customerRepos.existsById(customerId))
			return customerRepos.forgotPassword(customerId);
		else 
			throw new InvalidCustomerException("Customer Id not present");
	}

	@Override
	public Customer emailPassword(int customerId) {
		// TODO Auto-generated method stub
		return customerRepos.emailPassword(customerId);
	}

	@Override
	public Issue reopenIssue(int customerId) throws InvalidCustomerException{
		// TODO Auto-generated method stub
		if(customerRepos.existsById(customerId)) {
			int status=0;
			status =customerRepos.reopenIssue(customerId);
			if(status>=1)
				return customerRepos.getIssueByCustomerId(customerId);
		}
		else 
			throw new InvalidCustomerException("Customer Id not present");
		return null;
	}
	/*@Override
	public boolean lockCustomer(int custId) {
		// TODO Auto-generated method stub
		//if(custRepos.existsById(custId)) {
			int status=customerRepos.lockCustomerByoptId(custId);
			if(status>=1)
				return true;
		//}
		//else 
			//throw new InvalidCustomerException("This operator id is not present");
		return false;
	}*/
	

}
