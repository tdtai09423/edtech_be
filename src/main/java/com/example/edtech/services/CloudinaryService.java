package com.example.edtech.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryService {

    @Autowired
    private Cloudinary cloudinary;

    public CloudinaryService() {
        this.cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "didb3lzdt",
                "api_key", "665796626746495",
                "api_secret", "m_WkzdmFg8LmSCTO_22RupKfEOw"));
    }

    public String uploadPdf(MultipartFile file) throws IOException {
        Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap(
                "resource_type", "raw", // ✅ BẮT BUỘC
                "public_id", "pdf_" + System.currentTimeMillis()));

        return uploadResult.get("secure_url").toString();
    }

    public String uploadImage(MultipartFile file) throws IOException {
        Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
        return uploadResult.get("secure_url").toString();
    }

    public String uploadAudio(MultipartFile file) throws IOException {
        if (file.isEmpty() || !file.getOriginalFilename().toLowerCase().endsWith(".mp3")) {
            throw new IllegalArgumentException("File không hợp lệ, phải là file .mp3");
        }

        Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap(
                "resource_type", "video"));

        return uploadResult.get("secure_url").toString();
    }
}
