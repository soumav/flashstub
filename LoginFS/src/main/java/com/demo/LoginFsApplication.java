package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.commonfw.*", "com.demo.*" })
public class LoginFsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginFsApplication.class, args);
	}

}
