package com.capgemin.OnlineCustomerServiceCenter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemin.OnlineCustomerServiceCenter.dao.AdminDao;
import com.capgemin.OnlineCustomerServiceCenter.dao.CustomerDao;
import com.capgemin.OnlineCustomerServiceCenter.dao.OperatorDao;
import com.capgemin.OnlineCustomerServiceCenter.exception.CustomerCreationException;
import com.capgemin.OnlineCustomerServiceCenter.exception.DepartmentCreationException;
import com.capgemin.OnlineCustomerServiceCenter.exception.IssueCreationException;
import com.capgemin.OnlineCustomerServiceCenter.exception.OperatorCreationException;
import com.capgemin.OnlineCustomerServiceCenter.model.Call;
import com.capgemin.OnlineCustomerServiceCenter.model.Customer;
import com.capgemin.OnlineCustomerServiceCenter.model.Department;
import com.capgemin.OnlineCustomerServiceCenter.model.Issue;
import com.capgemin.OnlineCustomerServiceCenter.model.Login;
import com.capgemin.OnlineCustomerServiceCenter.model.Operator;
import com.capgemin.OnlineCustomerServiceCenter.model.Solution;
import com.capgemin.OnlineCustomerServiceCenter.model.UserType;
import com.capgemin.OnlineCustomerServiceCenter.repository.AdminRepository;
import com.capgemin.OnlineCustomerServiceCenter.repository.CustomerRepository;
import com.capgemin.OnlineCustomerServiceCenter.repository.OperatorRepository;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class OnlineCustomerServiceCenterApplicationTests {
	@Autowired
	private CustomerRepository custRepos;
	@Autowired
	private CustomerDao custDao;
	@Autowired
	private AdminRepository adminRepos;
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private OperatorRepository optRepos;
	@Autowired
	private OperatorDao optDao;

	@Test
	public void testSave() {
		Customer customer=new Customer();
		customer.setCustomerId(503);
		customer.setFirstName("Riya");
		customer.setLastName("Sen");
		customer.setEmail("riyasen8@gmail.com");
		customer.setCity("Bangalore");
		customer.setMobile("8934674566");
		Login l=new Login();
		l.setUsername(303);
		l.setPassword("#abcf");
		l.setActive(true);
		l.setType("CUSTOMER");
		customer.setLogin(l);
		//Customer c=null;
		String str=null;
		try {
			str=custDao.registerCustomer(customer);
			
		}
		catch(CustomerCreationException e) {
			e.printStackTrace();
		}	
		finally {
			assertEquals("register", str);
		}
	}
	@Test
	public void testDeptSave() {
		Department dept=new Department();
		dept.setDepartmentId(103);
		dept.setDepartmentName("Problem Solving");
		Login log=new Login();
		log.setUsername(203);
		log.setPassword("@fff");
		log.setActive(true);
		log.setType("ADMIN");
		dept.setLogin(log);
		boolean flag=false;
		try {
				flag=adminDao.addDepartment(dept);
			}
		catch(DepartmentCreationException e) {
			e.printStackTrace();
		}finally{
			assertEquals(true,flag);
		}
		
	}
	@Test
	public void textDeptForDelete() {
		int status=adminRepos.deleteDeptById(109);
		assertEquals(1, status);
	}
	@Test 
	public void testDeptForUpdate() {
		Department dept=adminRepos.findById(103).get();
		dept.setDepartmentName("Develop Department");
		adminRepos.save(dept);
		assertNotEquals("xyz",adminRepos.findById(103).get().getDepartmentName());
	}
	@Test
	public void testOperatorSave() {
		Operator opt=new Operator();
		opt.setOperatorId(703);
		opt.setFirstName("Sikha");
		opt.setLastName("De");
		opt.setEmail("sikha@gmail.com");
		opt.setCity("Bangalore");
		opt.setMobile("9034577342");
		Department dept=new Department();
		dept.setDepartmentId(103);
		dept.setDepartmentName("Problem Solving");
		Login log=new Login();
		log.setUsername(203);
		log.setPassword("@fff");
		log.setActive(true);
		log.setType("ADMIN");
		dept.setLogin(log);
		opt.setDepartment(dept);
		boolean flag=false;
		try {
			flag=adminDao.addOperator(opt);
			
		}catch(OperatorCreationException e) {
			e.printStackTrace();
		}finally {
			assertEquals(true,flag);
		}
	}
	@Test
	public void testoptForDelete() {
		int status=adminRepos.deleteOperatorById(106);
		assertEquals(1, status);
	}
	
	@Test
	public void testGetAllOperator() {
		List<Operator> list=adminDao.findAllOperator();
		assertThat(list).size().isGreaterThan(0);
	}
	
	@Test 
	public void textoptForUpdate() {
		int status=adminRepos.updateOperatorById("Pune", 103);
		//opt.setCity("Bangalore");
		assertEquals(1, status);
	}
	@Test
	public void testIssueSave() {
		
		Call c=new Call();
		c.setCallId(903);
		c.setCallDuration(5.0);
		c.setCallDate(Date.valueOf(LocalDate.now()));
		c.setPhoneNumber("9456736342");
			Customer customer=new Customer();
			customer.setCustomerId(503);
			customer.setFirstName("Riya");
			customer.setLastName("Sen");
			customer.setEmail("riyasen8@gmail.com");
			customer.setCity("Bangalore");
			customer.setMobile("8934674566");
				Login l=new Login();
				l.setUsername(303);
				l.setPassword("#abcf");
				l.setActive(true);
				l.setType("CUSTOMER");
			customer.setLogin(l);
		c.setCustomer(customer);
			Operator opt=new Operator();
			opt.setOperatorId(703);
			opt.setFirstName("Sikha");
			opt.setLastName("De");
			opt.setEmail("sikha@gmail.com");
			opt.setCity("Bangalore");
			opt.setMobile("9034577342");
				Department dept=new Department();
				dept.setDepartmentId(103);
				dept.setDepartmentName("Problem Solving");
					Login log=new Login();
					log.setUsername(203);
					log.setPassword("@fff");
					log.setActive(true);
					log.setType("ADMIN");
				dept.setLogin(log);
			opt.setDepartment(dept);
		c.setOperator(opt);
		Issue i=new Issue();
		i.setIssueId("ISSUE3");
		i.setDescription("AC is not working");
		i.setIssueStatus("Unsolve");
		i.setIssueType("Technical");
		i.setCall(c);
		Solution sol=new Solution();
		sol.setSolutionId(803);
		sol.setSolutionDescription("Not Done");
		sol.setSolutionDate(Date.valueOf(LocalDate.now()));
		Operator opt1=new Operator();
		opt1.setOperatorId(703);
		opt1.setFirstName("Sikha");
		opt1.setLastName("De");
		opt1.setEmail("sikha@gmail.com");
		opt1.setCity("Bangalore");
		opt1.setMobile("9034577342");
			Department dept1=new Department();
			dept1.setDepartmentId(103);
			dept1.setDepartmentName("Problem Solving");
				Login log1=new Login();
				log1.setUsername(203);
				log1.setPassword("@fff");
				log1.setActive(true);
				log1.setType("ADMIN");
			dept1.setLogin(log1);
		opt1.setDepartment(dept1);
		sol.setOperator(opt1);
		
		i.setSolution(sol);
		Issue issue=null;
		try {
		 	issue= optDao.addCustomerIssue(i);
		} catch (IssueCreationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(issue);
		}
	@Test
	public void testIssueForUpdate() {
		int status=optRepos.modifyCustomerIssue("Solve", 703);
		assertEquals(1, status);
	}
	
}
