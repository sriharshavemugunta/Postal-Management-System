package com.cs.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.cs.api.entity.Customer;
import com.cs.api.repository.CustomerRepository;
import com.cs.api.response.CustomerResponse;

@Service
public class CustomerServiceImpl implements CustomerService {

	private static final ModelMapper modelMapper = new ModelMapper();

	@Autowired
	private CustomerRepository customerRepository;

	public List<CustomerResponse> findAll() {

		List<Customer> customers = customerRepository.findAll();
		if (!CollectionUtils.isEmpty(customers)) {

			List<CustomerResponse> customerResponse = new ArrayList<CustomerResponse>();
			// customerResponse here is a pre-populated customer instance
			for (Customer cust : customers) {
				CustomerResponse custDTO = modelMapper.map(cust, CustomerResponse.class);
				customerResponse.add(custDTO);
			}
			return customerResponse;
		}
		return null;
	}

	public CustomerResponse findById(Integer id) {
		Optional<Customer> customer = customerRepository.findById(id);
		if (customer.isPresent()) {
			CustomerResponse response = modelMapper.map(customer.get(), CustomerResponse.class);
			return response;
		}
		return null;
	}

	public CustomerResponse findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public Customer saveCustomer(Customer customer) {
		 return customerRepository.save(customer);
	
	}

	@Override
	public List<Customer> findByState(String state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> findByZip(Integer zip) {
		// TODO Auto-generated method stub
		return null;
	}

}
