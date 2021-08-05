package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.User;
import com.demo.repository.UserRepository;

@Service
//@Slf4j
public class RegisterService {

	@Autowired
	private UserRepository repository;

	public void registerUser(User user) {   
		repository.save(user);
		//log.info("Successfully Saved");
	}

	public List<User> getUsers() {
		List<User> findAll = repository.findAll();
		return findAll;
	}

}