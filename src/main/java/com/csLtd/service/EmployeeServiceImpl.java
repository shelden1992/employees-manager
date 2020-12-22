package com.csLtd.service;

import com.csLtd.dao.EmployeeRepository;
import com.csLtd.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Shelupets Denys on 22.12.2020.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> findAllSortByFullName() {
        List<Employee> employeeList = findAll();
        employeeList.sort(Comparator.comparing(Employee::getLastName).thenComparing(Employee::getFirstName).thenComparing(Employee::getMiddleName));
        return employeeList;
    }
}
