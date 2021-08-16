package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = {"com.commonfw.*", "com.demo.*" })
@EnableDiscoveryClient
//@EnableHystrix
public class LoginFsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginFsApplication.class, args);
	}

}
