package com.learningjava.javaspring3contentcalendar.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learningjava.javaspring3contentcalendar.model.Content;
import com.learningjava.javaspring3contentcalendar.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

// This is ONE way you can programmatically do data manipulation
//@Profile("dev")  // Choose the profile(s), you want to this run / !run
@Component
public class DataLoader implements CommandLineRunner {
    private final ContentRepository repository;
    private final ObjectMapper objectMapper;


    public DataLoader(ContentRepository repository, ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Loading Data...");
        try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/content.json")) {
            repository.saveAll(objectMapper.readValue(inputStream, new TypeReference<List<Content>>() {
            }));
        }
    }
}
