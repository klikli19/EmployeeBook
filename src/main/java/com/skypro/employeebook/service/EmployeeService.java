package com.skypro.employeebook.service;

import com.skypro.employeebook.Exception.EmployeeEmptyValueException;
import com.skypro.employeebook.model.Employee;
import com.skypro.employeebook.record.EmployeeRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final Map<Integer, Employee> employees = new HashMap<>();

    public Collection<Employee> getAllEmployees() {
        return this.employees.values();
    }

    public Employee addEmployee(EmployeeRequest employeeRequest) {
        if (!StringUtils.isAlpha(employeeRequest.getFirstName()) || !StringUtils.isAlpha(employeeRequest.getLastName())) {
            throw new EmployeeEmptyValueException();
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

    public Double getMinSalary() {
        return employees.values().stream().mapToDouble(Employee::getSalary).min().orElse(0);
    }

    public Double getMaxSalary() {
        return employees.values().stream().mapToDouble(Employee::getSalary).max().orElse(0);
    }

    public List<Employee> getAllEmployeesWithAverageSalary(){
        var averageSalary = employees.values().stream().mapToDouble(Employee::getSalary).average().orElseThrow(EmployeeEmptyValueException::new);
        return employees.values().stream().filter(employee -> averageSalary < employee.getSalary()).collect(Collectors.toList());}
}
