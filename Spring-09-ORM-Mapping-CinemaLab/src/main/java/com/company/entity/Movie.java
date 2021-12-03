package com.company.entity;

import com.company.enums.MovieState;
import com.company.enums.MovieType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Movie extends BaseEntity {

    private String name;
    private Integer price;
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private MovieType movieType;
    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private MovieState movieState;
    private LocalDate releaseDate;
    private BigDecimal duration;

    @Column(columnDefinition = "text")
    private String summary;

//    @OneToMany(mappedBy = "movie")
//    private List<MovieCinema> movieCinemas;

    @ManyToMany
    @JoinTable(name = "movie_genre_rel", inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genreList = new ArrayList<>();

    public Movie(String name, LocalDate releaseDate, Integer price, MovieType movieType, MovieState movieState, BigDecimal duration) {
        this.name = name;
        this.price = price;
        this.movieType = movieType;
        this.movieState = movieState;
        this.releaseDate = releaseDate;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", movieType=" + movieType +
                ", movieState=" + movieState +
                ", releaseDate=" + releaseDate +
                ", duration=" + duration +
                ", summary='" + summary + '\'' +
                "} ";
    }
}
