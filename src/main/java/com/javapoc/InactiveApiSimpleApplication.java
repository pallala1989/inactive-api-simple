package com.javapoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InactiveApiSimpleApplication {

	public static void main(String[] args) {
		SpringApplication.run(InactiveApiSimpleApplication.class, args);
		System.out.println("Inactive API Simple Demo started successfully...");
	}
}
