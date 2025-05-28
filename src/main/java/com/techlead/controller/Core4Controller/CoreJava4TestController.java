package com.techlead.controller.Core4Controller;

import com.techlead.service.core4.Core4TestService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


@RestController
@RequestMapping("/api/core-java-4-test")
@Tag(name = "Core Java 4 test", description = "APIs for Core Java 4 test")
@RequiredArgsConstructor
public class CoreJava4TestController {

    private static final String UPLOAD_DIR = System.getProperty("user.dir") + "/uploads";

    private final Core4TestService core4TestService;

    @PostMapping(value = "/upload-and-read-timesheet", consumes = "multipart/form-data")
    public ResponseEntity<?> uploadAndReadTimesheet(@Parameter(description = "File to upload", required = true) @RequestParam("file") MultipartFile multipartFile) throws IOException {
        try {
            if (multipartFile.isEmpty() || (!multipartFile.getOriginalFilename().endsWith(".xlsx") && !multipartFile.getOriginalFilename().endsWith(".xls"))) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid file format. Please upload an Excel file.");
            }

            File uploadDir = new File(UPLOAD_DIR);

            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }

            String filePath = UPLOAD_DIR + multipartFile.getOriginalFilename();

            multipartFile.transferTo(new File(filePath));
            return ResponseEntity.ok(core4TestService.readTimeSheet(filePath));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading file: " + e.getMessage());

        }
    }
}
