package com.learningjava.javaspring3contentcalendar.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

// This configuration annotation is used to allow the class to be scanned
@Configuration
public class MyWebConfig {
    // Spring will automatically scan all beans in the configuration class
    // This allows Spring to automatically access this through the context
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder().build();
    }
}
