package com.company.repository;

import com.company.entity.MovieCinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MovieCinemaRepository extends JpaRepository<MovieCinema, Long> {
    //    Write a derived query to read movie cinema with id?
    List<MovieCinema> findAllById(Long id);

    //    Write a derived query to count all movie cinemas with a specific cinema id?
    Integer countByCinema_id(Long cinema_id);

    //    Write a derived query to count all movie cinemas with a specific movie id?
    Integer countByMovie_id(Long movie_id);

    //    Write a derived query to list all movie cinemas with higher than a specific date?
    List<MovieCinema> findAllByDateTimeAfter(LocalDateTime dateTime);

    //    Write a derived query to list all movie cinemas that contain a specific movie name?
    List<MovieCinema> findAllByMovie_NameContains(String movie_name);

    //    Write a derived query to list all movie cinemas in a specific location?
    List<MovieCinema> findAllByCinema_Location_Name(String cinema_location_name);

    //    Write a JPQL query to list all movie cinemas with higher than a specific date?
    @Query("Select m From MovieCinema m where m.dateTime>?1")
    List<MovieCinema> getMovieCinemasAfterDate(LocalDateTime dateTime);

    //    Write a JPQL query to sort movie cinemas with dates?
    @Query("SELECT m FROM MovieCinema m ORDER BY m.dateTime")
    List<MovieCinema> getMovieCinemaInOrder();
}
