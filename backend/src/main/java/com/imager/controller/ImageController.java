package com.imager.controller;


import com.imager.model.Image;
import com.imager.service.ImageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/images")
@CrossOrigin
public class ImageController {

    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        try {
            Image image = imageService.getImageById(id); // Implement this method in your service
            return ResponseEntity.ok()
                    .header("Content-Type", image.getContentType())
                    .body(image.getData());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/upload")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        try {
            Image savedImage = imageService.saveImage(file);
            return ResponseEntity.ok("Image uploaded successfully. ID: " + savedImage.getId());
        } catch (IOException e) {
            return ResponseEntity.badRequest().body("Failed to upload image: " + e.getMessage());
        }
    }
}

