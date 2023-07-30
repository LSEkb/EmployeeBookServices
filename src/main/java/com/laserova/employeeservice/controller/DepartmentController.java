package com.laserova.employeeservice.controller;

import com.laserova.employeeservice.dto.Employee;
import com.laserova.employeeservice.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee findMaxSalaryEmployee(@RequestParam int departmentId){
        return departmentService.findMaxSalaryEmployee(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee findMinSalaryEmployee(@RequestParam int departmentId){
        return departmentService.findMinSalaryEmployee(departmentId);
    }

    @GetMapping("/all")
    public Collection<Employee> getAll(int departmentId){
        return departmentService.getAll(departmentId);
    }

    @GetMapping
    public Map<Integer, List<Employee>> getAllGroupingByDepartment(){
        return departmentService.getAllGroupingByDepartment();
    }

}