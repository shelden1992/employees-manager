package com.csLtd.controller;

import com.csLtd.model.Employee;
import com.csLtd.service.EmployeeService;
import com.csLtd.view.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;


/**
 * Created by Shelupets Denys on 22.12.2020.
 */
@Controller
public class EmployeeController {
    private EmployeeService employeeService;
    private View exelView;

    @Autowired
    public EmployeeController(EmployeeService employeeService, View exelView) {
        this.employeeService = employeeService;
        this.exelView = exelView;
    }

    public void findAllEmployeesAndSendToView() {
        List<Employee> employeeList = employeeService.findAllSortByFullName();
        exelView.outAllEmployees(employeeList);
    }
}
