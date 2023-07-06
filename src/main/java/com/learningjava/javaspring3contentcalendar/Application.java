package com.learningjava.javaspring3contentcalendar;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.learningjava.javaspring3contentcalendar.config.ContentCalendarProperites;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(ContentCalendarProperites.class)
@SpringBootApplication
public class Application {

    public static void main(String[] args) throws JsonProcessingException {
        SpringApplication.run(Application.class, args);
    }

    // This is ANOTHER method of programmatically manipulating data
    // If you want to create an instance of a class using a method a Bean annotation can be used
//    @Bean
//    CommandLineRunner commandLineRunner(ContentRepository repository) {
//        return args -> {
//            Content content = new Content(null,
//                    "My First Radical Story",
//                    "This is my first ever coolio story",
//                    Status.IDEA,
//                    Type.VIDEO,
//                    LocalDateTime.now(),
//                    null,
//                    "");
//
//            repository.save(content);
//        };
//    }
}
