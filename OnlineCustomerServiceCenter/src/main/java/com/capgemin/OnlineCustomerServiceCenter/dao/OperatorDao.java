package com.capgemin.OnlineCustomerServiceCenter.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemin.OnlineCustomerServiceCenter.exception.InvalidCustomerException;
import com.capgemin.OnlineCustomerServiceCenter.exception.InvalidLoginException;
import com.capgemin.OnlineCustomerServiceCenter.exception.InvalidOperatorException;
import com.capgemin.OnlineCustomerServiceCenter.exception.IssueCreationException;
import com.capgemin.OnlineCustomerServiceCenter.model.Call;
import com.capgemin.OnlineCustomerServiceCenter.model.Customer;
import com.capgemin.OnlineCustomerServiceCenter.model.Issue;
import com.capgemin.OnlineCustomerServiceCenter.model.Login;
import com.capgemin.OnlineCustomerServiceCenter.model.UserType;
import com.capgemin.OnlineCustomerServiceCenter.repository.CustomerRepository;
import com.capgemin.OnlineCustomerServiceCenter.repository.IssueRepository;
import com.capgemin.OnlineCustomerServiceCenter.repository.LoginRepository;
import com.capgemin.OnlineCustomerServiceCenter.repository.OperatorRepository;
import com.capgemin.OnlineCustomerServiceCenter.service.OperatorService;
@Service
public class OperatorDao implements OperatorService{

	@Autowired
	private OperatorRepository operatorRepos;
	@Autowired
	private IssueRepository issueRepos;
	@Autowired
	private LoginRepository loginRepos;
	@Autowired
	private CustomerRepository custRepos;
	
	@Override
	public String login(Login login) throws InvalidLoginException{
		// TODO Auto-generated method stub
		int userName=login.getUsername();
		String passWord=login.getPassword();
		int optId=operatorRepos.getOperatorId(userName);
		if(loginRepos.getAdminPasswordByOptId(optId).equals(passWord) && login.getType().equals("ADMIN")) {
			Login log=loginRepos.save(login);
			if(log!=null)
				return "login";
		}
		else
			throw new InvalidLoginException("Password and user type is incorrect");
		return "not login";
	}

	@Override
	public Issue addCustomerIssue(Issue issue) throws IssueCreationException{
		// TODO Auto-generated method stub
		if(issueRepos.existsById(issue.getIssueId())) 
			throw new IssueCreationException("This Issue is already exits");
		else {
			Issue i=issueRepos.save(issue);
			return i;
		}
	}
	@Override
	public String sendIntimationEmailToCustomer(int customerId, int operatorId) throws InvalidCustomerException{
		// TODO Auto-generated method stub
		if(custRepos.existsById(customerId))
			return operatorRepos.sendIntimationEmailToCustomer(customerId);
		else
			throw new InvalidCustomerException("This customer Id is not valid");
	}
	@Override
	public Issue modifyCustomerIssue(Issue issue) {
		// TODO Auto-generated method stub
		int status=0;
		String iStatus=issue.getIssueStatus();
		int optId=issue.getCall().getOperator().getOperatorId();
		status=operatorRepos.modifyCustomerIssue(iStatus, optId);
		if(status>=1)
			return issue;
		return null;
	}

	@Override
	public String sendModificationEmailToCustomer(int customerId, int operatorId) throws InvalidOperatorException,InvalidCustomerException{
		// TODO Auto-generated method stub
		if(operatorRepos.existsById(operatorId)) {
			int status=operatorRepos.modifyCustomerIssueForEmail(operatorId);
			if(status>=1) {
				if(custRepos.existsById(customerId))
					return operatorRepos.getIssueByCustomerId(customerId);
				else
					throw new InvalidCustomerException("This customer Id is not valid");
			}
		}
		else 
			throw new InvalidOperatorException("This operator Id is not valid");
		return null;
	}
	@Override
	public Issue closeCustomerIssue(int optId) {
		// TODO Auto-generated method stub
		int status=0;
		//int optId=issue.getCall().getOperator().getOperatorId();
		//String iId=issue.getIssueId();
		status= operatorRepos.closeCustomerIssue(optId);
		if(status>=1)
			return operatorRepos.findIssueById(optId);
		return null;
	}
	@Override
	public Customer findCustomerById(int operatorId) throws InvalidOperatorException{
		// TODO Auto-generated method stub
		if(operatorRepos.existsById(operatorId))
			return operatorRepos.findCustomerById(operatorId);
		else 
			throw new InvalidOperatorException("This operator id is not present");
		//return null;
	}
	@Override
	public List<Customer> findCustomerByName(String optFirstName){
		// TODO Auto-generated method stub
		return operatorRepos.findCustomerByName(optFirstName);
		
		//return null;
	}
	@Override
	public Customer findCustomerByEmail(String email) {
		// TODO Auto-generated method stub
		return operatorRepos.findCustomerByEmail(email);
	}
	@Override
	public Customer lockCustomer(int optId) {
		// TODO Auto-generated method stub
		//if(custRepos.existsById(custId)) {
			int status=operatorRepos.lockCustomerByoptId(optId);
			if(status>=1)
				return operatorRepos.findCustomerById(optId);
		//}
		//else 
			//throw new InvalidCustomerException("This operator id is not present");
		return null;
	}

	@Override
	public List<Issue> findAllIssue() {
		// TODO Auto-generated method stub
		List<Issue> issueList=issueRepos.findAll();
		return issueList;
	}

	@Override
	public Issue findIssueById(int optId) {
		// TODO Auto-generated method stub
		return operatorRepos.findIssueById(optId);
		//return null;
	}

	@Override
	public List<Customer> findAllCustomer() {
		// TODO Auto-generated method stub
		List<Customer> custList=custRepos.findAll();
		return custList;
	}

	@Override
	public int findOperatorById(int custId) {
		// TODO Auto-generated method stub
		return operatorRepos.findCustByOptId(custId);
		//return 0;
	}
	

}
