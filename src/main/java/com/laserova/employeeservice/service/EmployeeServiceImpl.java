package com.laserova.employeeservice.service;

import com.laserova.employeeservice.Employee;
import com.laserova.employeeservice.exceptions.EmployeeAlreadyAddedException;
import com.laserova.employeeservice.exceptions.EmployeeNotFoundException;
import com.laserova.employeeservice.exceptions.EmployeeStoragesFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    List<Employee> employees = new ArrayList<>(List.of());
    private static final int MAX_QTY_EMPLOYEES = 10;


    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.size() == MAX_QTY_EMPLOYEES) {
            throw new EmployeeStoragesFullException("Количество сотрудников уже достигло максимально возможного значения");
        } else if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть");
        } else {
            employees.add(employee);
        }
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("Такой сотрудник не найден");
        } else {
            employees.remove(employee);
        }
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("Такой сотрудник не найден");
        } else {
            return employee;
        }
    }

    @Override
    public List<Employee> print() {
        return employees;
    }
}

