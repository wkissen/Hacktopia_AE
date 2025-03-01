package be.ae.hackatonae.controller;

import be.ae.hackatonae.service.CSVImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/csvimport")
public class CSVImportController {
    private CSVImportService csvImportService;

    @Autowired
    public CSVImportController(CSVImportService csvImportService) {
        this.csvImportService = csvImportService;
    }

    @PostMapping
    public String importCSV() {
        try {
            // Pass the file to the service for processing
            csvImportService.importCSV();
            return "File uploaded and processed successfully!";
        } catch (Exception e) {
            return "Failed to upload and process the file: " + e.getMessage();
        }
    }
}
