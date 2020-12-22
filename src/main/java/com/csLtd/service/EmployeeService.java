package com.csLtd.service;

import com.csLtd.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    List<Employee> findAllSortByFullName();
}
