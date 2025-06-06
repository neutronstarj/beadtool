package com.beadify.beadtool.controller;

import com.beadify.beadtool.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TemplateController {

    @Autowired
    private TemplateService templateService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file,
                                         @RequestParam(defaultValue = "29") int width,
                                         @RequestParam(defaultValue = "29") int height) {

        // ✅ Optional: Limit resolution
        if (width > 60 || height > 60) {
            return ResponseEntity.badRequest().body("Max allowed size is 60x60.");
        }

        try {
            List<List<String>> grid = templateService.generateGrid(file, width, height);
            return ResponseEntity.ok(grid);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }
}
