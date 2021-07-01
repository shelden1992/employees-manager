package com.csLtd.service.employee;

import com.csLtd.model.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {
    ResponseEntity<List<Employee>> findAllEmployees();
}
