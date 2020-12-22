package com.csLtd.dao;

import com.csLtd.model.Company;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Shelupets Denys on 22.12.2020.
 */
public interface CompanyRepository extends CrudRepository<Company, Integer> {
}
