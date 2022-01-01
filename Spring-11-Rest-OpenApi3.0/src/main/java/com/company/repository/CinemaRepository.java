package com.company.repository;

import com.company.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {

    //    Write a derived query to get cinema with a specific name?
    Optional<Cinema> getByName(String name);

    //    Write a derived query to read sorted the top 3 cinemas that contain a specific sponsored name?
    List<Cinema> getTop3BySponsoredNameContainsOrderByName(String sponsorName);

    //    Write a derived query to list all cinemas in a specific country?
    List<Cinema> getByLocation_Country(String country);

    //    Write a derived query to list all cinemas with a specific name or sponsored name?
    List<Cinema> getByNameOrSponsoredName(String name, String sponsoredName);

    //    Write a JPQL query to read the cinema name with a specific id?
    @Query("Select c.name From Cinema c where c.id=?1")
    String getCinemaNameWithId(Long id);

    //    Write a native query to read all cinemas by location country?
    @Query(value = "SELECT * FROM cinema JOIN location l on cinema.location_id = l.id WHERE l.country=?1", nativeQuery = true)
    List<Cinema> getCinemaWithCountry(String country);

    //    Write a native query to read all cinemas by name or sponsored name?
    @Query(value = "SELECT * FROM cinema WHERE name=?1 OR sponsored_name=?1", nativeQuery = true)
    List<Cinema> getCinemaWithNameOrSponsoredName(String name);

    //    Write a native query to sort all cinemas by name?
    @Query(value = "SELECT * FROM cinema ORDER BY name", nativeQuery = true)
    List<Cinema> getCinemasSorted();

    //    Write a native query to distinct all cinemas by sponsored name?
    @Query(value = "SELECT DISTINCT ON (sponsored_name) * FROM cinema", nativeQuery = true)
    List<Cinema> getCinemasDistinctSponsorName();
}
