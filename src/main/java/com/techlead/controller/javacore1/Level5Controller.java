package com.techlead.controller.javacore1;

import com.techlead.dto.request.TemplateRequest;
import com.techlead.service.core1.Level5Service;
import com.techlead.service.core1.helper.Item;
import com.techlead.service.core1.helper.TemplateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.core.io.Resource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/core-java-1/level-5")
@Tag(name = "Core Java 1 - Level 5", description = "APIs for Core Java 1 - Level 5")
@PreAuthorize("hasAnyRole('ADMIN', 'USER')") // Only allow ADMIN and USER roles to access

public class Level5Controller {

    private final Level5Service level5Service;
    private final TemplateService templateService;

    public Level5Controller(Level5Service level5Service, TemplateService templateService) {
        this.level5Service = level5Service;
        this.templateService = templateService;
    }

    @Operation(summary = "Write the function to reverse string array")
    @GetMapping("/reverse-array")
    public ResponseEntity<?> reverseArray(@RequestParam String[] arr) {
        return ResponseEntity.ok(level5Service.reverseArray(arr));
    }

    @Operation(summary = "Chunk the array by the the target size")
    @GetMapping("/chunk-array")
    public ResponseEntity<?> chunkArray(@RequestParam String[] arr, @RequestParam int size) {
        return ResponseEntity.ok(level5Service.chunk(arr, size));
    }

    @Operation(summary = "Remove duplicated elements in the array")
    @GetMapping("/remove-duplicated-ele")
    public ResponseEntity<?> removeDuplicatedElement(@RequestParam int[] arr, @RequestParam int n) {
        return ResponseEntity.ok(level5Service.removeDups(arr, n));
    }

    @Operation(summary = "find the unique array object")
    @GetMapping("/unique-array")
    public ResponseEntity<?> uniqueArrayObject(@RequestParam List<Map<String, Integer>> arr) {
        return ResponseEntity.ok(level5Service.uniqueArrayObject(arr));
    }

    @Operation(summary = "OBJECT mới chứa dữ liệu được group theo trường chỉ định.")
    @GetMapping("/group-by")
    public ResponseEntity<?> groupBy(@RequestParam List<Map<String, Object>> collection, @RequestParam String field) {
        return ResponseEntity.ok(level5Service.groupBy(collection, field));
    }

    @Operation(summary = "Trim all spaces of the strings")
    @GetMapping("/trim-all")
    public ResponseEntity<?> trimSpace(@RequestParam String s1) {
        return ResponseEntity.ok(level5Service.trimSpace(s1));
    }

    @Operation(summary = "")
    @GetMapping("/map-keys")
    public ResponseEntity<?> mapKeys(@RequestParam String[] keys, @RequestParam List<Map<String, Integer>> collections) {
        return ResponseEntity.ok(level5Service.mapKeys(keys, collections));
    }

    @Operation(summary = "")
    @GetMapping("/switch-order")
    public ResponseEntity<?> switchOrder(@RequestParam List<Item> arr, @RequestParam int id, @RequestParam int newOrder) {
        return ResponseEntity.ok(level5Service.switchOrder(arr, id, newOrder));
    }

    @Operation(summary = "")
    @GetMapping("/sum-all")
    public ResponseEntity<?> mapKeys(@RequestParam List<Map<String, Object>> arr) {
        return ResponseEntity.ok(level5Service.sumAll(arr));
    }

    @Operation(summary = "")
    @PostMapping("/render")
    public ResponseEntity<?> renderTemplate(@RequestBody TemplateRequest request) throws Exception {
        try {
            // Tạo tên file đầu ra với phần mở rộng từ request
            String outputExtension = request.getOutputExtension().startsWith(".")
                    ? request.getOutputExtension()
                    : "." + request.getOutputExtension();
            String outputPath = "output_" + System.currentTimeMillis() + outputExtension;
            File outputFile = templateService.renderTemplateAndSave(
                    request.getTemplateFilePath(),
                    request.getParams(),
                    outputPath
            );

            // Chuẩn bị file để tải xuống
            Resource resource = new FileSystemResource(outputFile);
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + outputFile.getName());
            headers.add(HttpHeaders.CACHE_CONTROL, "no-cache, no-store, must-revalidate");
            headers.add(HttpHeaders.PRAGMA, "no-cache");
            headers.add(HttpHeaders.EXPIRES, "0");

            return ResponseEntity.ok()
                    .headers(headers)
                    .contentLength(outputFile.length())
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(resource);
        } catch (IOException e) {
            throw new Exception("Failed to process template: " + e.getMessage(), e);
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleTemplateProcessingException(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Error: " + e.getMessage());
    }


}
