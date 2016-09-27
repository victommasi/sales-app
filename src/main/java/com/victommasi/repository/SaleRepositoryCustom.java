package com.victommasi.repository;

import java.util.List;

import com.victommasi.model.Customer;
import com.victommasi.model.Sale;

public interface SaleRepositoryCustom {
	
	public List<Sale> findByNameOrPhone(Sale sale);
	public boolean findById(Integer id);
}
