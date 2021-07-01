package com.csLtd.dao.employee;

import com.csLtd.model.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Shelupets Denys on 22.12.2020.
 */
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    List<Employee> findAll();
}
