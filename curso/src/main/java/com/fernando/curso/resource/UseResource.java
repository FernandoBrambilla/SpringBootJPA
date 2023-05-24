package com.fernando.curso.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fernando.curso.entities.User;

@RestController
@RequestMapping(value= "/users")
public class UseResource {
	
	@GetMapping
	public ResponseEntity<User> findAll(){
		User user = new User(1l,"Joseda Silva","jose@email.com","44999998888","olamundo");
		return ResponseEntity.ok().body(user);
	}

	
}
 