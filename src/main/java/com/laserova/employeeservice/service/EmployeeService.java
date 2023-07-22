package com.laserova.employeeservice.service;

import com.laserova.employeeservice.Employee;

import java.util.List;

public interface EmployeeService {
    Employee add(String firstName, String lastName);
    Employee remove(String firstName, String lastName);
    Employee find(String firstName, String lastName);
    List<Employee> print();
}
