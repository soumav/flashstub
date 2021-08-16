package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.User;
import com.demo.repository.UserRepository;

@Service
public class LoginService {

	@Autowired
	private UserRepository repository;

	public boolean login(User user) {
		User userFetched = repository.findByEmailPass(user.getEmail(), user.getPassword());
		return userFetched != null ? true : false;
	}

}
