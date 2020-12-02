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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.servlet.http.*;



@RestController
@RequestMapping("/")
public class MapGroupController {
	private static final Logger logger = LogManager.getLogger();

	@Autowired
	private final MapGroupRepository mapGroupRepository;
	
	@Autowired
	private Environment env;
	
	MapGroupController(MapGroupRepository repository){
		this.mapGroupRepository = repository;		
	}
	
	@RequestMapping("/test")
	public void errorLog(HttpServletRequest request) {
		//show working error command
		logger.error(request.getRemoteAddr() + " exceeded request threshold, blocking access for 10 minutes");
	}
	
	//Aggregate
	@GetMapping("/")
	List<MapGroup> all(HttpServletRequest request) {
		logger.info("GET all MapGroup " + request.getRemoteAddr());
		return mapGroupRepository.findAll();
	}
	
	@PostMapping("/")
	MapGroup newMapGroup(HttpServletRequest request,@RequestBody MapGroup newMapGroup) {
		logger.info("POST new MapGroup" + newMapGroup.toString() + " " + request.getRemoteAddr());
		return mapGroupRepository.save(newMapGroup);
	}
	
	@PutMapping("/{id}")
	MapGroup replaceMapGroup(HttpServletRequest request,@RequestBody MapGroup newMapGroup, @PathVariable int id) {
	    return mapGroupRepository.findById(id)
	      .map(mapgroup -> {
	    	  logger.info("PUT, id: " + id + " " + mapgroup.getName() +"->" + newMapGroup.getName()
	    	  + " " + request.getRemoteAddr());
	    	  mapgroup.setName(newMapGroup.getName());
	    	  return mapGroupRepository.save(mapgroup);
	      })
	      .orElseGet(() -> {
	    	logger.info("PUT newMapGroup: " + newMapGroup.toString() + " " + request.getRemoteAddr());
	        newMapGroup.setId(id);
	        return mapGroupRepository.save(newMapGroup);
	      });
	}
	
	@DeleteMapping("/{id}")
	void deleteMapGroup(HttpServletRequest request,@PathVariable int id) {
		logger.info("DELTE MapGroup id: " + id + " " + request.getRemoteAddr());
		mapGroupRepository.deleteById(id);
	}
	
	@GetMapping("/members")
	String getMembers(HttpServletRequest request,@PathVariable int id){
		logger.info("getMapGroupMembers id: " + id + " " + request.getRemoteAddr());
		return mapGroupRepository.findById(id).get().getMembers();
				
	}
	
}
