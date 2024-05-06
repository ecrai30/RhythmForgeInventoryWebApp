package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class CreateAccountController {

    @GetMapping("/createAccount")
    public String displayCreateAccount(){
        return"/CreateAccount";
    }
/**
    @GetMapping("/createAccountSuccess")
    public String displayCreateAccountSuccess(){
        return"/CreateAccountSuccess";
    }
 **/
}
