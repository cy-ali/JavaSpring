package com.company.controller;

import com.company.annotation.DefaultExceptionMessage;
import com.company.entity.AuthenticationRequest;
import com.company.entity.ResponseWrapper;
import com.company.entity.User;
import com.company.exception.ServiceException;
import com.company.service.UserService;
import com.company.util.JWTUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Authenticate controller",description = "Authenticate API")
public class AuthenticationController {

    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JWTUtil jwtUtil;


    @PostMapping("/authenticate")
    @DefaultExceptionMessage(defaultMessage = "Bad Credentials")
    @Operation(summary = "Login to application")
    public ResponseEntity<ResponseWrapper> doLogin(@RequestBody AuthenticationRequest authenticationRequest){
        String password = authenticationRequest.getPassword();
        String username = authenticationRequest.getUsername();
        User foundUser = userService.readByUsername(username);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,password);
        authenticationManager.authenticate(authenticationToken);
        String jwtToken = jwtUtil.generateToken(foundUser);
        return ResponseEntity.ok(new ResponseWrapper("Login Successful!",jwtToken));
    }

    @PostMapping("/create-user")
    @Operation(summary = "Create a new user")
    @DefaultExceptionMessage(defaultMessage = "Failed to crate user, please try again")
    public ResponseEntity<ResponseWrapper> createAccount(@RequestBody User user) throws ServiceException {

        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(new ResponseWrapper("User has been created successfully",createdUser));
    }

}
