package com.company.entity;

import com.company.enums.State;
import com.company.enums.Type;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Movie extends BaseEntity {

    private String name;
    private Double price;
    @Enumerated(EnumType.STRING)
    private Type type;
    @Enumerated(EnumType.STRING)
    private State state;
    private LocalDate releaseDate;
    private String duration;
    private String summary;

    @OneToMany(mappedBy = "movie")
    private List<MovieCinema> movieCinemas;

    @ManyToMany
    @JoinTable(name = "movie_genre_rel")
    private Set<Genre> genre = new HashSet<>();
}
