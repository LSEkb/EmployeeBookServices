package com.laserova.employeeservice.service.Impl;

import com.laserova.employeeservice.dto.Employee;
import com.laserova.employeeservice.exceptions.EmployeeNotFoundException;
import com.laserova.employeeservice.service.DepartmentService;
import com.laserova.employeeservice.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee findMaxSalaryEmployee(int department) {
        return employeeService.findAllEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee findMinSalaryEmployee(int department) {
        return employeeService.findAllEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Collection<Employee> getAll(int department) {
        return employeeService.findAllEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getAllGroupingByDepartment() {
        return employeeService.findAllEmployees().stream()
                .collect(Collectors.groupingBy(e ->e.getDepartment()));
    }
}
