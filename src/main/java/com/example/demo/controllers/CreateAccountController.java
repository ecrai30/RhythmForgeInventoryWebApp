package com.example.demo.controllers;

import com.example.demo.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class CreateAccountController {

    @Autowired
    private UserService userService;

    private UserRepository userRepository;

    @GetMapping("/createAccount")
    public String displayCreateAccount(Model model){
        model.addAttribute("user", new User());
        return"CreateAccount";
    }

    @PostMapping(path="/createAccount") // Map ONLY POST Requests
    public String processCreateAccount(@ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        // Check if passwords match
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            model.addAttribute("passwordMismatchError", "Passwords do not match");
            return "CreateAccount"; // Return to the form with error message
        }

        // Check if username and email already exist
        if (userService.existsByUsername(user.getUsername())) {
            bindingResult.rejectValue("username", "error.user", "Username already exists");

        }

        if (userService.existsByEmail(user.getEmail())) {
            bindingResult.rejectValue("email", "error.user", "Email already exists");

        }
        if(bindingResult.hasErrors()){
            return "CreateAccount";
        }

        // Proceed with account creation
        userService.registerUser(user, bindingResult);
        return "redirect:createAccountSuccess"; // Redirect to success page
    }


    @GetMapping ("/createAccountFailure")
    public String displayCreateAccountFailure(){
        return"createAccountFailure";
    }


}
