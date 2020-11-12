package com.eureka.mapgroup.repository;


import com.eureka.mapgroup.entities.MapGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapGroupLoadDatabase {
	private static final Logger log = LoggerFactory.getLogger(MapGroupLoadDatabase.class);

	@Bean
	CommandLineRunner initDatabase(MapGroupRepository repository) {
	    return args -> {
	      log.info("Preloading " + repository.save(new MapGroup("White Council", 1, "1,2")));
	    };
	}

}
