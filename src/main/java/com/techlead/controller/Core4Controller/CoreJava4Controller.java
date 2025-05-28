package com.techlead.controller.Core4Controller;


import com.techlead.service.core4.CoreJava4Service;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequestMapping("/api/core-java-4")
@Tag(name = "Core Java 4", description = "APIs for Core Java 4")
public class CoreJava4Controller {
    private static final String UPLOAD_DIR = System.getProperty("user.dir") + "/uploads/";

    @Autowired
    private CoreJava4Service coreJava4Service;

    @Operation(summary = "Upload and read timesheet", description = "Input file BangCong, returns the list of Employee Info.")
    @PostMapping(value ="/upload-and-read-timesheet", consumes = "multipart/form-data")
    public ResponseEntity<?> uploadAndReadTimesheet(@Parameter(description = "File to upload", required = true) @RequestParam("file") MultipartFile file) {
        try {
            if (file.isEmpty() || (!file.getOriginalFilename().endsWith(".xlsx") && !file.getOriginalFilename().endsWith(".xls"))) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid file format. Please upload an Excel file.");
            }

            File uploadDir = new File(UPLOAD_DIR);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }

            String filePath = UPLOAD_DIR + file.getOriginalFilename();

            file.transferTo(new File(filePath));

            return ResponseEntity.ok(coreJava4Service.readTimesheet(filePath));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading file: " + e.getMessage());
        }
    }
}
