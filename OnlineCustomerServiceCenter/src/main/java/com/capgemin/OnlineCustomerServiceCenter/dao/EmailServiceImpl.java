package com.capgemin.OnlineCustomerServiceCenter.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.capgemin.OnlineCustomerServiceCenter.exception.InvalidCustomerException;
import com.capgemin.OnlineCustomerServiceCenter.exception.InvalidOperatorException;
import com.capgemin.OnlineCustomerServiceCenter.model.Customer;
import com.capgemin.OnlineCustomerServiceCenter.model.Emaildetails;
import com.capgemin.OnlineCustomerServiceCenter.repository.CustomerRepository;
import com.capgemin.OnlineCustomerServiceCenter.repository.OperatorRepository;
import com.capgemin.OnlineCustomerServiceCenter.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService{

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired 
	private CustomerDao custDao;
	@Autowired
	private OperatorDao optDao;
	@Autowired
	private OperatorRepository operatorRepos;
	@Autowired
	private CustomerRepository custRepos;
	
	@Value("${spring.mail.username}")
	private String sender;
	@Override
	public String sendPasswordMail(Emaildetails details,int customerId){
		// TODO Auto-generated method stub
		Customer c=custDao.emailPassword(customerId);
		String email=c.getEmail();
		//System.out.println(email);
		String password=c.getLogin().getPassword();
		//System.out.println(password);
		try {
			SimpleMailMessage mailMessage=new SimpleMailMessage();
			mailMessage.setFrom(sender);
			//mailMessage.setTo(details.getRecipient());
			mailMessage.setTo(email);
			//mailMessage.setText(details.getMsgBody());
			mailMessage.setText(password);
			mailMessage.setSubject(details.getSubject());
			
			javaMailSender.send(mailMessage);
			return "mail send successfully...";
		}catch(Exception e) {
			  return "Error while Sending Mail" + " "+e;
		}
		//return null;
	}
	@Override
	public String sendIntimationEmail(Emaildetails details, int customerId) {
		// TODO Auto-generated method stub
		String descrption=operatorRepos.sendIntimationEmailToCustomer(customerId);
		String email=custRepos.findById(customerId).get().getEmail();
		//String name="Dear "+c.getFirstName()+" "+c.getLastName();
		try {
			SimpleMailMessage mailMessage=new SimpleMailMessage();
			mailMessage.setFrom(sender);
			mailMessage.setTo(email);
			mailMessage.setText(descrption);
			mailMessage.setSubject(details.getSubject());
			
			javaMailSender.send(mailMessage);
			return "mail send successfully...";
		}catch(Exception e) {
			  return "Error while Sending Mail" + " "+e;
		//return null;
	}
	}
	@Override
	public String sendModificationEmail(Emaildetails details, int customerId,int operatorId) throws InvalidOperatorException,InvalidCustomerException{
		// TODO Auto-generated method stub
		String descrption=optDao.sendModificationEmailToCustomer(customerId, operatorId);
		String email=custRepos.findById(customerId).get().getEmail();
		//String name="Dear "+c.getFirstName()+" "+c.getLastName();
		try {
			SimpleMailMessage mailMessage=new SimpleMailMessage();
			mailMessage.setFrom(sender);
			mailMessage.setTo(email);
			mailMessage.setText(descrption);
			mailMessage.setSubject(details.getSubject());
			
			javaMailSender.send(mailMessage);
			return "mail send successfully...";
		}catch(Exception e) {
			  return "Error while Sending Mail" + " "+e;
		//return null;
		}
	}
}
