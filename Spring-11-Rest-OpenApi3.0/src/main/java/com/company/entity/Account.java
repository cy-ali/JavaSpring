package com.company.entity;

import com.company.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "account_details")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Account extends BaseEntity {

    private String name;
    private String address;
    private String country;
    private String city;
    private String state;
    private Integer age;
    private String postalCode;
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private UserRole userRole;

    @OneToOne(mappedBy = "accountDetails")
    @JsonBackReference
    private User userAccount;

    public Account(String name, String address, String country, String city, String state, Integer age, String postalCode, UserRole userRole) {
        this.name = name;
        this.address = address;
        this.country = country;
        this.city = city;
        this.state = state;
        this.age = age;
        this.postalCode = postalCode;
        this.userRole = userRole;
    }
}
