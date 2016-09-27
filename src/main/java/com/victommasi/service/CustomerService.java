package com.victommasi.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victommasi.model.Customer;
import com.victommasi.model.Status;
import com.victommasi.repository.CustomerRepository;
import com.victommasi.wrapper.ObjectWrapper;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	public void saveCustomer(Customer customer){
		customerRepository.save(customer);
	}

	public void updateCustomer(ObjectWrapper objectWrapper){
		Customer customerWrapper = objectWrapper.getCustomer();
		Integer id = customerWrapper.getId();
		String name = customerWrapper.getName();
		
		Customer customer = customerRepository.findOne(id);
		
		if (!customer.getStatus().equals("ACCEPTED")){
			customer.setStatus(Status.ACCEPTED);
		}
		customer.setName(name);
		customerRepository.save(customer);
	}
	
	public void deleteCustomer(Integer id) {
		customerRepository.delete(id);
	}

}
