package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class DemoApplication {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DemoApplication.class); // 2. Add this method
	}
	public static void main(String[] args) {
		System.out.println("Hello from spring boot server"); SpringApplication.run(DemoApplication.class, args);
	}

}
