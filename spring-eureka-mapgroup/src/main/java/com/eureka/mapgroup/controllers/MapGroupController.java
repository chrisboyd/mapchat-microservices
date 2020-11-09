package com.eureka.mapgroup.controllers;

import com.eureka.mapgroup.entities.MapGroup;
import com.eureka.mapgroup.repository.MapGroupRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/")
public class MapGroupController {
	private static final Logger log = LoggerFactory.getLogger(MapGroupController.class);

	@Autowired
	private final MapGroupRepository mapGroupRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private Environment env;
	
	MapGroupController(MapGroupRepository repository){
		this.mapGroupRepository = repository;		
	}
	
	@RequestMapping("/port")
	public String home() {
		// This is useful for debugging
		// When having multiple instance of gallery service running at different ports.
		// We load balance among them, and display which instance received the request.
		return "Hello from MapGroup Service running at port: " + env.getProperty("local.server.port");
	}
	
	//Aggregate
	@GetMapping("/")
	List<MapGroup> all() {
		return mapGroupRepository.findAll();
	}
	
	@PostMapping("/")
	MapGroup newMapGroup(@RequestBody MapGroup newMapGroup) {
		log.info("POST mapGroup" + newMapGroup.getMembers());
		return mapGroupRepository.save(newMapGroup);
	}
	
	@PutMapping("/{id}")
	MapGroup replaceMapGroup(@RequestBody MapGroup newMapGroup, @PathVariable int id) {
	    return mapGroupRepository.findById(id)
	      .map(mapgroup -> {
	    	  mapgroup.setName(newMapGroup.getName());
	    	  return mapGroupRepository.save(mapgroup);
	      })
	      .orElseGet(() -> {
	        newMapGroup.setId(id);
	        return mapGroupRepository.save(newMapGroup);
	      });
	}
	
	@DeleteMapping("/{id}")
	void deleteMapGroup(@PathVariable int id) {
		mapGroupRepository.deleteById(id);
	}
	
	@GetMapping("/members")
	int getMembers(@PathVariable int id){
		return mapGroupRepository.findById(id).get().getMembers();
				
	}
	
}
