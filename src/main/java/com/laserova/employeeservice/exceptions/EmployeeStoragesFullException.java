package com.laserova.employeeservice.exceptions;

public class EmployeeStoragesFullException extends RuntimeException{
    public EmployeeStoragesFullException (String message){
        super(message);
    }
}
