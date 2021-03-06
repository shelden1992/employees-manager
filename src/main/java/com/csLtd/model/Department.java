package com.csLtd.model;

import lombok.*;

import javax.persistence.*;

/**
 * Created by Shelupets Denys on 21.12.2020.
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
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
