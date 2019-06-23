package com.boot.reactive.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.boot.reactive.demo.entity.EmployeeBean;

public interface EmployeeDAO extends CrudRepository<EmployeeBean,Integer> {

	@Query(value = "SELECT * FROM EMPLOYEE", nativeQuery = true)
	List<EmployeeBean> findAllEmployees();

	//@Query("SELECT u FROM User u WHERE u.status = ?1 and u.name = ?2")
	//User findUserByStatusAndName(Integer status, String name);
	
	@Query(value = "SELECT * FROM EMPLOYEE WHERE emp_id=?1", nativeQuery = true)
	EmployeeBean findEmployeeById(Integer i);

}
