package com.capgemin.OnlineCustomerServiceCenter.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemin.OnlineCustomerServiceCenter.model.Login;
@Repository
public interface LoginRepository extends JpaRepository<Login, Integer>{
	
	
	@Query(value="select l.password from login_table l inner join customer_table c on l.username=c.login_username where c.customer_id=?1",nativeQuery=true)
	public String getCustomerPassword(int customerId);
	
	
	@Query(value="select l.username from login_table l inner join customer_table c on l.username=c.login_username where c.customer_id=?1",nativeQuery=true)
	public int getCustomerUserName(int customerId);
	
	@Query(value="select l.type from login_table l inner join customer_table c on l.username=c.login_username where c.customer_id=?1",nativeQuery=true)
	public String getUserType(int customerId);
	
	
	@Query(value="select l.password from login_table l where l.username=(select d.login_username from department_table d Inner join operator_table opt on d.department_id=opt.department_id where opt.operator_id=?1)",nativeQuery=true)
	public String getAdminPasswordByOptId(int operatorId);
	
	@Query(value="select l.password from login_table l inner join department_table d on l.username=d.login_username where d.department_id=?1",nativeQuery=true)
	public String getAdminPassword(int deptId);
}
