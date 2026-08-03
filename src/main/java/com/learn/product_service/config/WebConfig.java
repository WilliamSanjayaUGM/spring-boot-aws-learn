package com.learn.product_service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
        .allowedOrigins("https://ds7m4kk5x2al2.cloudfront.net")
        .allowedMethods("*")
        .allowedHeaders("*")
        .allowCredentials(true);
	}
}
