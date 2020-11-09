package com.eureka.mapgroup.controllers;

class MapGroupNotFoundException extends RuntimeException {
	MapGroupNotFoundException(int id){
		super("Could not find map " + id);
	}
}
