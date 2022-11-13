package com.skypro.employeebook.service;

import com.skypro.employeebook.model.Employee;
import com.skypro.employeebook.record.EmployeeRequest;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final Map<Integer, Employee> employees = new HashMap<>();

    public Collection<Employee> getAllEmployees() {
        return this.employees.values();
    }

    public Employee addEmployee(EmployeeRequest employeeRequest) throws IllegalAccessException {
        if (employeeRequest.getFirstName() == null || employeeRequest.getLastName() == null) {
            throw new IllegalAccessException("Введите имя и фамилию");
        }
        Employee employee = new Employee(employeeRequest.getFirstName(),
                employeeRequest.getLastName(),
                employeeRequest.getDepartment(),
                employeeRequest.getSalary());

        this.employees.put(employee.getId(), employee);
        return employee;

    }

    public int getSalarySum() {
        return (int) employees.values().stream().
                mapToDouble(Employee::getSalary).sum();
    }

    public OptionalDouble getEmployeeWithMinSalary() {
        return employees.values().stream().mapToDouble(Employee::getSalary).min();
    }

    public OptionalDouble getEmployeeWithMaxSalary() {
        return employees.values().stream().mapToDouble(Employee::getSalary).max();
    }

    public List<Employee> getAllEmployeesWithAverageSalary(){
        var averageSalary = employees.values().stream().mapToDouble(Employee::getSalary).average().orElseThrow();
        return employees.values().stream().filter(employee -> averageSalary < employee.getSalary()).collect(Collectors.toList());}
}
