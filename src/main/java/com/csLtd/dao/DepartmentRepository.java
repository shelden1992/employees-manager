package com.csLtd.dao;

import com.csLtd.model.Department;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Shelupets Denys on 22.12.2020.
 */
public interface DepartmentRepository extends CrudRepository<Department, Integer> {
}
