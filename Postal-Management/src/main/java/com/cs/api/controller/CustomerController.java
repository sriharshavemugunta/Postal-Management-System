package com.cs.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cs.api.entity.Customer;
import com.cs.api.response.CustomerResponse;
import com.cs.api.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<CustomerResponse> getAllCustomers() {
		return customerService.findAll();
	}

	@RequestMapping(value = "/adduser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody()
	public Customer addNewUser(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public CustomerResponse getCustomerById(@PathVariable Integer id) {
		return customerService.findById(id);
	}

}
