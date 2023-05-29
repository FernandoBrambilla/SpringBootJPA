package com.fernando.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fernando.curso.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
	
	
}
