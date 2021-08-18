package com.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.User;
import com.demo.repository.UserRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class LoginService {

	Logger LOGGER = LoggerFactory.getLogger(LoginService.class);

	@Autowired
	private UserRepository repository;

	@CircuitBreaker(name = "loginservice", fallbackMethod = "fallbackLoginService")
	public String login(User user) {
		User userFetched = repository.findByEmailPass(user.getEmail(), user.getPassword());
		return String.valueOf(userFetched != null ? true : false);
	}

	public String fallbackLoginService(User user, Throwable t) {
		LOGGER.error("Exception occured while querying DB.", t);
		return "Please try again in sometime!";
	}
}
