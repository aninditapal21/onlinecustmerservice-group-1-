package com.capgemin.OnlineCustomerServiceCenter.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemin.OnlineCustomerServiceCenter.exception.DepartmentCreationException;
import com.capgemin.OnlineCustomerServiceCenter.exception.InvalidDepartmentException;
import com.capgemin.OnlineCustomerServiceCenter.exception.InvalidLoginException;
import com.capgemin.OnlineCustomerServiceCenter.exception.OperatorCreationException;
import com.capgemin.OnlineCustomerServiceCenter.model.Department;
import com.capgemin.OnlineCustomerServiceCenter.model.Login;
import com.capgemin.OnlineCustomerServiceCenter.model.Operator;
import com.capgemin.OnlineCustomerServiceCenter.repository.AdminRepository;
import com.capgemin.OnlineCustomerServiceCenter.repository.LoginRepository;
import com.capgemin.OnlineCustomerServiceCenter.repository.OperatorRepository;
import com.capgemin.OnlineCustomerServiceCenter.service.AdminService;

@Service
public class AdminDao implements AdminService{

	@Autowired
	private AdminRepository deptmentRepos;
	@Autowired
	private OperatorRepository operatorRepos;
	@Autowired 
	private LoginRepository loginRepos;
	
	@Override
	public String login(Login login) throws InvalidLoginException {
		// TODO Auto-generated method stub
		int userName=login.getUsername();
		String passWord=login.getPassword();
		int deptId=deptmentRepos.getDepartmentId(userName);
		if(passWord.equals(loginRepos.getAdminPassword(deptId)) && login.getType().equals("ADMIN")) {
			System.out.println(login.getType());
				return "Admin Login";
		}
		else 
			throw new InvalidLoginException("Password is not maching");
	}
	@Override
	public boolean addDepartment(Department department) throws DepartmentCreationException{
		// TODO Auto-generated method stub
		//if(department.getLogin().getType().equals("ADMIN")) {
			if(deptmentRepos.existsById(department.getDepartmentId()))
				throw new DepartmentCreationException("The department is already exits");
			else {
					Login log=department.getLogin();
					Login l=loginRepos.save(log);
					Department dept=deptmentRepos.save(department);
					if(dept!=null) {
						return true;
					}
				}
		//}
		return false;
	}
	@Override
	public boolean removeDepartment(int deptId) throws InvalidDepartmentException{
		// TODO Auto-generated method stub
		if(deptmentRepos.existsById(deptId)) {
			int k=deptmentRepos.deleteDeptById(deptId);
			if(k==1) 
				return true;
		}
		else 
			throw new InvalidDepartmentException("Department id is not present");
		return false;
	}
	@Override
	public Department updateDepartment(Department department) throws InvalidDepartmentException{
		// TODO Auto-generated method stub
		int status=0;
		if(deptmentRepos.existsById(department.getDepartmentId())) {
			int deptId=department.getDepartmentId();
			String deptName=department.getDepartmentName();
			status=deptmentRepos.updateDeptById(deptName, deptId);
			if(status>=1)
				return department;
		}
		else
			throw new InvalidDepartmentException("Department  id not available");
		return null;
	}
	@Override
	public Department findDepartmentById(int departmentId) throws InvalidDepartmentException {
		// TODO Auto-generated method stub
		Optional<Department> dept=deptmentRepos.findById(departmentId);
		if(dept.isPresent())
			return dept.get();
		else
			throw new InvalidDepartmentException("Department id is not present");
	}
	@Override
	public boolean addOperator(Operator operator) throws OperatorCreationException{
		// TODO Auto-generated method stub
		if(operatorRepos.existsById(operator.getOperatorId()))
			throw new OperatorCreationException("The operator is already exits");
		else {
			Operator opt=operatorRepos.save(operator);
			if(opt!=null)
				return true;
		}
		return false;
	}
	@Override
	public boolean removeOperator(int departmentId) throws InvalidDepartmentException{
		// TODO Auto-generated method stub 
		if(deptmentRepos.existsById(departmentId)) {
			int delete=deptmentRepos.deleteOperatorById(departmentId);
			if(delete==1)
				return true;
		}
		else 
			throw new InvalidDepartmentException("Department id is not present");
			
		return false;
	}
	@Override
	public Operator modifyOperator(Operator operator) {
		// TODO Auto-generated method stub
		int status=0;
		int deptId=operator.getDepartment().getDepartmentId();
		String OptCity=operator.getCity();
		status=deptmentRepos.updateOperatorById(OptCity, deptId);
		if(status>=1)
			return operator;
		return null;
	}
	@Override
	public Operator findOperatorById(int departmentId) throws InvalidDepartmentException{
		// TODO Auto-generated method stub
		if(deptmentRepos.existsById(departmentId))
			return deptmentRepos.getOperatorByDeptId(departmentId);
		else
			throw new InvalidDepartmentException("Department id is not present");
	}
	@Override
	public List<Operator> findAllOperator() {
		// TODO Auto-generated method stub
		List<Operator> optlist=operatorRepos.findAll();
		List<Operator> optcurrentList=new ArrayList();
		for(Operator opt:optlist) {
			if(opt.getDeletedFlag().equalsIgnoreCase("N"))
				optcurrentList.add(opt);
		}
		return optcurrentList;
		
		//List<Operator> optlist=operatorRepos.listAllOperator();
		//return optlist;
	}
	@Override
	public List<Department> findAllDepartment() {
		// TODO Auto-generated method stub
		List<Department> deptlist=deptmentRepos.findAll();
		List<Department> deptcurrentList=new ArrayList();
		for(Department dept:deptlist) {
			if(dept.getDeletedFlag().equalsIgnoreCase("N"))
				deptcurrentList.add(dept);
		}
		return deptcurrentList;
	}
	

}
