package com.victommasi.repository;

import java.math.BigDecimal;
import java.util.List;

import com.victommasi.model.Sale;

public interface SaleRepositoryCustom {
	
	List<Sale> findSaleByNameOrPhone(Sale sale);
	
	boolean checkSaleByCustomerId(Integer id);
	
	BigDecimal sumSalesByYear(Integer year);
	
	BigDecimal sumSalesByMonthAndYear(Integer year, Integer month);

	List<Sale> findSaleByCustomerId(Integer customerId);

	BigDecimal sumSales();

	BigDecimal avgSales();
}
