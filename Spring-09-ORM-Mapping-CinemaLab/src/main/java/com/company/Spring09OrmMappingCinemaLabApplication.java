package com.company;

import com.company.enums.UserRole;
import com.company.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@SpringBootApplication
@AllArgsConstructor
public class Spring09OrmMappingCinemaLabApplication {

    AccountRepository accountRepository;
    CinemaRepository cinemaRepository;
    MovieRepository movieRepository;
    MovieCinemaRepository movieCinemaRepository;
    TicketRepository ticketRepository;
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(Spring09OrmMappingCinemaLabApplication.class, args);
    }

    @PostConstruct
    public void accountTest() {
//        System.out.println("******Account Repository******");
//        System.out.println("getByCountryOrState(United States, Brentwood) = " + accountRepository.getByCountryOrState("United States", "Brentwood"));
//        System.out.println("getByAgeLessThanEqual(46) = " + accountRepository.getByAgeLessThanEqual(46));
//        System.out.println("getByUserRole(UserRole.USER) = " + accountRepository.getByUserRole(UserRole.USER));
//        System.out.println("getByAgeBetween(29,36) = " + accountRepository.getByAgeBetween(29, 36));
//        System.out.println("getByAddressLike(\"2%\") = " + accountRepository.getByAddressLike("2%"));
//        System.out.println("getByOrderByAge() = " + accountRepository.getByOrderByAge());
//        System.out.println("accountRepository.getAllAccounts() = " + accountRepository.getAllAccounts());
//        System.out.println("accountRepository.getAllAdminAccounts() = " + accountRepository.getAllAdminAccounts());
//        System.out.println("accountRepository.searchAccountWith(\"Buffalo\") = " + accountRepository.searchAccountWith("ON"));
    }

    @PostConstruct
    public void cinemaTest() {
//        System.out.println("******Cinema Repository******");
//        System.out.println("getByName(Hall 4 - EMPIRE) = " + cinemaRepository.getByName("Hall 4 - EMPIRE"));
//        System.out.println("getTop3BySponsoredNameOrderByName(Du Pont) = " + cinemaRepository.getTop3BySponsoredNameOrderByName("Du Pont"));
//        System.out.println("getByLocation_Country(United States) = " + cinemaRepository.getByLocation_Country("United States"));
//        System.out.println("getByNameOrSponsoredName(Hall 1 - SQUARE 13, Du Pont) = " + cinemaRepository.getByNameOrSponsoredName("Hall 1 - SQUARE 13", "Du Pont"));
//        System.out.println("cinemaRepository.getCinemasDistinctSponsorName() = " + cinemaRepository.getCinemasDistinctSponsorName());
    }

    @PostConstruct
    public void movieTest() {
//        System.out.println("movieRepository.findTop3ByOrderByPrice() = " + movieRepository.findTop3ByOrderByPriceDesc());
//        System.out.println("movieRepository.getUniqueMovieNames() = " + movieRepository.getUniqueMovieNames());
//        System.out.println("movieRepository.getTopExpensive5Movies() = " + movieRepository.getTopExpensive5Movies());
//        System.out.println("movieRepository.getMovieCountWithCinemaId(1l) = " + movieRepository.getMovieCountWithCinemaId(1l));
//        System.out.println("movieRepository.getMoviesWithLocation(\"AMC Village 7\") = " + movieRepository.getMoviesWithLocation("AMC Village 7"));
    }

    //
    @PostConstruct
    public void movieCinemaTest() {
//        System.out.println("movieCinemaRepository.findAllByCinema_Location_Name(\"AMC Lincoln Square 13\") = " + movieCinemaRepository.findAllByCinema_Location_Name("AMC Lincoln Square 13"));
//        System.out.println("movieCinemaRepository.getMovieCinemasAfterDate(LocalDateTime.now().minusYears(2)) = " + movieCinemaRepository.getMovieCinemasAfterDate(LocalDateTime.now()));
    }

    @PostConstruct
    public void ticketTest() {
//        System.out.println("CountByUserAccount_Username(josieStory) = " + ticketRepository.countByUserAccount_Username("josieStory"));
//        System.out.println("ticketRepository.countUserTickets(bernard) = " + ticketRepository.countUserTickets("bernard"));
//        System.out.println("ticketRepository.countUserTicketsBetweenDates(bernard, LocalDateTime.of(2020, 12, 7, 0, 0, 0), LocalDateTime.now()) = " + ticketRepository.countUserTicketsBetweenDates("bernard", LocalDateTime.of(2020, 12, 7, 0, 0, 0), LocalDateTime.now()));
        System.out.println("ticketRepository.getTicketsWithUserMail(\"bernard@email.com\") = " + ticketRepository.getTicketsWithUserMail("bernard@email.com"));
        System.out.println("ticketRepository.getTicketWithUsernameOrNameOrMovieName(\"Tenet\") = " + ticketRepository.getTicketWithUsernameOrNameOrMovieName("Tenet"));
    }

    @PostConstruct
    public void userTest() {
//        System.out.println("userRepository.getUserWithEmail(\"faith.p@email.com\") = " + userRepository.getUserWithEmail("faith.p@email.com"));
//        System.out.println("userRepository.findAllByAccountDetails_NameContains(\"on\") = " + userRepository.findAllByAccountDetails_NameContains("on"));
        //         BROKEN METHOD
//                System.out.println("userRepository.findAllByAccountNameContaining(\"on\") = " + userRepository.findAllByAccountNameContaining("on"));
//        System.out.println("userRepository.getAllUsersContainCertainName(\"Cannon\") = " + userRepository.getAllUsersContainCertainName("%Canno%"));

    }


}
