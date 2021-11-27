package com.company.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class UserAccount extends BaseEntity {

    @Column(nullable = false)
    @Email
    private String email;
    @Min(6)
    @NotBlank
    private String password;
    private String username;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private AccountDetails accountDetails;

    @OneToMany(mappedBy = "userAccount")
    private List<Ticket> tickets;

}
