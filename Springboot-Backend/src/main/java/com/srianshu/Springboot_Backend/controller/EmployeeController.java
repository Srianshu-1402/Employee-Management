package com.srianshu.Springboot_Backend.controller;

import com.srianshu.Springboot_Backend.model.Employee;
import com.srianshu.Springboot_Backend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")

public class EmployeeController {

        @Autowired
        private EmployeeService employeeService;

        // Get all employees
        @GetMapping
        public List<Employee> getAllEmployees() {
            return employeeService.getAllEmployees();
        }

        // Get employee by ID
        @GetMapping("/{id}")
        public Employee getEmployeeById(@PathVariable Long id) {
            return employeeService.getEmployeeById(id);
        }

        // Add a new employee
        @PostMapping
        public Employee saveEmployee(@RequestBody Employee employee) {
            return employeeService.saveEmployee(employee);
        }

        // Delete employee by ID
        @DeleteMapping("/{id}")
        public String deleteEmployee(@PathVariable Long id) {
            employeeService.deleteEmployee(id);
            return "Employee deleted successfully!";
        }
}
