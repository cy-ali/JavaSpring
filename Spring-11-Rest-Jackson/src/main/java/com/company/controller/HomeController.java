package com.company.controller;


import com.company.entity.Account;
import com.company.entity.User;
import com.company.repository.AccountRepository;
import com.company.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class HomeController {

    UserService userService;
    AccountRepository accountRepository;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/accounts")
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

}
