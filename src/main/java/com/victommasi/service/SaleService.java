package com.victommasi.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victommasi.model.Balance;
import com.victommasi.model.Customer;
import com.victommasi.model.Datapoint;
import com.victommasi.model.Sale;
import com.victommasi.repository.SaleRepository;
import com.victommasi.wrapper.ObjectWrapper;

@Service
public class SaleService {

	@Autowired
	SaleRepository saleRepository;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	DatapointService datapointService;
	
	public void saveSale(ObjectWrapper objectWrapper){
		customerService.updateCustomer(objectWrapper);
		Sale sale = objectWrapper.getSale();
		Customer customer = objectWrapper.getCustomer();
		
		sale.setCustomer(customer);
		saleRepository.save(sale);
	}

	public void deleteSale(Integer id) {
		saleRepository.delete(id);
	}

	public double getMonthBalance(Integer year, Integer month){
		List<Sale> sales = saleRepository.findSalesByMonthAndYear(year, month);
		double sum = 0;
		for(Sale s : sales){
			sum = sum + s.getPrice().doubleValue();
		}
		return sum;
	}
	
	public double getYearBalance(Integer year){
		List<Sale> sales = saleRepository.findSalesByYear(year);
		double sum = 0;
		for(Sale s : sales){
			sum = sum + s.getPrice().doubleValue();
		}
		return sum;
	}

	public Balance getTotalBalance(Balance balance) {
		double sum = 0;
		
		List<Sale> sales = saleRepository.findAll();
		for(Sale s : sales){
			sum = sum + s.getPrice().doubleValue();
		}
		
		balance.setTotal(sum);
		if (sales.size() == 0) {
			balance.setAverage(sum);
			return balance;
		}
		balance.setAverage(sum / sales.size());
		return balance;
	}
	
}
