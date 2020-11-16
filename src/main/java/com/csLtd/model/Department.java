package com.csLtd.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Shelupets Denys on 21.12.2020.
 */
@Getter
@Setter
@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String departmentName;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;
    private String description;
}
