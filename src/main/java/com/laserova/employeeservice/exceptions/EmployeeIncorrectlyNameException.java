package com.laserova.employeeservice.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;



@ResponseStatus(BAD_REQUEST)
public class EmployeeIncorrectlyNameException extends RuntimeException{
    public EmployeeIncorrectlyNameException (String message){
        super(message);
    }
}

