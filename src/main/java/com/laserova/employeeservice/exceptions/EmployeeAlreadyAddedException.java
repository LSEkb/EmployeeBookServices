package com.laserova.employeeservice.exceptions;

public class EmployeeAlreadyAddedException extends RuntimeException{
    public EmployeeAlreadyAddedException (String message){
        super(message);
    }
}
