package com.company.repository;

import com.company.entity.Account;
import com.company.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    //    Write a derived query to list all accounts with a specific country or state?
    List<Account> getByCountryOrState(String country, String State);

    //    Write a derived query to list all accounts with age lower than or equal to a specific value?
    List<Account> getByAgeLessThanEqual(Integer age);

    //    Write a derived query to list all accounts with a specific role?
    List<Account> getByUserRole(UserRole userRole);

    //    Write a derived query to list all accounts between a range of ages?
    List<Account> getByAgeBetween(Integer age, Integer age2);

    //    Write a derived query to list all accounts where the beginning of the address contains the keyword?
    List<Account> getByAddressStartsWith(String pattern);

    //    Write a derived query to sort the list of accounts with age?
    List<Account> getByOrderByAge();

    //    Write a JPQL query that returns all accounts?
    @Query("Select a From Account a")
    List<Account> getAllAccounts();

    //    Write a JPQL query to list all admin accounts?
    @Query("Select a From Account a Where a.userRole='ADMIN'")
    List<Account> getAllAdminAccounts();

    //    Write a JPQL query to sort all accounts with age?
    @Query("Select a From Account a Order By a.age")
    List<Account> getAllAccountsInAgeOrder();

    //    Write a native query to read all accounts with an age lower than a specific age?
    @Query(value = "SELECT * FROM account_details where age<?1", nativeQuery = true)
    List<Account> getAccountLowerThan(Integer age);

    //    Write a native query to read all accounts that a specific value can be containable in the name, address, country, state, city?
    @Query(value = "SELECT * FROM account_details WHERE name ILIKE '%' || ?1 || '%' OR address ILIKE '%' || ?1 || '%' OR country ILIKE '%' || ?1 || '%' OR state ILIKE '%' || ?1 || '%' OR city ILIKE '%' || ?1 || '%'", nativeQuery = true)
    List<Account> searchAccountWith(String chars);

    //    Write a native query to sort all accounts by age?
    @Query(value = "SELECT * FROM account_details ORDER BY age", nativeQuery = true)
    List<Account> getAccountsAgeSorted();
}
