package com.demo.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.User;
import com.demo.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	private LoginService service;

	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestHeader(value = "corelation-id", required = false) String cid,
			@RequestBody User user) throws Exception {
		HttpHeaders headers = new HttpHeaders();
		String corelid = StringUtils.hasText(cid) ? cid : UUID.randomUUID().toString();
		headers.add("corelation-id", corelid);

		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(service.login(user));

	}

}
