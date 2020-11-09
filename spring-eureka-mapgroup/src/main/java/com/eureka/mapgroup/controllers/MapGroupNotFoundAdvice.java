package com.eureka.mapgroup.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class MapGroupNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(MapGroupNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String mapNotFoundHandler(MapGroupNotFoundException ex) {
    return ex.getMessage();
  }
}
