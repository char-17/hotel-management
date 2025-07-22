package com.hotel_management.controller;


import com.hotel_management.model.Employee;
import com.hotel_management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee createdEmployee = employeeService.createEmployee(employee);
        return ResponseEntity.ok(createdEmployee);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        return employee != null ? ResponseEntity.ok(employee) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long employeeId, @RequestBody Employee employeeDetails) {
        Employee updatedEmployee = employeeService.updateEmployee(employeeId, employeeDetails);
        return updatedEmployee != null ? ResponseEntity.ok(updatedEmployee) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Employee>> listEmployees() {
        List<Employee> employees = employeeService.listEmployees();
        return ResponseEntity.ok(employees);
    }
}

