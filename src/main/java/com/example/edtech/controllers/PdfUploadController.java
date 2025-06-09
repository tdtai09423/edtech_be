package com.example.edtech.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.example.edtech.services.CloudinaryService;

@RestController
@RequestMapping("/api/pdf")
public class PdfUploadController {

    private final CloudinaryService cloudinaryService;

    public PdfUploadController(CloudinaryService cloudinaryService) {
        this.cloudinaryService = cloudinaryService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadPdf(@RequestParam("file") MultipartFile file) {
        try {
            String contentType = file.getContentType();
            if (!"application/pdf".equals(contentType) &&
                    !"application/vnd.openxmlformats-officedocument.wordprocessingml.document".equals(contentType)) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Chỉ chấp nhận file PDF hoặc DOCX!");
            }

            String url = cloudinaryService.uploadPdf(file);
            return ResponseEntity.ok(url);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Lỗi khi upload: " + e.getMessage());
        }
    }
}
