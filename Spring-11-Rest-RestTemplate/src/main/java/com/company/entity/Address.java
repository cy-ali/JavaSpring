package com.company.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "id",allowSetters = true)
public class Address extends BaseEntity {

    private String street;
    private String suite;
    private String city;
    private String zipcode;
    @OneToOne(mappedBy = "address")
    private User user;


}
