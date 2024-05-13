package com.example.demo.controllers;

import com.example.demo.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report")
public class ReportController {
    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/parts")
    public String generatePartsReport() {
        return reportService.generatePartsReport();
    }
}/**
 * package com.example.demo.controllers;import com.example.demo.service.ReportService;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Controller;import org.springframework.ui.Model;import org.springframework.web.bind.annotation.GetMapping;import org.springframework.web.bind.annotation.RequestMapping;@Controller@RequestMapping("/report")public class ReportController {    private final ReportService reportService;    @Autowired    public ReportController(ReportService reportService) {        this.reportService = reportService;    }    @GetMapping("/parts")    public String generatePartsReport(Model model) {        String reportData = reportService.generatePartsReport();        model.addAttribute("reportData", reportData);        return "PartsReport"; // Assuming the Thymeleaf template name is "report.html"    }}
 **/