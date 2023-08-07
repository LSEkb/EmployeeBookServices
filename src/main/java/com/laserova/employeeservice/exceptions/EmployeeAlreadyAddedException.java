package com.laserova.employeeservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Такой сотрудник уже есть")
public class EmployeeAlreadyAddedException extends RuntimeException{
}
