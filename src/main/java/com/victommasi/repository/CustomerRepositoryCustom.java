package com.victommasi.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.victommasi.model.Customer;

@Repository
public interface CustomerRepositoryCustom {

	List<Customer> findByStatusNegociating();
	
	List<Customer> findByStatusAccepted();
	
	List<Customer> findByStatusRefused();
	
	List<Customer> findByNameOrPhone(Customer customer);
}
