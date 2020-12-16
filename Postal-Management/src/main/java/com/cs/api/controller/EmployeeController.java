package com.cs.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cs.api.entity.Employee;
import com.cs.api.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployee(@RequestParam(required = false) String name) {
		try {
			List<Employee> emps = new ArrayList<Employee>();

			if (name == null)
				emps = employeeService.findAll();
			else {

				Employee emp = employeeService.findByName(name);
				if (emp != null)
					emps.add(emp);
			}

			if (emps.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(emps, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long ssn) {
		Employee storeData = employeeService.findBySSN(ssn);

		if (storeData != null) {
			return new ResponseEntity<>(storeData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		try {
			Employee _emp = employeeService.insert(employee);
			return new ResponseEntity<>(_emp, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/employees/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long ssn, @RequestBody Employee employee) {
		Employee _emp = employeeService.updateEmployee(ssn, employee);
		if (_emp == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<>((_emp), HttpStatus.OK);

	}

	@RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") Long ssn) {
		try {
			employeeService.deleteBySSN(ssn);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/employees/assignManager/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Employee> assignEmployeeManager(@PathVariable("id") Long ssn, @RequestBody Employee employee) {
		Employee _emp = employeeService.updateEmployee(ssn, employee);
		if (_emp == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<>((_emp), HttpStatus.OK);

	}
	
}
