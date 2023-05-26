package com.fernando.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fernando.curso.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	
}
