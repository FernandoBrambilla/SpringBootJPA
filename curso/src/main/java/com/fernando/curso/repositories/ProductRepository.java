package com.fernando.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fernando.curso.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	
}
