package com.hotel_management.service;

import com.hotel_management.entity.Employee;
import com.hotel_management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        return employee.orElse(null);
    }

    public Employee updateEmployee(Long employeeId,Employee employeeDetails) {
        Employee employee = getEmployeeById(employeeId);
        if(employee !=null){
            employee.setFirstName(employeeDetails.getFirstName());
            employee.setLastName(employeeDetails.getLastName());
            employee.setRole(employeeDetails.getRole());
            employee.setEmail(employeeDetails.getEmail());
            employee.setPhone(employeeDetails.getPhone());
            employee.setSalary(employeeDetails.getSalary());
            return employeeRepository.save(employee);
        }
        return null;
    }
    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    public List<Employee> listEmployees() {
        return employeeRepository.findAll();
    }
}
