package com.laserova.employeeservice.service.Impl;

import com.laserova.employeeservice.dto.Employee;
import com.laserova.employeeservice.exceptions.EmployeeAlreadyAddedException;
import com.laserova.employeeservice.exceptions.EmployeeIllegalNameException;
import com.laserova.employeeservice.exceptions.EmployeeNotFoundException;
import com.laserova.employeeservice.exceptions.EmployeeStoragesFullException;
import com.laserova.employeeservice.service.EmployeeService;
import org.apache.commons.lang3.StringUtils;
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
            throw new EmployeeStoragesFullException();
        }
        Employee employee = new Employee(
                StringUtils.capitalize(firstName),
                StringUtils.capitalize(lastName),
                department,
                salary);
        String key = firstName + lastName;
        if (employeeMap.containsKey(key)) {
            throw new EmployeeAlreadyAddedException();
        }
        employeeMap.put(key, employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = employeeMap.remove(firstName + lastName);
        if (Objects.isNull(employee)) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = employeeMap.get(firstName + lastName);
        if (Objects.isNull(employee)) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    @Override
    public Collection<Employee> findAllEmployees() {

        return employeeMap.values();
    }
}

