package com.victommasi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victommasi.model.Customer;
import com.victommasi.model.Sale;
import com.victommasi.repository.SaleRepository;
import com.victommasi.wrapper.ObjectWrapper;

@Service
public class SaleService {

	@Autowired
	SaleRepository saleRepository;
	
	public void saveSale(ObjectWrapper objectWrapper){
		Sale sale = objectWrapper.getSale();
		Customer customer = objectWrapper.getCustomer();
		
		sale.setCustomer(customer);
		saleRepository.save(sale);
	}

	public void deleteSale(Integer id) {
		saleRepository.delete(id);
	}

	public Sale getSaleById(Integer id) {
		Sale sale = saleRepository.findOne(id);
		return sale;
	}
	
}
