package com.laserova.employeeservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ResponseStatus(BAD_REQUEST)
public class EmployeeStoragesFullException extends RuntimeException{
    public EmployeeStoragesFullException (String message){
        super(message);
    }
}
