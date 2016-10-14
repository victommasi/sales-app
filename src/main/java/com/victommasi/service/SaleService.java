package com.victommasi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victommasi.dto.CustomObjectDTO;
import com.victommasi.model.Balance;
import com.victommasi.model.Customer;
import com.victommasi.model.Sale;
import com.victommasi.repository.SaleRepository;

@Service
public class SaleService {

	@Autowired
	SaleRepository saleRepository;
	
	@Autowired
	CustomerService customerService;
	
	public void saveSale(CustomObjectDTO customObjectDto){
		customerService.updateCustomer(customObjectDto);
		Sale sale = customObjectDto.getSale();
		Customer customer = customObjectDto.getCustomer();
		
		sale.setCustomer(customer);
		saleRepository.save(sale);
	}

	public void deleteSale(Integer id) {
		saleRepository.delete(id);
	}

	public float getMonthBalance(Integer year, Integer month){
		List<Sale> sales = saleRepository.findSalesByMonthAndYear(year, month);
		float sum = 0;
		for(Sale s : sales){
			sum = sum + s.getPrice().floatValue();
		}
		return sum;
	}
	
	public float getYearBalance(Integer year){
		List<Sale> sales = saleRepository.findSalesByYear(year);
		float sum = 0;
		for(Sale s : sales){
			sum = sum + s.getPrice().floatValue();
		}
		return sum;
	}

	public Balance getTotalBalance(Balance balance) {
		float sum = 0;
		
		List<Sale> sales = saleRepository.findAll();
		for(Sale s : sales){
			sum = sum + s.getPrice().floatValue();
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
