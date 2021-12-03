package com.company.entity;

import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "departments")
@ToString
@NamedQuery(name = "Department.findOzzyDepartment",
        query = "Select d From Department d Where d.division=?1")
@NamedNativeQuery(name = "Department.countAllDepartments",
        query = "Select * From departments", resultClass = Department.class)
public class Department {

    @Id
    private String department;
    private String division;

}
