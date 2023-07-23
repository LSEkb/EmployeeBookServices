package com.laserova.employeeservice.service;

import com.laserova.employeeservice.dto.Employee;

import java.util.Collection;
import java.util.List;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName);
    Employee removeEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);
    Collection<Employee> printAllEmployees();
}
