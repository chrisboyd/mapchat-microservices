package com.eureka.mapgroup.controllers;

import com.eureka.mapgroup.entities.Message;
import com.eureka.mapgroup.repository.MapGroupRepository;
import com.eureka.mapgroup.repository.MessageRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.validation.Valid;

@RestController
public class MessageController {
	private static final Logger logger = LogManager.getLogger();
	
	@Autowired
	private MessageRepository messageRepository;
	
	@Autowired
	private MapGroupRepository mapGroupRepository;
	
	@GetMapping("/{mapGroupId}/messages")
	public Page<Message> getAllMessagesByGroupId(@PathVariable (value = "mapGroupId") int mapGroupId,
            Pageable pageable){
				logger.info("GET all messages MapGroupID: " + mapGroupId);
            	return messageRepository.findByMapGroupId(mapGroupId, pageable);
    }

	@PostMapping("/{mapGroupId}/messages")
	public Message createMessage(@PathVariable (value = "mapGroupId") int mapGroupId,
								@Valid @RequestBody Message message) {
		return mapGroupRepository.findById(mapGroupId).map(mapGroup -> {
			logger.info("POST message to MapGroupID: " + mapGroupId);
			message.setMapGroup(mapGroup);
			return messageRepository.save(message);
		}).orElseThrow(() -> new MapGroupNotFoundException(mapGroupId));
	}
	
	
	
	

}
