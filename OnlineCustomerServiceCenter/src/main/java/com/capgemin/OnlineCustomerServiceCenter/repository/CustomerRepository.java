package com.capgemin.OnlineCustomerServiceCenter.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemin.OnlineCustomerServiceCenter.model.Customer;
import com.capgemin.OnlineCustomerServiceCenter.model.Issue;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>{
	
	
	
	
	
	@Query(value="select i from Issue i where i.call=(select call.callId from Call call Inner join Customer cust on call.customer=cust.customerId where cust.customerId=?1)")
	public Issue getIssueByCustomerId(int customerId);
	
	//@Query(value="update Issue i set issueStatus='solve' where i.call=(select call.callId from Call call Inner join Customer cust on call.customer=cust.customerId where cust.customerId=?1)")
	
	
	//update issue_table i set issue_status=?1 where i.call_id=(select call.call_id from call_table call inner join operator_table opt on call.operator_id=opt.operator_id where opt.operator_id=?2)
	@Transactional
	@Modifying
	@Query(value="update Issue i set issueStatus='Unsolve' where i.call=(select call.callId from Call call Inner join Customer cust on call.customer=cust.customerId where cust.customerId=?1)")
	//@Query(value="update issue_table i set issue_status=?1 where i.call_id=(select call.call_id from call_table call Inner join customer_table cust on call.customer_id=cust.customer_id where cust.customer_id=?2)",nativeQuery=true)
	public int reopenIssue(int customerId);
	
	//SQL 
	@Query(value="select password from login_table l,customer_table c where l.username=c.login_username and c.customer_id=?1",nativeQuery=true)
	public String forgotPassword(int customerId);
	
	@Query(value="select c from Customer c  where c.customerId=?1")
	public Customer emailPassword(int customerId);
	
	//@Query(value="selecr email from Customer c where c.customerID=?1")
	//public String getEmailByCustomer(int customerId);
	
	
	@Query(value="select customer_id from customer_table where login_username=?1",nativeQuery=true)
	public int getCustomerId(int loginId);
	
	
	@Transactional
	@Modifying
	@Query(value="update login_table l set password=?1 where l.username=(select c.login_username from customer_table c where c.customer_id=?2)",nativeQuery=true)
	public int changePasswordById(String password,int customerId);
	@Transactional
	@Modifying
	@Query(value="update customer_table  set login_username=null where customer_id=?1",nativeQuery = true)
	public int lockCustomerByoptId(int custId);
}
