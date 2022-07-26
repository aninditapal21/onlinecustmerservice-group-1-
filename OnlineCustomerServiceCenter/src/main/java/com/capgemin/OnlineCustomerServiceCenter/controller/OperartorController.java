package com.capgemin.OnlineCustomerServiceCenter.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemin.OnlineCustomerServiceCenter.dao.AdminDao;
import com.capgemin.OnlineCustomerServiceCenter.dao.EmailServiceImpl;
import com.capgemin.OnlineCustomerServiceCenter.dao.OperatorDao;
import com.capgemin.OnlineCustomerServiceCenter.exception.InvalidCustomerException;
import com.capgemin.OnlineCustomerServiceCenter.exception.InvalidLoginException;
import com.capgemin.OnlineCustomerServiceCenter.exception.InvalidOperatorException;
import com.capgemin.OnlineCustomerServiceCenter.exception.IssueCreationException;
import com.capgemin.OnlineCustomerServiceCenter.model.Customer;
import com.capgemin.OnlineCustomerServiceCenter.model.Emaildetails;
import com.capgemin.OnlineCustomerServiceCenter.model.Issue;
import com.capgemin.OnlineCustomerServiceCenter.model.Login;

@RestController
@CrossOrigin("http://localhost:4500/")
public class OperartorController {

	@Autowired
	private OperatorDao operatorDao;
	
	@Autowired
	private EmailServiceImpl emailDao;
	
	
	Logger log=LoggerFactory.getLogger(OperartorController.class);
	
	
	@PostMapping(path="/operatorlogin/{optId}")
	public String login(@Valid  @RequestBody Login login,@PathVariable int optId) throws InvalidLoginException{
		return operatorDao.login(login);
	}
	@PostMapping(path="/addCustomerIssue")
	public Issue addCustomerIssue(@Valid @RequestBody  Issue issue) throws IssueCreationException{
		log.info("Customer Issue is created");
		return operatorDao.addCustomerIssue(issue);
	}
	@PutMapping(path="/sendIntimationEmail/{custId}")
	public String sendIntimationEmail(@RequestBody Emaildetails details,@PathVariable int custId) throws InvalidCustomerException{
		log.info("Intimation mail is sending");
		return emailDao.sendIntimationEmail(details, custId);
	}
	@PutMapping(path="/modifiCustomerIssue/{optId}")
	public Issue modifyCustomerIssue(@Valid @RequestBody Issue issue,@PathVariable int optId) {
		return operatorDao.modifyCustomerIssue(issue);
	}

	@PutMapping(path="/sendModificationEmail/{custId}/{optId}")
	public String sendModificationEmail(@RequestBody  Emaildetails details,@PathVariable int custId,@PathVariable  int optId) throws InvalidOperatorException,InvalidCustomerException {
		log.info("Modification mail is sending");
		return emailDao.sendModificationEmail(details, custId, optId);
	}
	@GetMapping(path="/closeCustomerIssue/{optId}")
	public Issue closeCustomerIssue(@PathVariable int optId) {
		log.info("Now this customer login Id is close");
		return operatorDao.closeCustomerIssue(optId);
	}
	@GetMapping(path="/findCustomerById/{optId}")
	public Customer findCustomerById(@PathVariable int optId) throws InvalidOperatorException {
		return operatorDao.findCustomerById(optId);
	}
	@GetMapping(path="/findCustomerByName/{optName}")
	public List<Customer> findCustomerByName(@PathVariable String optName){
		return operatorDao.findCustomerByName(optName);
	}
	@GetMapping(path="/findCustomerByEmail/{optEmail}")
	public Customer findCustomerByEmail(@PathVariable String optEmail) {
		return operatorDao.findCustomerByEmail(optEmail);
	}
	@GetMapping(path="/lockCustomer/{optId}")
	public Customer lockCustomer(@PathVariable int optId)  {
		return operatorDao.lockCustomer(optId);
	}
	
	@GetMapping(path="/get/allIssue")
	public List<Issue> findAllIssue(){
		return operatorDao.findAllIssue();
	}
	
	@GetMapping(path="/get/allCustomer")
	public List<Customer> findAllCustomer(){
		return operatorDao.findAllCustomer();
	}
	@GetMapping(path="/findIssueById/{optId}")
	public Issue findIssueById(@PathVariable int optId) {
		return operatorDao.findIssueById(optId);
	}
	@GetMapping(path="/findCustomerByOpt/{custId}")
	public int findOperatorById( @PathVariable int custId) {
		return operatorDao.findOperatorById(custId);
	}
	
	
	
	
}
