package com.laserova.employeeservice.service;

import com.laserova.employeeservice.dto.Employee;
import com.laserova.employeeservice.exceptions.EmployeeAlreadyAddedException;
import com.laserova.employeeservice.exceptions.EmployeeIncorrectlyNameException;
import com.laserova.employeeservice.exceptions.EmployeeNotFoundException;
import com.laserova.employeeservice.exceptions.EmployeeStoragesFullException;
import org.springframework.stereotype.Service;

import java.util.*;

import static org.apache.commons.lang3.StringUtils.*;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employeeMap;
    private static final int MAX_QTY_EMPLOYEES = 10;


    public EmployeeServiceImpl() {

        this.employeeMap = new HashMap<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, int department, double salary) {
        if (employeeMap.size() == MAX_QTY_EMPLOYEES) {
            throw new EmployeeStoragesFullException("Количество сотрудников уже достигло максимально возможного значения");
        }
        Employee employee = new Employee(firstName, lastName, department, salary);
        String key = firstName + lastName;
        if (employeeMap.containsKey(key)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть");
        }
        employeeMap.put(key, employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = employeeMap.remove(firstName + lastName);
        if (Objects.isNull(employee)) {
            throw new EmployeeNotFoundException("Такой сотрудник не найден");
        }
        return employee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = employeeMap.get(firstName + lastName);
        if (Objects.isNull(employee)) {
            throw new EmployeeNotFoundException("Такой сотрудник не найден");
        }
        return employee;
    }

    @Override
    public Collection<Employee> findAllEmployees() {

        return employeeMap.values();
    }

    @Override
    public void verifyName(String name) {
        if (!isAlpha(name)) {
            throw new EmployeeIncorrectlyNameException("Недопустимые символы в фамилии или имени сотрудника");
        }
    }

    @Override
    public String exportName(String name) {
        System.out.println(capitalize(name));
        return capitalize(name);
    }

    @Override
    public String adaptName(String name) {
        verifyName(name);
        exportName(name);
        return name;
    }

}

