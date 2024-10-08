package com.jwtauthentican.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwtauthentican.entity.User;
import com.jwtauthentican.service.UserService;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        System.out.println("Getting users.......");
        return userService.getUsers();
    }

    @GetMapping("/current-user")
    public String getLoggedInUser(@AuthenticationPrincipal UserDetails user) {
        return user.getUsername();
    }

}
