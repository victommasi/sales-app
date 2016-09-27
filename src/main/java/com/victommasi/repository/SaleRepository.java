package com.victommasi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victommasi.model.Sale;


public interface SaleRepository extends JpaRepository<Sale, Integer>, SaleRepositoryCustom {

}


