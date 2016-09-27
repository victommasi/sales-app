package com.victommasi.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.victommasi.model.Customer;
import com.victommasi.model.Status;

@Repository
public class CustomerRepositoryImpl implements CustomerRepositoryCustom {

	@PersistenceContext
	EntityManager manager;
	
	@Override
	public List<Customer> findByNameOrPhone(Customer customer) {
		String jpql = "select c from Customer c where c.name like :name "
					+ "and c.phone like :phone";
		return this.manager
				.createQuery(jpql, Customer.class)
				.setParameter("name", "%" + customer.getName() + "%")
				.setParameter("phone", "%" + customer.getPhone() + "%")
				.getResultList();
	}

	@Override
	public List<Customer> findByStatusNegociating() {
		String jpql = "select c from Customer c where c.status = :status";
		return this.manager
				.createQuery(jpql, Customer.class)
				.setParameter("status", Status.NEGOCIATING)
				.getResultList();
	}

	@Override
	public List<Customer> findByStatusAccepted() {
		String jpql = "select c from Customer c where c.status = :status";
		return this.manager
				.createQuery(jpql, Customer.class)
				.setParameter("status", Status.ACCEPTED)
				.getResultList();
	}

	@Override
	public List<Customer> findByStatusRefused() {
		String jpql = "select c from Customer c where c.status = :status";
		return this.manager
				.createQuery(jpql, Customer.class)
				.setParameter("status", Status.REFUSED)
				.getResultList();
	}
}
