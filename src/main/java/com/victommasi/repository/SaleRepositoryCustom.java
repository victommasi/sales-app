package com.victommasi.repository;

import java.util.List;

import com.victommasi.model.Sale;

public interface SaleRepositoryCustom {
	
	public List<Sale> findSaleByNameOrPhone(Sale sale);
	public boolean checkSaleByCustomerId(Integer id);
	public List<Sale> findSalesByYear(Integer year);
	public List<Sale> findSalesByMonthAndYear(Integer year, Integer month);
	public List<Sale> findSaleByCustomerId(Integer customerId);
}
