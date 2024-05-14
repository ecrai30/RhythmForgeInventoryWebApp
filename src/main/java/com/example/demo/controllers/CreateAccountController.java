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
        return"/CreateAccount";
    }

    @PostMapping(path="/createAccount") // Map ONLY POST Requests
    public String processCreateAccount(@ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        // Check if passwords match
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            model.addAttribute("passwordMismatchError", "Passwords do not match");
            return "/CreateAccount"; // Return to the form with error message
        }

        // Proceed with account creation
        userService.registerUser(user, bindingResult);
        return "redirect:/createAccountSuccess"; // Redirect to success page
    }

   /**
    public @ResponseBody String addNewUser (@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model)  {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User n = new User();
        n.setName(name);
        n.setEmail(email);
        n.setPassword(password);
        n.setConfirmPassword(confirm_password);
        n.setUsername(username);
        userRepository.save(n);
        return "Saved";


        if (bindingResult.hasErrors()) {

            return "/CreateAccount";
        }

        userService.registerUser(user,bindingResult);

        return "redirect:/createAccountSuccess";
    }
    **/

    /**
    // Delete the following code
    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }
    **/

    @GetMapping ("/createAccountFailure")
    public String displayCreateAccountFailure(){
        return"/createAccountFailure";
    }


}
