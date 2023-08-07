package com.laserova.employeeservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "Такой сотрудник не найден")
public class EmployeeNotFoundException extends RuntimeException{
    }

