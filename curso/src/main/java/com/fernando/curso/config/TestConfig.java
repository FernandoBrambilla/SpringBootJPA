package com.fernando.curso.config;



import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.fernando.curso.entities.Category;
import com.fernando.curso.entities.Order;
import com.fernando.curso.entities.User;
import com.fernando.curso.entities.enums.OrderStatus;
import com.fernando.curso.repositories.CategoryRepository;
import com.fernando.curso.repositories.OrderRepository;
import com.fernando.curso.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	@Autowired	
	private OrderRepository orderRepository;
	@Autowired	
	private CategoryRepository categoryRepository;
	
	

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Eletronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
	
		Order o2 = new Order(null, Instant.now(),OrderStatus.PAID, u2);
		Order o3 = new Order(null, Instant.now(),OrderStatus.DELIVERED, u1);
		
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o2,o3));
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
	}

}
