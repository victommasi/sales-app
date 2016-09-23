package com.victommasi.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.victommasi.model.Customer;

@Repository
public interface CustomerRepositoryCustom {

	public List<Customer> findByStatusNegociating();
	
	public List<Customer> findByStatusAccepted();
	
	public List<Customer> findByStatusRefused();
}
