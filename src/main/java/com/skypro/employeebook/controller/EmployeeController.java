package com.skypro.employeebook.controller;

import com.skypro.employeebook.service.EmployeeService;
import com.skypro.employeebook.model.Employee;
import com.skypro.employeebook.record.EmployeeRequest;

import org.springframework.web.bind.annotation.*;

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
    public Double getMinSalary(){
        return this.employeeService.getMinSalary();
    }

    @GetMapping("/employees/salary/max")
    public Double getMaxSalary(){
        return this.employeeService.getMaxSalary();
    }


    @GetMapping("/employees/high-salary")
    public List<Employee> getAllEmployeesWithAverageSalary(){
        return this.employeeService.getAllEmployeesWithAverageSalary();
    }

}
