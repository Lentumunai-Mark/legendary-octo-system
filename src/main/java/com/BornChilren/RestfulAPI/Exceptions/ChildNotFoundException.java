package com.BornChilren.RestfulAPI.Exceptions;

public class ChildNotFoundException extends RuntimeException{
    public ChildNotFoundException(Long id){
        super("couln't find the child with Id " + id);
    }
}
