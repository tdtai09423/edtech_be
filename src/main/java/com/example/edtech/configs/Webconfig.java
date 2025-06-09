package com.example.edtech.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class Webconfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")  // Áp dụng cho tất cả endpoint
                        .allowedOrigins("*") // Cho phép tất cả domain, bạn có thể thay * bằng danh sách cụ thể
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Cho phép các method
                        .allowedHeaders("*"); // Cho phép tất cả header
            }
        };
    }
}
