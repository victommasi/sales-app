package com.victommasi.repository;

import java.util.List;

import com.victommasi.model.Sale;

public interface SaleRepositoryCustom {
	
	public List<Sale> findSaleByNameOrPhone(Sale sale);
	public boolean findSaleById(Integer id);
	public List<Sale> findSalesByYear(Integer year);
	public List<Sale> findSalesByMonthAndYear(Integer year, Integer month);
}
