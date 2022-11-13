package com.skypro.employeebook.model;

public class Employee {
    private final String firstName;
    private final String lastName;
    private final int department;
    private final double salary;
    private static int countId = 1;
    private final int id;

    public Employee(String firstName, String lastName, int department, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
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
