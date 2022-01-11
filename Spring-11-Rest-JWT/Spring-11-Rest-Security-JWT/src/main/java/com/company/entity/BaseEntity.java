package com.company.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean isDeleted;

    @JsonIgnore
    @Column(nullable = false, updatable = false)
    private LocalDate createdDate;

    @JsonIgnore
    @Column(nullable = false)
    private LocalDate updatedDate;

    @JsonIgnore
    @Column(name = "user_created", updatable = false)
    private Integer createUserId;

    @JsonIgnore
    @Column(name = "user_updated", nullable = false)
    private Integer updateUserId;

    @PrePersist
    private void onPersist(){
        this.createdDate=LocalDate.now();
        this.updatedDate=LocalDate.now();
        this.createUserId=1;
        this.updateUserId=1;
    }

    @PreUpdate
    private void onPreUpdate(){
        this.updatedDate= LocalDate.now();
        this.updateUserId=1;
    }
}
