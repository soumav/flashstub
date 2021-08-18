package com.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.User;
import com.demo.service.RegisterService;

@RestController
public class RegisterController {

	@Autowired
	private RegisterService service;

	@RequestMapping(value="/registerUser",method = RequestMethod.POST)
	public ResponseEntity<Object> save(@RequestHeader(value = "corelation-id", required = false) String cid,
			@RequestBody User user) {
		HttpHeaders headers = new HttpHeaders();
		String corelid = StringUtils.isAllBlank(cid) ? cid : UUID.randomUUID().toString();
		headers.add("corelation-id", corelid);

		String registerUserResponse = service.registerUser(user);
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(registerUserResponse);
	}

	@GetMapping("/getAllUsers")
	public ResponseEntity<Object> fetch(@RequestHeader(value = "corelation-id", required = false) String cid) {
		HttpHeaders headers = new HttpHeaders();
		String corelid = StringUtils.isAllBlank(cid) ?  UUID.randomUUID().toString():cid ;
		headers.add("corelation-id", corelid);

		List<User> users = new ArrayList<User>(service.getUsers());

		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(users);

	}

}
