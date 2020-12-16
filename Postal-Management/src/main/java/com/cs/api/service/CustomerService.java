package com.cs.api.service;

import java.util.List;

import com.cs.api.entity.Customer;
import com.cs.api.response.CustomerResponse;

public interface CustomerService {

	public List<CustomerResponse> findAll();
	public CustomerResponse findById(Integer id);
	public CustomerResponse findByName(String name);
	public Customer saveCustomer(Customer customer);
	public List<Customer> findByState(String state);
	public List<Customer> findByZip(Integer zip);
	}
