package com.indoreesports.esports.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/")
                        .allowedOrigins("http://127.0.0.1:5500/Project_v4.html") // Change to your frontend URL
                        .allowedMethods("GET", "POST", "PUT", "DELETE");
            }
        };
    }
}
