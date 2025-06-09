package com.example.edtech.configs;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;

@Configuration
public class CloundinaryConfig {

    @Bean
    public Cloudinary cloudinary() {
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "didb3lzdt");
        config.put("api_key", "665796626746495");
        config.put("api_secret", "m_WkzdmFg8LmSCTO_22RupKfEOw");
        config.put("secure", "true");
        return new Cloudinary(config);
    }
}
