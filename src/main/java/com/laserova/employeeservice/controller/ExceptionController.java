package com.laserova.employeeservice.controller;

import com.laserova.employeeservice.exceptions.EmployeeAlreadyAddedException;
import com.laserova.employeeservice.exceptions.EmployeeIncorrectlyNameException;
import com.laserova.employeeservice.exceptions.EmployeeNotFoundException;
import com.laserova.employeeservice.exceptions.EmployeeStoragesFullException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler({EmployeeAlreadyAddedException.class, EmployeeStoragesFullException.class,
            EmployeeNotFoundException.class, EmployeeIncorrectlyNameException.class})
    public ResponseEntity<String> handleException(Exception error) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Получена ошибка: " + error.getMessage());
    }
}
