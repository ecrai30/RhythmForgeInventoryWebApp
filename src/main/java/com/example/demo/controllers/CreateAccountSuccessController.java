package com.example.demo.controllers;

import com.example.demo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CreateAccountSuccessController {

    @GetMapping ("/createAccountSuccess")
    public String displayCreateAccountSuccess(){
        return"/CreateAccountSuccess";
    }


}
