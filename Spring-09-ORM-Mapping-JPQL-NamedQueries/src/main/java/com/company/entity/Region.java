package com.company.entity;

import javax.persistence.*;

@Entity
@Table(name = "regions")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String region;
    private String country;

    @Override
    public String toString() {
        return "Region{" +
                "region='" + region + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
