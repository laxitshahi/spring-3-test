package com.learningjava.javaspring3contentcalendar;

import org.springframework.stereotype.Component;

// This allows the Spring Context to pick up this class as a component
@Component
public class MessageTest {
    public String getMessage() { return "Hello";}
}
