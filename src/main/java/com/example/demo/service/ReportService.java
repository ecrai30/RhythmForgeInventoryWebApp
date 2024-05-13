package com.example.demo.service;

import com.example.demo.domain.Part;
import com.example.demo.repositories.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public
class ReportService {
    private final PartRepository partRepository;

    @Autowired
    public ReportService(PartRepository partRepository) {
        this.partRepository = partRepository;
    }

    public List<Part> getAllParts() {
        return (List<Part>) partRepository.findAll();
    }

    /**
     * Change output for the report
     **/
    public String generatePartsReport() {
        StringBuilder report = new StringBuilder();
        report.append("<!DOCTYPE html>\n");
        report.append("<html>\n");
        report.append("<head>\n");
        report.append("<title>Parts Report</title>\n");
        report.append("</head>\n");
        report.append("<body>\n");
        report.append("<h1>Parts Report</h1>\n");
        report.append("<table border=\"1\">\n");
        report.append("<tr><th>Name</th><th>Price</th><th>Inventory</th></tr>\n");
        List<Part> parts = getAllParts();
        for (Part part : parts) {
            report.append("<tr>\n");
            report.append("<td>").append(part.getName()).append("</td>\n");
            report.append("<td>").append(part.getPrice()).append("</td>\n");
            report.append("<td>").append(part.getInv()).append("</td>\n");
            report.append("</tr>\n");
        }
        report.append("</table>\n");
        report.append("</body>\n");
        report.append("</html>");
        report.append("<a href=\"http://localhost:8080/\">Return\n" + "  to Inventory</a>");
        return report.toString();
    }
}































