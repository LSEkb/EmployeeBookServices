package com.laserova.employeeservice.dto;

import java.util.Objects;

public class Employee {
    private String lastName;
    private String firstName;
    private int department;
    private double salary;


    public Employee(String firstName, String lastName, int department, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + department + " " + salary;
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
        return lastName.equals(employee.getLastName()) && firstName.equals(employee.getFirstName())&&
                department==employee.getDepartment()&&salary==employee.getSalary();
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName);
    }
}


