package com.laserova.employeeservice.dto;

import java.util.Objects;

public class Employee {
    private String lastName;
    private String firstName;


    public Employee(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public String toString() {
        return " ФИО - " + lastName + " " + firstName;
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
        return (lastName == ((Employee) other).getLastName() && firstName == ((Employee) other).getFirstName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName);
    }
}


