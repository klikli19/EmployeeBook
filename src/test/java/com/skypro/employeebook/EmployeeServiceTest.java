package com.skypro.employeebook;


import com.skypro.employeebook.Exception.EmployeeEmptyValueException;
import com.skypro.employeebook.model.Employee;
import com.skypro.employeebook.record.EmployeeRequest;
import com.skypro.employeebook.service.EmployeeService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeServiceTest {
    private EmployeeService employeeService;
    private List<Employee> employees;


    @BeforeEach
    public void setUp() {
        this.employeeService = new EmployeeService();
        Stream.of(
                new EmployeeRequest("Misha", "Mishin", 1, 25000),
                new EmployeeRequest("Petya", "Petrov", 2, 15000),
                new EmployeeRequest("Vasya", "Smirnov", 3, 35000)
        ).forEach(employeeService::addEmployee);

    }

    @Test
    public void addEmployee() {
        EmployeeRequest request = new EmployeeRequest("Test", "Test", 1, 10000);
        Employee result = employeeService.addEmployee(request);
        assertEquals(request.getFirstName(), result.getFirstName());
        assertEquals(request.getLastName(), result.getLastName());
        assertEquals(request.getDepartment(), result.getDepartment());
        assertEquals(request.getSalary(), result.getSalary());
        Assertions.assertThat(employeeService.getAllEmployees()).contains(result);
    }

    @Test
    public void getSalarySum() {
         assertEquals(75000, employeeService.getSalarySum());
    }

    @Test
    public void getMinSalary() {
        assertEquals(15000, employeeService.getMinSalary());
    }

    @Test
    public void getMaxSalary() {
        assertEquals(35000, employeeService.getMaxSalary());
    }

    @Test
    public void getAllEmployeesWithAverageSalary() {
        double averageSal = employees.stream().mapToDouble(Employee::getSalary).average().orElseThrow(EmployeeEmptyValueException::new);
        List<Employee> list = employeeService.getAllEmployees().stream().filter(e -> e.getSalary() > averageSal).collect(Collectors.toList());
        assertEquals(employeeService.getAllEmployeesWithAverageSalary(), list);
}
}
