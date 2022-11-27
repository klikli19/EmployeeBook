package com.skypro.employeebook.controller;

import com.skypro.employeebook.model.Employee;
import com.skypro.employeebook.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}/salary/sum")
    public int getSumOfSalariesByDepartment(@PathVariable int id){
        return departmentService.getSumOfSalariesByDepartment(id);
    }

    @GetMapping("/{id}/salary/max")
    public double getMaxSalaryByDepartment(@PathVariable int id){
        return departmentService.getMaxSalaryByDepartment(id);
    }

    @GetMapping("/{id}/salary/min")
    public double getMinSalaryByDepartment(@PathVariable int id){
        return departmentService.getMinSalaryByDepartment(id);
    }

    @GetMapping("/{id}/employee")
    public List<Employee> getEmployeeByDepartment(@PathVariable int id){
        return departmentService.getEmployeeByDepartment(id);
    }
    @GetMapping("/employee")
    public Map<Integer, List<Employee>> getGroupedEmployeeByDepartment(){
        return departmentService.getGroupedEmployeeByDepartment();
    }



}
