package com.rnrsolutions.greenbless.forecast.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                // .allowedOrigins("http://localhost:3000") // Replace with your frontend's domain
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE"); // If your requests include credentials (e.g., cookies)
    }
}
