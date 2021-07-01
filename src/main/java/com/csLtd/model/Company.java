package com.csLtd.model;

import lombok.*;

import javax.persistence.*;

/**
 * Created by Shelupets Denys on 21.12.2020.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String companyName;
    private String address;
    private String country;
}
