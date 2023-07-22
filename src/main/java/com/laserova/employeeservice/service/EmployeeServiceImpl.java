package com.laserova.employeeservice.service;

import com.laserova.employeeservice.dto.Employee;
import com.laserova.employeeservice.exceptions.EmployeeAlreadyAddedException;
import com.laserova.employeeservice.exceptions.EmployeeNotFoundException;
import com.laserova.employeeservice.exceptions.EmployeeStoragesFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final List<Employee> employees;
    private static final int MAX_QTY_EMPLOYEES = 10;

    public EmployeeServiceImpl() {
        this.employees = new ArrayList<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        if (employees.size() == MAX_QTY_EMPLOYEES) {
            throw new EmployeeStoragesFullException("Количество сотрудников уже достигло максимально возможного значения");
        }
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть");
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            employees.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException("Такой сотрудник не найден");
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException("Такой сотрудник не найден");
    }

    @Override
    public Collection <Employee> printAllEmployees() {
        return Collections.unmodifiableList(employees);
    }
}

