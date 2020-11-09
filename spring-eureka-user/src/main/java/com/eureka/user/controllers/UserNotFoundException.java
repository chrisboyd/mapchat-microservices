package com.eureka.user.controllers;

class UserNotFoundException extends RuntimeException {
	UserNotFoundException(int id){
		super("Could not find user " + id);
	}
}
