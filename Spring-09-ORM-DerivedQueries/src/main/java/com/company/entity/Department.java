package com.company.entity;

import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "departments")
@ToString
public class Department {

    @Id
    private String department;
    private String division;

}
