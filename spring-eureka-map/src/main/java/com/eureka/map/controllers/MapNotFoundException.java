package com.eureka.map.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
class MapNotFoundException extends RuntimeException {
	MapNotFoundException(int id){
		super("Could not find map " + id);
	}
}
