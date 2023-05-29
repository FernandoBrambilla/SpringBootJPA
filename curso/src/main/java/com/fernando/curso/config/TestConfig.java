package com.fernando.curso.config;



import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.fernando.curso.entities.Category;
import com.fernando.curso.entities.Order;
import com.fernando.curso.entities.OrderItem;
import com.fernando.curso.entities.Product;
import com.fernando.curso.entities.User;
import com.fernando.curso.entities.enums.OrderStatus;
import com.fernando.curso.repositories.CategoryRepository;
import com.fernando.curso.repositories.OrderItemRepository;
import com.fernando.curso.repositories.OrderRepository;
import com.fernando.curso.repositories.ProductRepository;
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
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Eletronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		Product p1 = new Product(null, "The Lord of Rings", "The Book complete, ed 2023", 100.0, "");
		Product p2 = new Product(null, "SmartTv", "Tv 50'' Led 4k", 1300.0, "");
		Product p3 = new Product(null, "Notebook Acer", "I5 ssd480gb 8gb", 100.0, "");
		productRepository.saveAll(Arrays.asList(p1,p2,p3));
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		productRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		userRepository.saveAll(Arrays.asList(u1,u2));
	
		Order o1 = new Order(null, Instant.now(),OrderStatus.PAID, u2);
		Order o2 = new Order(null, Instant.now(),OrderStatus.DELIVERED, u1);
		orderRepository.saveAll(Arrays.asList(o1,o2));
		
		OrderItem oi1 = new OrderItem(o1,p1,2,p1.getPrice());
		OrderItem oi2 = new OrderItem(o1,p3,1,p3.getPrice());
		OrderItem oi3 = new OrderItem(o2,p2,4,p2.getPrice());
		OrderItem oi4 = new OrderItem(o2,p3,2,p3.getPrice());
		orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
		
		
		
		
	}

}
