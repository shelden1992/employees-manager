package com.csLtd.controller;

import com.csLtd.model.Employee;
import com.csLtd.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Created by Shelupets Denys on 22.12.2020.
 */
@RestController("employee")
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @RequestMapping("/findAll")
    public ResponseEntity<List<Employee>> findAllEmployeesAndSendToView() {
        return employeeService.findAllEmployees();
    }
}
