package com.laserova.employeeservice.service;

import com.laserova.employeeservice.dto.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName, int department, double salary);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    Collection<Employee> findAllEmployees();

    void verifyName (String name);

    String exportName (String name);
    String adaptName(String name);
}
