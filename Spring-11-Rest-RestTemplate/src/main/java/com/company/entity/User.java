package com.company.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User extends BaseEntity {

    private String name;
    private String username;
    private String email;
    @JsonIgnore
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    private String phone;
    private String website;
    @ManyToOne(cascade=CascadeType.ALL)
    private Company company;


}
