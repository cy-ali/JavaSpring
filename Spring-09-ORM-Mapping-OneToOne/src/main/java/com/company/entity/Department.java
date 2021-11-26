package com.company.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@NoArgsConstructor
@Entity
public class Department extends BaseEntity {


    private String department;
    private String division;

    @OneToOne(mappedBy = "department")
    private Employee employee;

    public Department(String department, String division) {
        this.department = department;
        this.division = division;
    }
}
