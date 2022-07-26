package com.capgemin.OnlineCustomerServiceCenter.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.ILoggerFactory;
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

import com.capgemin.OnlineCustomerServiceCenter.dao.AdminDao;
import com.capgemin.OnlineCustomerServiceCenter.exception.DepartmentCreationException;
import com.capgemin.OnlineCustomerServiceCenter.exception.InvalidDepartmentException;
import com.capgemin.OnlineCustomerServiceCenter.exception.InvalidLoginException;
import com.capgemin.OnlineCustomerServiceCenter.exception.OperatorCreationException;
import com.capgemin.OnlineCustomerServiceCenter.model.Department;
import com.capgemin.OnlineCustomerServiceCenter.model.Login;
import com.capgemin.OnlineCustomerServiceCenter.model.Operator;

@RestController
@CrossOrigin("http://localhost:4500/")
public class AdminController {
	@Autowired
	private AdminDao adminDao;
	
	//create and initialization logger object in log variable
	
	@PostMapping(path="/loginAdmin")
	public String login(@Valid @RequestBody Login login) throws InvalidLoginException{
		return adminDao.login(login);
	}
	Logger log=LoggerFactory.getLogger(AdminController.class);
	@PostMapping(path="/addDepartment")
	public boolean addDepartment(@Valid @RequestBody Department department) throws DepartmentCreationException {
		if(adminDao.addDepartment(department)) {
			log.info("your deparment object is created");
			return true;
		}
		else
			log.error("You are not admin you can not add department");
		return false;
	}
	@DeleteMapping(path="/deleteDepartmentById/{deptId}")
	public boolean removeDepartment(@PathVariable int deptId) throws InvalidDepartmentException{
		return adminDao.removeDepartment(deptId);
	}
	@PutMapping(path="/updateDepartmentById/{deptId}")
	public Department updateDepartment(@Valid @RequestBody Department department, @PathVariable int deptId) throws InvalidDepartmentException{
		return adminDao.updateDepartment(department);
	}
	@GetMapping(path="/readDepartmentById/{deptId}")
	public Department findDepartmentById(@PathVariable int deptId) throws InvalidDepartmentException {
		return adminDao.findDepartmentById(deptId);
	}
	@PostMapping(path="/addOperator")
	public boolean addOperator(@Valid @RequestBody Operator operator) throws OperatorCreationException{
		if( adminDao.addOperator(operator)) {
			log.info("your operator object is created");
			return true;
		}
		else
			log.error("You are not admin you can not add department");
		return false;
	}
	
	@DeleteMapping(path="/removeOperatorById/{deptId}")
	public boolean removeOperator(@PathVariable int deptId) throws InvalidDepartmentException {
		log.info("remove the operator from the database");
		return adminDao.removeOperator(deptId);
	}
	@PutMapping(path="/modifyOperatorById/{deptId}")
	public Operator modifyOperator(@RequestBody Operator operator,@PathVariable int deptId) {
		log.info("modify the operator city");
		return adminDao.modifyOperator(operator);
	}
	@GetMapping(path="/findOperatorById/{deptId}")
	public Operator findOperatorById(@PathVariable int deptId) throws InvalidDepartmentException{
		log.info("showing the operator of the particullar departmentId");
		return adminDao.findOperatorById(deptId);
	}
	@GetMapping(path="/getAllOperator")
	public List<Operator> findAllOperator(){
		log.info("fetch all operator details");
		return adminDao.findAllOperator();
	}
	@GetMapping(path="/getAllDepartment")
	public List<Department> findAllDepartment(){
		return adminDao.findAllDepartment();
	}
	//@GetMapping(path="/")
}
