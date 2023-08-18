package com.laserova.employeeservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ResponseStatus(code = HttpStatus.BAD_REQUEST,reason = "Добавить еще одного сотрудника невозможно - нет вакантных мест")
public class EmployeeStoragesFullException extends RuntimeException{
}
