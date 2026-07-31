package com.employee_management.cicd.controller;

import com.employee_management.cicd.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    List<Employee> employees = Arrays.asList(
            new Employee(1, "Akshay", "IT", 80000.0),
            new Employee(2, "Rahul", "HR", 60000.0),
            new Employee(3, "Priya", "IT",  80000.0),
            new Employee(4, "Sneha", "Finance",  75000.0),
            new Employee(5, "Amit", "HR",  60000.0),
            new Employee(6, "Neha", "Finance",  90000.0)
    );

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return ResponseEntity.of(Optional.ofNullable(employees));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> employee(@PathVariable int id){
        System.out.println("Getting employee");
        Optional<Employee> employee=employees.stream().filter(employee1 -> employee1.getId()==id).findFirst();
        return ResponseEntity.ok(employee.get());
    }

    @GetMapping("/getHR")
    public ResponseEntity<List<Employee>> getAllHr() {
        return ResponseEntity.ok(employees.stream()
                .filter(employee -> employee.getDept().equals("HR"))
                .toList());

    }

}
