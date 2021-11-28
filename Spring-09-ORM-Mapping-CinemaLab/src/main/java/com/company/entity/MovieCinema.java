package com.company.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class MovieCinema extends BaseEntity {

    private LocalDateTime dateTime;

//    @OneToMany(mappedBy = "movieCinema")
//    private List<Ticket> ticket;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cinema cinema;

    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;

    public MovieCinema(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
