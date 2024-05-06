package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginPageController {

    @GetMapping("/loginPage")
    public String showLoginPage() {
        return "LoginPage"; // Assuming you have an index.html file in src/main/resources/templates directory
    }

    @PostMapping("/loginPage")
    public String processLogin(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               RedirectAttributes redirectAttributes) {
        // Perform authentication logic here
        if (!username.isBlank() && !password.isBlank()) {
            // Redirect to main screen if login successful
            return "redirect:/loginSuccess";
        } else {
            // Redirect back to login page with error message if login failed
            redirectAttributes.addFlashAttribute("error", "Invalid username or password.");
            return "redirect:/loginPage";
        }
    }

    @GetMapping("/loginSuccess")
    public String displayLoginSuccess(){
        return"/LoginSuccess";
    }
    @GetMapping("/createAccount")
    public String displayCreateAccount(){
        return"/CreateAccount";
    }


}
