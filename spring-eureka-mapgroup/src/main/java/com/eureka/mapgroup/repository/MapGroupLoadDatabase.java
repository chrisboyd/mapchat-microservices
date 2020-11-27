package com.eureka.mapgroup.repository;


import com.eureka.mapgroup.entities.MapGroup;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapGroupLoadDatabase {
	private static final Logger log = LogManager.getLogger();
	@Bean
	CommandLineRunner initDatabase(MapGroupRepository repository) {
	    return args -> {
	      log.info("Preloading " + repository.save(new MapGroup("White Council", 1, "1,2")));
	      log.info("Preloading " + repository.save(new MapGroup("Dark Council", 2, "1,2")));
	      
	    };
	}

}
