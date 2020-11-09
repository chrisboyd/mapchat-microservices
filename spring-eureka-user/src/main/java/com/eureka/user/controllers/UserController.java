package com.eureka.user.controllers;

import com.eureka.user.entities.User;
import com.eureka.user.repository.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserController {
	private final UserRepository repository;
	
	@Autowired
	private Environment env;
	
	UserController(UserRepository repository){
		this.repository = repository;
	}
	
	@RequestMapping("/port")
	public String home() {
		// This is useful for debugging
		// When having multiple instance of gallery service running at different ports.
		// We load balance among them, and display which instance received the request.
		return "Hello from Map Service running at port: " + env.getProperty("local.server.port");
	}
	
	//Aggregate
	@GetMapping("/")
	List<User> all() {
		return repository.findAll();
	}
	
	@PostMapping("/")
	User newUser(@RequestBody User newUser) {
		
		return repository.save(newUser);
	}
	
	//Single Listing
	@GetMapping("/{id}")
	User one(@PathVariable int id) {
		return repository.findById(id)
			      .orElseThrow(() -> new UserNotFoundException(id));

	}
	
	@PutMapping("/{id}")
	  User replaceUser(@RequestBody User newUser, @PathVariable int id) {

	    return repository.findById(id)//
	    		.map(user->{
	    		  user.setFirstName(newUser.getFirstName());
	   	    	  user.setFirstName(newUser.getLastName());
	   	    	  user.setEmail(newUser.getEmail());
	   	    	  user.setPhoneNumber(newUser.getPhoneNumber());
	   	    	  return repository.save(user);
	    		})
	      .orElseGet(() -> {
	        newUser.setId(id);
	        return repository.save(newUser);
	      });
	  }

	  @DeleteMapping("/{id}")
	  void deleteUser(@PathVariable int id) {
	    repository.deleteById(id);
	  }
}
