package com.laserova.employeeservice.service.Impl;

import com.laserova.employeeservice.dto.Employee;
import com.laserova.employeeservice.exceptions.EmployeeAlreadyAddedException;
import com.laserova.employeeservice.exceptions.EmployeeNotFoundException;
import com.laserova.employeeservice.exceptions.EmployeeStoragesFullException;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


class EmployeeServiceImplTest {
    EmployeeServiceImpl underTest = new EmployeeServiceImpl();
    Employee employee = new Employee("Ivan", "Ivanov", 1, 30000);

    @Test
    void addEmployee_exceedingMaxEmployeeQuantity_thrownEmployeeStoragesFullException() {
        int MAX_QTY = 10;//не поняла, как передать приватную константу, просто ввела вручную
        for (int i = 0; i < MAX_QTY; i++) {
            underTest.addEmployee("Ivan" + String.valueOf(i), "Ivanov", 1, 2000);
        }
        assertThrows(EmployeeStoragesFullException.class, () -> underTest.addEmployee("Ivan" + MAX_QTY,
                "Ivanov", 1, 20000));
    }

    @Test
    void addEmployee_addEmployeeIsAlreadyInMap_thrownEmployeeAlreadyAddedException() {
        underTest.addEmployee(employee.getFirstName(), employee.getLastName(),
                employee.getDepartment(), employee.getSalary());
        assertThrows(EmployeeAlreadyAddedException.class, () -> underTest.addEmployee(employee.getFirstName(), employee.getLastName(),
                employee.getDepartment(), employee.getSalary()));
    }

    @Test
    void addEmployee_addEmployeeNotInMap_employeeAddedAndReturned() {
        Employee result = underTest.addEmployee(employee.getFirstName(), employee.getLastName(),
                employee.getDepartment(), employee.getSalary());
       assertEquals(employee,result);
       assertTrue(underTest.findAllEmployees().contains(employee));
    }

    @Test
    void findEmployee_employeeNotInMap_thrownEmployeeNotFoundException() {
        assertThrows(EmployeeNotFoundException.class,
                () -> underTest.findEmployee(employee.getFirstName(), employee.getLastName()));
    }

    @Test
    void findEmployee_employeeIsInMap_employeeFindAndReturned() {
        underTest.addEmployee(employee.getFirstName(), employee.getLastName(),
                employee.getDepartment(), employee.getSalary());
        Employee result = underTest.findEmployee(employee.getFirstName(), employee.getLastName());
        assertEquals(employee, result);
        assertTrue(underTest.findAllEmployees().contains(employee));
    }

    @Test
    void removeEmployee_employeeNotInMap_thrownEmployeeNotFoundException() {
        assertThrows(EmployeeNotFoundException.class,
                () -> underTest.removeEmployee(employee.getFirstName(), employee.getLastName()));
    }

    @Test
    void removeEmployee_employeeIsInMap_employeeRemovedAndReturned() {
        underTest.addEmployee(employee.getFirstName(), employee.getLastName(),
                employee.getDepartment(), employee.getSalary());
        Employee result = underTest.removeEmployee(employee.getFirstName(), employee.getLastName());
        assertEquals(employee, result);
        assertFalse(underTest.findAllEmployees().contains(employee));
    }

    @Test
    void findAllEmployees_hasNoEmployees_returnEmptyCollections() {
        Collection<Employee> result = underTest.findAllEmployees();
        assertIterableEquals(Collections.emptySet(), result);
    }

    @Test
    void findAllEmployees_haveEmployees_returnEmployList() {
        underTest.addEmployee(employee.getFirstName(), employee.getLastName(),
                employee.getDepartment(), employee.getSalary());
        Collection <Employee> result = underTest.findAllEmployees();
        assertIterableEquals(Set.of(employee), result);
    }
}