package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CreateAccountSuccessController {

    @GetMapping ("/createAccountSuccess")
    public String displayCreateAccountSuccess(){
        return"/CreateAccountSuccess";
    }

    @PostMapping("/createAccountSuccess")
    public String processCreateAccountSuccess() {
        // Add logic to handle form submission and account creation
        // Redirect to a success page or perform other actions
        return "redirect:/createAccountSuccess"; // Redirect back to the success page
    }
}
