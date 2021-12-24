package com.company.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"}, ignoreUnknown = true)
public class Location extends BaseEntity {

    @NotBlank
    private String name;
    private String latitude;
    private String longitude;
    private String country;
    private String city;
    private String state;
    private String postalCode;
    private String address;

//    @OneToMany(mappedBy = "location")
//    private List<Cinema> cinemas;


    public Location(String name, String latitude, String longitude, String postalCode, String country, String city, String state, String address) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.country = country;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.address = address;
    }
}
