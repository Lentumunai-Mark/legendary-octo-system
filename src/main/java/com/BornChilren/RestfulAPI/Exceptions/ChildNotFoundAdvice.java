package com.BornChilren.RestfulAPI.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ChildNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(ChildNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String childNotFoundHandler(ChildNotFoundException message){
        return message.getMessage();
    }
}
