package com.employee_management.cicd.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class EmployeeControllerTest {

    private final EmployeeController employeeController = new EmployeeController();

    @Test
    void getAllEmployeesReturnsSixEmployees() {
        var response = employeeController.getAllEmployees();

        assertEquals(200, response.getStatusCode().value());
        assertNotNull(response.getBody());
        assertEquals(6, response.getBody().size());
    }
}
