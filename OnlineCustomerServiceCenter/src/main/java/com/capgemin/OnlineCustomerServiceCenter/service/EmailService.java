package com.capgemin.OnlineCustomerServiceCenter.service;

import com.capgemin.OnlineCustomerServiceCenter.exception.InvalidCustomerException;
import com.capgemin.OnlineCustomerServiceCenter.exception.InvalidOperatorException;
import com.capgemin.OnlineCustomerServiceCenter.model.Emaildetails;

public interface EmailService {
	 // Method
    // To send a simple email
    public String sendPasswordMail(Emaildetails details,int customerId);
    public String sendIntimationEmail(Emaildetails details,int customerId);
    public String sendModificationEmail(Emaildetails details,int customerId,int operatorId) throws InvalidOperatorException,InvalidCustomerException;
}
