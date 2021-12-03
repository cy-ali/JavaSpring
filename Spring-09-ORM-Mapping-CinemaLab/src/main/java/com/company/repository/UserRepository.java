package com.company.repository;

import com.company.entity.Account;
import com.company.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //    Write a derived query to read a user with an email?
    User findAllByEmail(String email);

    //    Write a derived query to read a user with a username?
    User findAllByUsername(String username);

    //    Write a derived query to list all users that contain a specific name?
    List<User> findAllByAccountDetails_NameContains(String name);

    //         BROKEN METHOD
    //    Write a derived query to list all users that contain a specific name?
//        List<User> findAllByAccountNameContaining(String name);

    //    Write a derived query to list all users that contain a specific name in the ignored case mode?
    List<User> findAllByAccountDetails_NameContainsIgnoreCase(String name);

    //    Write a derived query to list all users with an age greater than a specified age?
    List<User> findAllByAccountDetails_AgeGreaterThan(Integer age1);

    //    Write a JPQL query that returns a user read by email?
    @Query("SELECT u FROM User u WHERE u.email=?1")
    User getUserWithEmail2(String email);

    //    Write a JPQL query that returns a user read by username?
    @Query("SELECT u FROM User u WHERE u.username=?1")
    User getUserWithUsername(String username);

    //    Write a JPQL query that returns all users?
    @Query("SELECT u FROM User u")
    List<User> getUsers(String username);

    //    Write a native query that returns all users that contain a specific name?
    @Query(value = "SELECT * FROM user_account u JOIN account_details a ON u.account_details_id = a.id WHERE a.name LIKE '%' || ?1 || '%'", nativeQuery = true)
    List<User> getAllUsersContainCertainName(String name);

    //    Write a native query that returns all users?
    @Query(value = "SELECT * FROM user_account", nativeQuery = true)
    List<User> getAllUsers(String username);

    //    Write a native query that returns all users in the range of ages?
    @Query(value = "SELECT * FROM user_account u JOIN account_details ad on u.account_details_id = ad.id WHERE ad.age BETWEEN ?1 AND ?2", nativeQuery = true)
    List<User> getAllUsersBetweenAges(Integer age1, Integer age2);

    //    Write a native query to read a user by email?
    @Query(value = "SELECT * FROM user_account u WHERE email=?1", nativeQuery = true)
    User getUserWithEmail(String email);
}
