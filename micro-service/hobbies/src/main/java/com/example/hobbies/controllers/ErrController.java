package com.example.hobbies.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrController implements ErrorController {

    @RequestMapping(value = "/error")
    public ResponseEntity<String> handleError(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        
        String exceptionMessage = (String) request.getAttribute("javax.servlet.error.message");

        String responseMessage = "An error occurred with status: " + statusCode;
        if (exceptionMessage != null) {
            responseMessage += ", Message: " + exceptionMessage;
        }

        return new ResponseEntity<>(responseMessage, HttpStatus.valueOf(statusCode));
    }
}
