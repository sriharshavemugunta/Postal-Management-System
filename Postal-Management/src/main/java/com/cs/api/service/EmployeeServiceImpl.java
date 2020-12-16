package com.cs.api.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.cs.api.entity.Employee;
import com.cs.api.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee findBySSN(Long ssn) {
		if (ssn != null) {
			Optional<Employee> employeeData = employeeRepository.findById(ssn);

			if (employeeData.isPresent()) {
				return employeeData.get();
			}
		}
		return null;
	}

	@Override
	public Employee findByName(String name) {
		if (!StringUtils.isEmpty(name)) {
			List<Employee> employees = new ArrayList<Employee>();
			employeeRepository.findByName(name).forEach(employees::add);
			return (employees.isEmpty()) ? null : employees.get(0);
		}
		return null;
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public void deleteBySSN(Long id) {
		if (id != null)
			employeeRepository.deleteById(id);

	}

	@Override
	public boolean assignManager(Long employeeId, Long managerId) {
		if (employeeId != null && managerId != null) {
			Employee emp = findBySSN(employeeId);
			Employee manager = findBySSN(managerId);
			if (emp != null && manager != null) {
				emp.setManager(manager);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean assignEmployeesToManager(List<Long> employeeIds, Long managerId) {
		if (!CollectionUtils.isEmpty(employeeIds) && managerId != null) {
			List<Employee> empList = employeeRepository.findBySSNList(employeeIds);
			Employee manager = findBySSN(managerId);
			if (CollectionUtils.isEmpty(empList) && manager != null) {
				empList.forEach(p -> p.setManager(manager));
				return true;
			}
		}
		return false;
	}

	@Override
	public Employee insert(Employee employee) {
		Employee _employee = new Employee();
		_employee.setSSN(employee.getSSN());
		_employee.setName(employee.getName());
		_employee.setAddreessLine(employee.getAddreessLine());
		_employee.setCity(employee.getCity());
		_employee.setState(employee.getState());
		_employee.setCountry(employee.getCountry());
		_employee.setZipCode(employee.getZipCode());
		_employee.setSalary(employee.getSalary());
		_employee.setEmails(new HashSet<String>(employee.getEmails()));
		_employee.setPhoneNumbers(new HashSet<Integer>(employee.getPhoneNumbers()));

		return employeeRepository.save(_employee);
	}

	@Override
	public Employee updateEmployee(Long ssn, Employee employee) {
		// it will be updated auto as it will be present in persistent contxt
		Employee _emp = findBySSN(ssn);
		if (_emp != null) {
			if (!employee.getName().isEmpty())
				_emp.setName(employee.getName());// name is not nullable

			_emp.setAddreessLine(employee.getAddreessLine());
			_emp.setCity(employee.getCity());
			_emp.setState(employee.getState());
			_emp.setZipCode(employee.getZipCode());
			_emp.setCountry(employee.getCountry());
			_emp.setSalary(employee.getSalary());
			_emp.setEmails(new HashSet<String>(employee.getEmails()));
			_emp.setPhoneNumbers(new HashSet<Integer>(employee.getPhoneNumbers()));

		}
		return _emp;
	}
}
