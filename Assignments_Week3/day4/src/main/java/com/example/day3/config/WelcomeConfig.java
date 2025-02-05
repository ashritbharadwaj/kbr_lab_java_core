package com.example.day3.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WelcomeConfig {

    @Value("${welcome.message}")
    private String welcomeMessage;

    public String getWelcomeMessage() {
        return welcomeMessage;
    }
}
