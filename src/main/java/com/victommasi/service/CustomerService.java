package com.victommasi.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.victommasi.dto.CustomObjectDTO;
import com.victommasi.model.Customer;
import com.victommasi.model.Status;
import com.victommasi.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	SaleService saleService;
	
	public void saveCustomer(Customer customer){
		customerRepository.save(customer);
	}

	@Transactional
	public void updateCustomer(CustomObjectDTO objectWrapper){
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
	
	@Transactional
	public void deleteCustomers(Integer[] ids) throws Exception {
		for(Integer id : ids){
			saleService.deleteSaleByCustomerId(id);
			customerRepository.delete(id);
		}
	}

}
