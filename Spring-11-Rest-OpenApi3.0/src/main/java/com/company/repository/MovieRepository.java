package com.company.repository;

import com.company.entity.Movie;
import com.company.enums.MovieState;
import com.company.enums.MovieType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    //    Write a derived query to find the top 3 expensive movies?
    List<Movie> findTop3ByOrderByPriceDesc();

    //    Write a derived query to read a movie with a name?
    Movie findByName(String name);

    //    Write a derived query to list all movies between a range of prices?
    List<Movie> findAllByPriceBetween(Integer price, Integer price2);

    //    Write a derived query to list all movies with higher than a specific release date?
    List<Movie> findAllByReleaseDateAfter(LocalDate date);

    //    Write a derived query to list all movies with a specific state and type?
    List<Movie> findAllByMovieStateAndMovieType(MovieState movieState, MovieType movieType);

    //    Write a derived query to list all movies where duration exists in the specific list of durations?
    List<Movie> findByDurationIn(List<BigDecimal> duration);

    //    Write a JPQL query to list all movies between a range of prices?
    @Query("SELECT m FROM Movie m WHERE m.price BETWEEN ?1 AND ?2")
    List<Movie> getMoviesBetweenPrices(Integer price1, Integer price2);

    //    Write a JPQL query that returns distinct movie names?
    @Query("SELECT DISTINCT (m.name) FROM Movie m")
    List<String> getUniqueMovieNames();

    //    Write a native query that returns a movie by name?
    @Query(value = "SELECT * FROM movie WHERE name=?1", nativeQuery = true)
    Movie getMovieWithName(String name);

    //    Write a native query that returns the list of movies in a specific range of prices?
    @Query(value = "SELECT * FROM movie WHERE price BETWEEN ?1 AND ?2", nativeQuery = true)
    List<Movie> getMoviesBetweenPrices2(Integer price1, Integer price2);

    //    Write a native query to return all movies where duration exists in the range of durations?
    @Query(value = "SELECT * FROM movie WHERE price BETWEEN ?1 AND ?2", nativeQuery = true)
    List<Movie> getMoviesBetweenDurations(BigDecimal duration1, BigDecimal duration2);

    //    Write a native query to list the top 5 most expensive movies?
    @Query(value = "SELECT * FROM movie ORDER BY price DESC LIMIT 5", nativeQuery = true)
    List<Movie> getTopExpensive5Movies();

    //    Write a native query to count all movie cinemas by cinema id?
    @Query(value = "SELECT count(*) FROM movie m JOIN movie_cinema mc on m.id = mc.movie_id WHERE cinema_id=?1", nativeQuery = true)
    Integer getMovieCountWithCinemaId(Long cinema_id);

    //    Write a native query that returns all movie cinemas by location name?
    @Query(value = "SELECT * FROM movie m JOIN movie_cinema mc on m.id = mc.movie_id JOIN cinema c on mc.cinema_id = c.id JOIN location l on c.location_id = l.id WHERE L.name=?1", nativeQuery = true)
    List<Movie> getMoviesWithLocation(String location);

}
