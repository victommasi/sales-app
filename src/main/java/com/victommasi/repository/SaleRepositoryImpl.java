package com.victommasi.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
 
import org.springframework.stereotype.Repository;

import com.victommasi.model.Sale;

@Repository
public class SaleRepositoryImpl implements SaleRepositoryCustom {

	@PersistenceContext
	EntityManager manager;
	
	@Override
	public List<Sale> findSaleByNameOrPhone(Sale sale){
		String jpql = "SELECT s FROM Sale s JOIN s.customer c "
					+ "where c.name like :name "
					+ "and c.phone like :phone";
		return manager.createQuery(jpql, Sale.class)
			   .setParameter("name", "%" + sale.getCustomer().getName() + "%")
			   .setParameter("phone", "%" + sale.getCustomer().getPhone() + "%")
			   .getResultList();
	}

	@Override
	public boolean checkSaleByCustomerId(Integer id) {
		String jpql = "SELECT s FROM Sale s JOIN s.customer c "
				+ "where c.id = :id";
		 List<Sale> query = manager.createQuery(jpql, Sale.class)
		   .setParameter("id", id)
		   .getResultList();
		 if (query.isEmpty()){
			 return false;
		 }
		return true;
	}

	@Override
	public List<Sale> findSalesByYear(Integer year) {
		String jpql = "SELECT s FROM Sale s WHERE YEAR(date) = :year";
		List<Sale> list = manager.createQuery(jpql, Sale.class)
			   .setParameter("year", year)
			   .getResultList();
		return list;
	}
	
	@Override
	public List<Sale> findSalesByMonthAndYear(Integer year, Integer month) {
		String jpql = "SELECT s FROM Sale s WHERE MONTH(date) = :month "
					+ "and YEAR(date) = :year";
		List<Sale> list = manager.createQuery(jpql, Sale.class)
			   .setParameter("month", month)
			   .setParameter("year", year)
			   .getResultList();
		return list;
	}
	
	@Override
	public List<Sale> findSaleByCustomerId(Integer customerId) {
		String jpql = "SELECT s FROM Sale s WHERE customer_id = :customerId";
		List<Sale> list = manager.createQuery(jpql, Sale.class)
			   .setParameter("customerId", customerId)
			   .getResultList();
		return list;
	}

}
