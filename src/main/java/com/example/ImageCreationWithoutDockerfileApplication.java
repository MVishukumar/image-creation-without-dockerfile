package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ImageCreationWithoutDockerfileApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImageCreationWithoutDockerfileApplication.class, args);
		System.out.println("Application started.");
	}

}
