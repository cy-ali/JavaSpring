package com.company.entity;

import com.company.enums.Gender;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Entity
@NoArgsConstructor
@Table(name = "student_list")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(name = "studentFirstName")
    private String firstName;
    private String lastName;
    private String email;

    @Transient
    private String city;

    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Temporal(TemporalType.TIME)
    private Date birthTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDateTie;

    @Column(columnDefinition = "DATE")
    LocalDate localDate;

    @Column(columnDefinition = "TIME")
    LocalTime localTime;

    @Column(columnDefinition = "TIMESTAMP")
    LocalDateTime localDateTime;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    public Student(String firstName, String lastName, String email, String city, Date birthDate, Date birthTime, Date birthDateTie, LocalDate localDate, LocalTime localTime, LocalDateTime localDateTime, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.city = city;
        this.birthDate = birthDate;
        this.birthTime = birthTime;
        this.birthDateTie = birthDateTie;
        this.localDate = localDate;
        this.localTime = localTime;
        this.localDateTime = localDateTime;
        this.gender = gender;
    }
}
