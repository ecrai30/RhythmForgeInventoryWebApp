package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class CreateAccountController {

    @GetMapping("/createAccount")
    public String displayCreateAccount(){
        return"/CreateAccount";
    }
}
