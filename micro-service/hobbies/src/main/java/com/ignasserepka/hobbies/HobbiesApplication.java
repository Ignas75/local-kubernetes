package com.ignasserepka.hobbies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class HobbiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(HobbiesApplication.class, args);
	}

	@RequestMapping(path = "/health")
	public static String health(){
		return "Healthy";
	}

	@RequestMapping(path="/")
	public static String home(){
		return "Welcome to the landing page";
	}

}
