package com.eureka.user.repository;

import com.eureka.user.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserLoadDatabase {
	private static final Logger log = LoggerFactory.getLogger(UserLoadDatabase.class);

	@Bean
	  CommandLineRunner initDatabase(UserRepository repository) {

	    return args -> {
	      log.info("Preloading " + repository.save(new User("Beren","Erchamion","silmaril@gmail.com","1234567890")));
	      log.info("Preloading " + repository.save(new User("Luthien","Tinúviel","silmaril2@gmail.com","1234567891")));
	      log.info("Preloading " + repository.save(new User("Glorfindel","Balrog-Slayer","winner@gmail.com","1234567892")));
	      log.info("Preloading " + repository.save(new User("Húrin","Thalion","cursed@gmail.com","1234567893")));
	      
	    };
	  }
}
