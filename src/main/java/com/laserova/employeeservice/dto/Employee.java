package com.laserova.employeeservice.dto;

import java.util.Objects;

public class Employee {
    private String lastName;
    private String firstName;
    private int department;
    private double salary;


    public Employee(String lastName, String firstName, int department, double salary) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.department = department;
        this.salary = salary;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Employee employee = (Employee) other;
        return lastName.equals(employee.getLastName()) && firstName.equals(employee.getFirstName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName);
    }
}


