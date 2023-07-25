package com.laserova.employeeservice.dto;

import java.util.Objects;

public class Employee {
    private String lastName;
    private String firstName;
    public String getFullName;


    public Employee(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.getFullName = firstName + lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFullName() {
        return firstName + lastName;
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


