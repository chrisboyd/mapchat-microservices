package com.eureka.mapgroup.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@ControllerAdvice
class MapGroupNotFoundAdvice {
	private static final Logger logger = LogManager.getLogger();
  @ResponseBody
  @ExceptionHandler(MapGroupNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String mapNotFoundHandler(MapGroupNotFoundException ex) {
	  logger.error("MapGroupNotFoundException " + ex.getMessage());
	  return ex.getMessage();
  }
}
