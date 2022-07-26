package com.capgemin.OnlineCustomerServiceCenter.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.capgemin.OnlineCustomerServiceCenter.model.Department;
import com.capgemin.OnlineCustomerServiceCenter.model.Operator;

@Repository
public interface AdminRepository extends JpaRepository<Department, Integer>{
	@Transactional
	@Modifying
	
	//JPQL Query
	//@Query(value="delete from Department d where d.departmentId=?1")
	@Query(value="update department_table d set deleted_flag='Y' where d.department_id=?1",nativeQuery = true)
	public int deleteDeptById(int departmentId);
	
	@Transactional
	@Modifying
	//JPQL Query
	@Query(value="update Department d set d.departmentName=?1 where d.departmentId=?2")
	public int updateDeptById(String departmentName,int departmentId );
	
	
	
	@Transactional
	@Modifying
	//@Query(value="delete from Operator opt inner join Department dept on dept.departmentId=opt.departmentId where dept.departmentId=?1")
	//JPQL Query
	//@Query(value="delete from Operator opt where opt.department=(select departmentId from Department where departmentId=?1)")
	//SQL Query
	//@Query(value="delete from operator_table where department_department_id=(select department_id from department_table where department_id=?1)",nativeQuery=true)
	@Query(value="update operator_table opt set deleted_flag='Y' where opt.department_id=(select department_id from department_table where department_id=?1)",nativeQuery = true)
	public int deleteOperatorById(int departmentId);
	
	@Transactional
	@Modifying
	//SQL Query
	//@Query(value="update operator_table set city=?1 where department_department_id=(select department_id from department_table where department_id=?2)",nativeQuery=true)
	//JPQL Query
	@Query(value="update Operator opt set city=?1 where opt.department=(select departmentId from Department where departmentId=?2)")
	public int updateOperatorById(String city,int departmentId);
	
	
	//@Transactional
	//@Modifying
	//@Query(value="select o.operator_id,o.city,o.email,o.first_name,o.last_name,o.mobile,d.department_department_id from department_table d inner join operator_table o on d.department_id=o.department_department_id where d.department_id=?1",nativeQuery = true)
	//@Query(value="select o.operator_id,o.city,o.email,o.first_name,o.last_name,o.mobile,o.department_department_id from department_table d,operator_table o where d.department_id=o.department_department_id and d.department_id=?1",nativeQuery = true)
	//JPQL Query
		@Query(value="select o from  Operator o where o.department=(select departmentId from Department where departmentId=?1)")
	//@Query(value="select operator from Department d,Operator o where d.departmentId=o.departmentId and d.departmentId=?1")
	public Operator getOperatorByDeptId(int departmentId);
	
	//@Transactional
	//@Modifying
	//@Query(value="select * from Operator")
	//public List<Operator> listAllOperator();
		
		
	@Query(value="select department_id from department_table where login_username=?1 and deleted_flag='N'",nativeQuery=true)
	public int getDepartmentId(int loginId);
	
	
	
	
	
}
