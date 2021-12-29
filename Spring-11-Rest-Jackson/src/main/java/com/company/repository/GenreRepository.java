package com.company.repository;

import com.company.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

    //    Write a derived query to read genre with the name?
    List<Genre> findByName(String name);

    //    Write a JPQL query that returns all genres?
    @Query("select g from Genre g")
    List<Genre> getAllGenres();

    //    Write a native query that returns genres by containing name?
    @Query(value = "SELECT * FROM genre WHERE name ILIKE '%' || ?1 || '%'", nativeQuery = true)
    Genre getGenreWithName(String name);

    @Query(value = "Select count(*) From genre g Join movie_genre_rel mgr On g.id = mgr.genre_id Where g.id = ?1", nativeQuery = true)
    Integer countGenresNativeQuery(Long id);

}
