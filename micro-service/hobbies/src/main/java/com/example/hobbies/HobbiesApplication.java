package com.example.hobbies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class HobbiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(HobbiesApplication.class, args);
	}

}
