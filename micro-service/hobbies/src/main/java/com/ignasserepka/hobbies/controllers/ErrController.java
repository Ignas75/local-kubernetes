package com.ignasserepka.hobbies.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrController implements ErrorController {

    @RequestMapping(value = "/error")
    public String error() {
        return "No whitelabel error please";
    }
}
