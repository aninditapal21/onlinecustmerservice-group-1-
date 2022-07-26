package com.capgemin.OnlineCustomerServiceCenter.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemin.OnlineCustomerServiceCenter.dao.CustomerDao;
import com.capgemin.OnlineCustomerServiceCenter.dao.EmailServiceImpl;
import com.capgemin.OnlineCustomerServiceCenter.exception.CustomerCreationException;
import com.capgemin.OnlineCustomerServiceCenter.exception.InvalidCustomerException;
import com.capgemin.OnlineCustomerServiceCenter.exception.InvalidLoginException;
import com.capgemin.OnlineCustomerServiceCenter.model.Customer;
import com.capgemin.OnlineCustomerServiceCenter.model.Emaildetails;
import com.capgemin.OnlineCustomerServiceCenter.model.Issue;
import com.capgemin.OnlineCustomerServiceCenter.model.Login;

@RestController
@CrossOrigin("http://localhost:4500/")
public class CustomerController {
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private EmailServiceImpl emailDao;
	
	//create and initialization logger object in log variable
	Logger log=LoggerFactory.getLogger(CustomerController.class);
	
	@PostMapping(path="/loginCustomer")
	public String login(@Valid @RequestBody Login login) throws InvalidLoginException{
		return customerDao.login(login);
	}
	@PostMapping(path="/createCustomer")
	public String registerCustomer(@Valid @RequestBody Customer customer) throws CustomerCreationException{
		return customerDao.registerCustomer(customer);
	}
	@GetMapping(path="/viewIssueById/{customerId}")
	public Issue viewIssueById(@PathVariable int customerId) throws InvalidCustomerException{
		log.info("This is the issue details of the particullar CustomerId");
		return customerDao.viewIssueById(customerId);
	} 
	@GetMapping(path="/getAllIssue")
	public List<Issue> viewAllIssue(){
		log.info("fetch all Issue details");
		return customerDao.viewAllIssue();
	} 
	@PutMapping(path="/changePasswordById/{custId}")
	public String changePassword(@Valid @RequestBody Login login,@PathVariable int custId) {
		log.info("Now your password is updated");
		return customerDao.changePassword(login,custId);
	} 
	@GetMapping(path="/forgotPasswordByID/{cusId}")
	public String forgotPassword(@PathVariable  int cusId) throws InvalidCustomerException{
		return customerDao.forgotPassword(cusId);
	}
	@GetMapping(path="/reopenIssue/{custId}")
	public Issue reopenIssue(@PathVariable int custId) throws InvalidCustomerException {
		return customerDao.reopenIssue(custId);
	}
	@PutMapping(path="/sendEmailPassword/{custId}")
	public String sendPasswordMail(@RequestBody Emaildetails details,@PathVariable int custId) {
		log.info("mail is sennding.....");
		return emailDao.sendPasswordMail(details, custId);
	}
	/*@DeleteMapping(path="/lockCustomer/{custId}")
	public boolean lockCustomer(@PathVariable int custId)  {
		return customerDao.lockCustomer(custId);
	}*/
	
	

}
