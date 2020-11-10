package com.eureka.mapgroup.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
class MapGroupNotFoundException extends RuntimeException {
	MapGroupNotFoundException(int id){
		super("Could not find map " + id);
	}
}
