package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.soumav.*", "com.demo.*" })
public class RegisterFsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegisterFsApplication.class, args);
	}

}
