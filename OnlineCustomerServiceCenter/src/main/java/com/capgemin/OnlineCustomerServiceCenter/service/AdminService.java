package com.capgemin.OnlineCustomerServiceCenter.service;

import java.util.List;

import com.capgemin.OnlineCustomerServiceCenter.exception.DepartmentCreationException;
import com.capgemin.OnlineCustomerServiceCenter.exception.InvalidDepartmentException;
import com.capgemin.OnlineCustomerServiceCenter.exception.InvalidLoginException;
import com.capgemin.OnlineCustomerServiceCenter.exception.OperatorCreationException;
import com.capgemin.OnlineCustomerServiceCenter.model.Department;
import com.capgemin.OnlineCustomerServiceCenter.model.Login;
import com.capgemin.OnlineCustomerServiceCenter.model.Operator;

public interface AdminService {
	public String login(Login login) throws InvalidLoginException;
	public boolean addDepartment(Department department) throws DepartmentCreationException;
	public boolean removeDepartment(int deptId) throws InvalidDepartmentException;
	public Department updateDepartment(Department department) throws InvalidDepartmentException;
	public Department findDepartmentById(int departmentId) throws InvalidDepartmentException;
	public List<Department> findAllDepartment();
	
	
	public boolean addOperator(Operator operator) throws OperatorCreationException;
	public boolean removeOperator(int departmentId) throws InvalidDepartmentException;
	public Operator modifyOperator(Operator operator);
	public Operator findOperatorById(int departmentId) throws InvalidDepartmentException;
	public List<Operator> findAllOperator();
}
