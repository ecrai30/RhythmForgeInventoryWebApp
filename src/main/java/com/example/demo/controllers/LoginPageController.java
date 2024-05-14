package com.example.demo.controllers;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginPageController {

    private final UserService userService;

    @Autowired
    public LoginPageController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/loginPage")
    public String showLoginPage() {
        return "LoginPage"; // Assuming you have an index.html file in src/main/resources/templates directory
    }

    @PostMapping("/loginPage")
    public String processLogin(@RequestParam("username") String username,
                               @RequestParam("password") String password, RedirectAttributes redirectAttributes) {
        // Perform authentication logic here
        if (userService.authenticate(username, password)) {
            // Redirect to main screen if login successful
            return "redirect:/loginSuccess";
        } else {
            // Redirect back to login page with error message if login failed
            //model.addAttribute("error", "Invalid username or password. Please try again.");
            redirectAttributes.addFlashAttribute("error", "Invalid username or password. Please try again.");
            return "redirect:/loginPage";
        }
    }

    @GetMapping("/loginSuccess")
    public String displayLoginSuccess(){
        return"/LoginSuccess";
    }

}
