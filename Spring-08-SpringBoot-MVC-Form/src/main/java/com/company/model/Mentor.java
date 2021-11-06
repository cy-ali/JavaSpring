package com.company.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Mentor {
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private boolean graduated;
    private String batch;
    private String company;
}
