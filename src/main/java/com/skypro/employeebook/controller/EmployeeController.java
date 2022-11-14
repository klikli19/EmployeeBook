package com.skypro.employeebook.controller;

import com.skypro.employeebook.service.EmployeeService;
import com.skypro.employeebook.model.Employee;
import com.skypro.employeebook.record.EmployeeRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class EmployeeController {


    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/employees")
    public Collection<Employee> getAllEmployees(){
        return this.employeeService.getAllEmployees();
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody EmployeeRequest employeeRequest) throws IllegalAccessException {
        return this.employeeService.addEmployee(employeeRequest);
    }

    @GetMapping("/employees/salary/sum")
    public int getSalarySum(){
        return this.employeeService.getSalarySum();
    }

    @GetMapping("/employees/salary/min")
    public Double getEmployeesWithMinSalary(){
        return this.employeeService.getEmployeeWithMinSalary();
    }

    @GetMapping("/employees/salary/max")
    public Double getEmployeesWithMaxSalary(){
        return this.employeeService.getEmployeeWithMaxSalary();
    }


    @GetMapping("/employees/high-salary")
    public List<Employee> getAllEmployeesWithAverageSalary(){
        return this.employeeService.getAllEmployeesWithAverageSalary();
    }

}
