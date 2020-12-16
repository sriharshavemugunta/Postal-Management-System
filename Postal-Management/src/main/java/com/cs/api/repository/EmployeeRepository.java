package com.cs.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cs.api.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query("SELECT e FROM Employee e WHERE e.name=:name")
	List<Employee> findByName(String name);
	
	@Query("SELECT e FROM Employee e WHERE e.store=:storeId")
	List<Employee> findByStoreId(Integer storeId);

	@Query("SELECT e FROM Employee e WHERE e.SSN IN (:employeeIds)")
	List<Employee> findBySSNList(List<Long> employeeIds);
	
	
}

