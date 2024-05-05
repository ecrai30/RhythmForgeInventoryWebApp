package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LandingPageController {

    @GetMapping("/LandingPage")
    public String showLandingPage() {
        return "LandingPage"; // Assuming you have an index.html file in src/main/resources/templates directory
    }


}
