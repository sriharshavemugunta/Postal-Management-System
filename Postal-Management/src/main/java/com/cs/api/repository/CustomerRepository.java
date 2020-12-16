package com.cs.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cs.api.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	@Query
	("SELECT c FROM Customer c WHERE LOWER(c.name) = LOWER(:custName)")
    public List<Customer> findByCustomerName(@Param("custName") String custName);

}
