package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication(scanBasePackages = {"com.commonfw.*", "com.demo.*" })
@EnableDiscoveryClient
@EnableHystrix
public class RegisterFsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegisterFsApplication.class, args);
	}

}
