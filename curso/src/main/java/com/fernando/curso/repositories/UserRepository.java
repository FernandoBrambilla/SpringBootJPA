package com.fernando.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fernando.curso.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	
}
