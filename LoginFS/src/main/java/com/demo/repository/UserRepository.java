package com.demo.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.model.User;

@Repository
public interface UserRepository extends CassandraRepository<User, Long> {

	@Query("select * FROM User WHERE email = ?0 AND password = ?1 ALLOW FILTERING")
	User findByEmailPass(String email, String password);

}
