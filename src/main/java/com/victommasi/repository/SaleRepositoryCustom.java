package com.victommasi.repository;

import java.util.List;

import com.victommasi.model.Sale;

public interface SaleRepositoryCustom {
	
	List<Sale> findSaleByNameOrPhone(Sale sale);
	
	boolean checkSaleByCustomerId(Integer id);
	
	List<Sale> findSalesByYear(Integer year);
	
	List<Sale> findSalesByMonthAndYear(Integer year, Integer month);
	
	List<Sale> findSaleByCustomerId(Integer customerId);
}
