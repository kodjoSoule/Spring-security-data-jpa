package com.springsecurity.springsecurityauth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping("/admin")
    public String admin() {
        return "Welcome , admin";
    }

    @RequestMapping("/user")
    public String user() {
        return "Welcome, user";
    }

    @RequestMapping("/access-denied")
    public String accessDenied() {
        return "access-denied";
    }

    //    test
    @RequestMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Hello, Spring Security");
    }
}
