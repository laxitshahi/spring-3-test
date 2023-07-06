package com.learningjava.javaspring3contentcalendar.config;


import org.springframework.boot.context.properties.ConfigurationProperties;

// The value represents the prefix for the configurations
// AFTER creation, you need to run a build to have this take affect
@ConfigurationProperties(value = "cc")
public record ContentCalendarProperites(String welcomeMessage, String about, Integer luckyNumber) {
}
