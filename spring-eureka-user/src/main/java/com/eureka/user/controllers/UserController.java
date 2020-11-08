package com.eureka.user.controllers;

import com.eureka.user.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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

}
