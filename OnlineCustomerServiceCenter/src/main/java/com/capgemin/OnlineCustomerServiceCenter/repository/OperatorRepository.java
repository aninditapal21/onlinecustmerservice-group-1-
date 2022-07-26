package com.capgemin.OnlineCustomerServiceCenter.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemin.OnlineCustomerServiceCenter.model.Customer;
import com.capgemin.OnlineCustomerServiceCenter.model.Issue;
//import com.capgemin.OnlineCustomerServiceCenter.model.Issue;
import com.capgemin.OnlineCustomerServiceCenter.model.Operator;
@Repository
public interface OperatorRepository extends JpaRepository<Operator, Integer> {

	
	//we are fetching operator id by using the customer login id
	//operator -> department -> login
	@Query(value="select operator_id from operator_table opt where opt.department_id=(select department_id from department_table  where login_username=?1)",nativeQuery=true)
	public int getOperatorId(int loginId);
	
	
	//we are sending the solution description to the customer email address
	//solution-> operator <-call
	@Query(value="select s.solution_description from solution_table s where s.operator_id=(select call.operator_id from call_table call inner join operator_table opt on opt.operator_id=call.operator_id where call.customer_id=?1)",nativeQuery=true)
	public String sendIntimationEmailToCustomer(int customerId);
	
	
	
	//For modification of Customer Issue we write one query to update the issue status
	//Issue -> call -> operator
	@Transactional
	@Modifying
	@Query(value="update issue_table i set issue_status=?1 where i.call_id=(select call.call_id from call_table call inner join operator_table opt on call.operator_id=opt.operator_id where opt.operator_id=?2)",nativeQuery=true)
	public int modifyCustomerIssue(String issueStatus,int operatorId);
	
	
	
	//After modification of customer issue we are sending the mail to the customer mail address
	
	@Transactional
	@Modifying
	@Query(value="update issue_table i set issue_status='solve' where i.call_id=(select call.call_id from call_table call inner join operator_table opt on call.operator_id=opt.operator_id where opt.operator_id=?1)",nativeQuery=true)
	public int modifyCustomerIssueForEmail(int operatorId);
	
	//Issue -> call -> customer
	
	@Query(value="select i.issueStatus from Issue i where i.call=(select call.callId from Call call Inner join Customer cust on call.customer=cust.customerId where cust.customerId=?1)")
	public String getIssueByCustomerId(int customerId);
	
	
	
	//Now we close that particular customer Issue set by issue_status=null
	
	@Transactional
	@Modifying
	@Query(value="update issue_table i set issue_status='CLOSED' where i.call_id=(select call.call_id from call_table call inner join operator_table opt on call.operator_id=opt.operator_id where opt.operator_id=?1)",nativeQuery=true)
	public int closeCustomerIssue(int operatorId);
	
	
	//we are searching the customer who is under the particular operator by passing operatorId in the parameter 
	//customer <- call -> operator
	
	@Query(value="select c from Customer c where c.customerId=(select call.customer from Call call Inner join Operator o on call.operator=o.operatorId where o.operatorId=?1)")
	public Customer findCustomerById(int operatorId);
	
	
	//we are searching the customer who is under the particular operator by passing operator name in the parameter
	
	
	//@Query(value="select c.customer_id,c.city,c.email,c.first_name,c.last_name,c.mobile from customer_table c where c.customer_id=(select customer_id from call_table call,operator_table o where call.operator_id=o.operator_id and o.first_name=?1)",nativeQuery=true)
	@Query(value="select c from Customer c where c.customerId=(select call.customer from Call call Inner join Operator o on call.operator=o.operatorId where o.firstName=?1)")
	public List<Customer> findCustomerByName(String optFirstName);
	
	
	//we are searching the customer who is under the particular operator by passing operator Email address in the parameter 
	
	@Query(value="select c from Customer c where c.customerId=(select call.customer from Call call Inner join Operator o on call.operator=o.operatorId where o.email=?1)")
	public Customer findCustomerByEmail(String optFirstEmail);
	
	
	// We lock the customer by setting that the customer loging id is null
	
	
	@Transactional
	@Modifying
	//@Query(value="update customer_table cust set login_username=null where cust.customer_id=(select call.customer_id from call_table call inner join operator_table opt on call.operator_id=opt.operator_id where opt.operator_id=?1)",nativeQuery=true)
    @Query(value="update Customer cust set login=null where cust.customerId=(select call.customer from Call call Inner join Operator opt on call.operator=opt.operatorId where opt.operatorId=?1)")
	//@Query(value="update customer_table  set login_username=null where customer_id=?2")
	public int lockCustomerByoptId(int optId);
	
	
	//@Query(value="select * from issue_table i where i.call_id=(select c.call_id from call_table c where c.operator_id=?1)",nativeQuery = true)
	@Query(value="select i from Issue i where i.call=(select call.callId from Call call Inner join Operator o on call.operator=o.operatorId where o.operatorId=?1)")
	public Issue findIssueById(int optId);
	
	@Query(value="select operator_id from operator_table opt where opt.operator_id=(select call.operator_id from call_table call where call.customer_id=?1)",nativeQuery = true)
	public int findCustByOptId(int custId);
	
	
	
	
	
	
	
	
}
