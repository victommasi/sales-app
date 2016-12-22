package com.victommasi.service;

import java.math.BigDecimal;
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

	public BigDecimal getMonthBalance(Integer year, Integer month){
		return saleRepository.sumSalesByMonthAndYear(year, month);
	}
	
	public BigDecimal getYearBalance(Integer year){
		return saleRepository.sumSalesByYear(year);
	}
	
	public Balance getTotalBalance(Balance balance) {
		balance.setTotal(saleRepository.sumSales());
		balance.setAverage(saleRepository.avgSales());
		return balance;
	}

	public void deleteSaleByCustomerId(Integer id) {
		if (saleRepository.checkSaleByCustomerId(id)) {
			List<Sale> sales  = saleRepository.findSaleByCustomerId(id);
				for(Sale s : sales){
					this.deleteSale(s.getId());
				}
		}
	}

}
