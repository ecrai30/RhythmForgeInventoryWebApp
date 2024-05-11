package com.example.demo.controllers;

import com.example.demo.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/createAccountSuccessPage")
    public String createUser(@Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {

            return "createAccount";
        }
        try {
            userService.createUser(user, bindingResult);
            return "redirect:/createAccountSuccess"; // Redirect to a success page
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "createAccount"; // Return to the create account page with error message
        }
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
