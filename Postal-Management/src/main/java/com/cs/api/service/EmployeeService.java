package com.cs.api.service;

import java.util.List;

import com.cs.api.entity.Employee;
import com.cs.api.entity.Store;

public interface EmployeeService {

	public Employee insert(Employee employee);

	public Employee findBySSN(Long ssn);

	public Employee findByName(String name);

	public List<Employee> findAll();

	public void deleteBySSN(Long id);

	public Employee updateEmployee(Long ssn, Employee employee);

	boolean assignManager(Long empployeeId, Long managerId);

	boolean assignEmployeesToManager(List<Long> employeeIds, Long managerId);
}
