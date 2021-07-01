package com.csLtd.model;

import lombok.*;

import javax.persistence.*;


/**
 * Created by Shelupets Denys on 21.12.2020.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName;
    private String lastName;
    private String middleName;
    private int age;
    private long salary;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;
}
