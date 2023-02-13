package com.ignasserepka.hobbies.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    @RequestMapping(path = "/health")
    public static String health(){
        return "Healthy";
    }

    @RequestMapping(path="/")
    public static String home(){
        return "Welcome to the landing page";
    }
}
