package com.learningjava.javaspring3contentcalendar.controller;


import com.learningjava.javaspring3contentcalendar.config.ContentCalendarProperites;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    // SpEL :: We can use this value annotation + syntax to grab data from configuration source (ex. application.properties/yml...)
    // THIS IS NOT NESSECARY WHEN YOU HAVE  SETUP
//    @Value("${cc.welcomeMessage: DEFAULT MESSAGE 📧}")
//    private String welcomeMessage;
//    @Value("${cc.about}")
//    private String about;

    // AFTER CONFIGURATION-PROCESSER is setup, we can simply inject the dependency
    public final ContentCalendarProperites properites;

    public HomeController(ContentCalendarProperites properites) {
        this.properites = properites;
    }


    @GetMapping("/")
    public ContentCalendarProperites home() {
        return properites;
    }
}
