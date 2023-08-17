package com.laserova.employeeservice.service.Impl;

import com.laserova.employeeservice.dto.Employee;
import com.laserova.employeeservice.exceptions.EmployeeNotFoundException;
import com.laserova.employeeservice.service.EmployeeService;
import net.bytebuddy.description.type.TypeList;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {

    @Mock
    EmployeeService employeeService;

    @InjectMocks
    DepartmentServiceImpl underTest;

    Employee alex = new Employee("Alex", "Ivanov", 1, 40000);
    Employee ivan = new Employee("Ivan", "Ivanov", 1, 50000);
    Employee irina = new Employee("Irina", "Glebova", 1, 45000);
    Employee mark = new Employee("Mark", "Nikolaev", 3, 60000);

    Collection<Employee> employees;

    @BeforeEach
    void beforeEach() {
        employees = List.of(alex, ivan, irina, mark);
    }

    @Test
    void findMaxSalaryEmployee_employeeFind_returnEmployeeWithMaxSalary() {
        when(employeeService.findAllEmployees()).thenReturn(employees);
        Employee result = underTest.findMaxSalaryEmployee(1);
        assertEquals(ivan, result);
    }

    @Test
    void findMaxSalaryEmployee_employeeNotFound_thrownEmployeeNotFoundException() {
        when(employeeService.findAllEmployees()).thenReturn(Collections.emptyList());
        assertThrows(EmployeeNotFoundException.class, () -> underTest.findMaxSalaryEmployee(1));
    }

    @Test
    void findMinSalaryEmployee_employeeFind_returnEmployeeWithMinSalary() {
        when(employeeService.findAllEmployees()).thenReturn(employees);
        Employee result = underTest.findMinSalaryEmployee(1);
        assertEquals(alex, result);
    }

    @Test
    void findMinSalaryEmployee_employeeNotFound_thrownEmployeeNotFoundException() {
        when(employeeService.findAllEmployees()).thenReturn(Collections.emptyList());
        assertThrows(EmployeeNotFoundException.class, () -> underTest.findMinSalaryEmployee(1));
    }

    @Test
    void getAll_HasNoEmployeeInDepartment_returnEmptyCollections() {
        when(employeeService.findAllEmployees()).thenReturn(employees);
        Collection<Employee> result = underTest.getAll(2);
        assertIterableEquals(Collections.emptySet(), result);
    }

    @Test
    void getAll_HaveEmployeeInDepartment_returnEmployeeCollectionsInDepartment() {
        when(employeeService.findAllEmployees()).thenReturn(employees);
        Collection<Employee> result = underTest.getAll(1);
        assertIterableEquals(Arrays.asList(new Employee[]{alex, ivan, irina,}), result);
    }

    @Test
    void getAllGroupingByDepartment_HaveEmployeeInDepartment_returnEmployeeCollectionsGroupingByDepartment() {
        when(employeeService.findAllEmployees()).thenReturn(employees);
        Map<Integer, List<Employee>> result = underTest.getAllGroupingByDepartment();
        Map<Integer, List<Employee>> expect = employeeService.findAllEmployees().stream()
                .collect(Collectors.groupingBy(e ->e.getDepartment()));
        assertEquals(expect, result);
    }

}