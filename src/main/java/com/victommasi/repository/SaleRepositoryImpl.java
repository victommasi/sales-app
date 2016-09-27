package com.victommasi.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.victommasi.model.Sale;

@Repository
public class SaleRepositoryImpl implements SaleRepositoryCustom {

	@PersistenceContext
	EntityManager manager;
	
	@Override
	public List<Sale> findByNameOrPhone(Sale sale){
		String jpql = "SELECT s FROM Sale s JOIN s.customer c "
					+ "where c.name like :name "
					+ "and c.phone like :phone";
		return manager.createQuery(jpql, Sale.class)
			   .setParameter("name", "%" + sale.getCustomer().getName() + "%")
			   .setParameter("phone", "%" + sale.getCustomer().getPhone() + "%")
			   .getResultList();
	}

	@Override
	public boolean findById(Integer id) {
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
}
