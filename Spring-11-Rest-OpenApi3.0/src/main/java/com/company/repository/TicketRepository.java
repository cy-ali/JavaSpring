package com.company.repository;

import com.company.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    //    Write a derived query to count how many tickets a user bought?
    Integer countByUserAccount_Username(String username);

    //    Write a derived query to list all tickets by a specific email?
    List<Ticket> findAllByUserAccount_Email(String email);

    //    Write a derived query to count how many tickets are sold for a specific movie?
    Integer countByMovieCinema_Movie_Name(String movieName);

    //    Write a derived query to list all tickets between a range of dates?
    List<Ticket> findAllByDateTimeBetween(LocalDateTime dateTime, LocalDateTime dateTime2);

    //    Write a JPQL query that returns all tickets are bought from a specific user?
    @Query("SELECT t FROM Ticket t WHERE t.userAccount.username=?1")
    List<Ticket> getTicketsOfUser(String username);

    //    Write a JPQL query that returns all tickets between a range of dates?
    @Query("SELECT t FROM Ticket t where t.dateTime BETWEEN ?1 AND ?2")
    List<Ticket> getTicketsBetweenDates(LocalDateTime datetime1, LocalDateTime dateTime2);

    //    Write a native query to count the number of tickets a user bought?
    @Query(value = "SELECT count (*) FROM ticket t JOIN user_account u ON t.user_account_id=u.id WHERE u.username=?1", nativeQuery = true)
    Integer countUserTickets(String username);

    //    Write a native query to count the number of tickets a user bought in a specific range of dates?
    @Query(value = "SELECT count (*) FROM ticket t JOIN user_account u ON t.user_account_id=u.id WHERE u.username=?1 AND (t.date_time BETWEEN ?2 AND ?3)", nativeQuery = true)
    Integer countUserTicketsBetweenDates(String username, LocalDateTime date1, LocalDateTime date2);

    //    Write a native query to distinct all tickets by movie name?
    @Query(value = "SELECT DISTINCT ON (m.name)* FROM ticket t JOIN movie_cinema mc ON t.movie_cinema_id = mc.id JOIN movie m ON mc.movie_id = m.id WHERE m.name=?1", nativeQuery = true)
    List<Ticket> getAllTicketsWithMovieName(String movieName);

    //    Write a native query to find all tickets by user email?
    @Query(value = "SELECT * FROM ticket t JOIN user_account u ON t.user_account_id = u.id WHERE u.email=?1", nativeQuery = true)
    List<Ticket> getTicketsWithUserMail(String email);

    //    Write a native query that returns all tickets?
    @Query(value = "SELECT * FROM ticket", nativeQuery = true)
    List<Ticket> getAllTickets();

    //    Write a native query to list all tickets where a specific value should be containable in the username or name or movie name?
    @Query(value = "SELECT * FROM ticket t JOIN user_account ua ON t.user_account_id = ua.id JOIN movie_cinema mc ON t.movie_cinema_id = mc.id JOIN account_details ad ON ua.account_details_id = ad.id JOIN movie m ON mc.movie_id = m.id WHERE (ua.username ILIKE '%' || ?1 + '%' OR ad.name ILIKE '%' || ?1 + '%' OR m.name ILIKE '%' || ?1 + '%' )", nativeQuery = true)
    List<Ticket> getTicketWithUsernameOrNameOrMovieName(String name);

}
