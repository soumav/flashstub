package com.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.User;
import com.demo.repository.UserRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
//@Slf4j
public class RegisterService {

	Logger LOGGER = LoggerFactory.getLogger(RegisterService.class);

	@Autowired
	private UserRepository repository;

	@CircuitBreaker(name = "registerservice", fallbackMethod = "fallbackRegisterService")
	public String registerUser(User user) {
		repository.save(user);
		LOGGER.info("Successfully Saved");
		return "User successfully registered";
	}

	public String fallbackRegisterService(User user, Throwable t) {
		LOGGER.error("Exception occured while querying DB.", t);
		return "Please try again in sometime!";
	}

	public List<User> getUsers() {
		List<User> findAll = repository.findAll();
		return findAll;
	}

}
