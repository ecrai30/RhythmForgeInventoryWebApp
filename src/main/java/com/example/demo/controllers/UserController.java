package com.example.demo.controllers;

import com.example.demo.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/createAccountSuccessPage")
    public String createUser(User user) {
        userService.createUser(user);
        return "redirect:/createAccountSuccess"; // Redirect to a success page
    }
}
