package com.company.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "id",allowSetters = true)
public class Company extends BaseEntity{
    private String name;
    private String catchPhrase;
    private String bs;
}
