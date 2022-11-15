package com.skypro.employeebook.model;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class Employee {
    private final String firstName;
    private final String lastName;
    private final int department;
    private final double salary;
    private static int countId = 1;
    private final int id;

    public Employee(String firstName, String lastName, int department, double salary) {
        if (!StringUtils.isAllBlank(firstName)){
            this.firstName = StringUtils.capitalize(firstName);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        if (!StringUtils.isAllBlank(lastName)){
            this.lastName = StringUtils.capitalize(lastName);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        this.department = department;
        this.salary = salary;
        this.id = countId++;
    }


    public String getFirstName() {
        return firstName;
    }

    public int getId() {
        return id;
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
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                ", id=" + id +
                '}';
    }
}
