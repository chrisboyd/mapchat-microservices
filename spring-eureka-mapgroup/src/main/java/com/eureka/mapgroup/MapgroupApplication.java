package com.eureka.mapgroup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class MapgroupApplication {

	public static void main(String[] args) {
		SpringApplication.run(MapgroupApplication.class, args);
	}
}


@Configuration
class RestTemplateConfig {
	
	// Create a bean for restTemplate to call services
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
}
