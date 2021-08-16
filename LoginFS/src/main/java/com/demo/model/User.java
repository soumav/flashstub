package com.demo.model;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class User {

	@PrimaryKey
	private long id;
	private String username;
	private String email;
	private String pan;
	private String aadhar;
	private long phone;
	private long balance;
	private String password;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(long id, String username, String email, String pan, String aadhar, long phone, long balance,
			String password) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.pan = pan;
		this.aadhar = aadhar;
		this.phone = phone;
		this.balance = balance;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (email == null)
			email = "";
		this.email = email;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if (password == null)
			password = "";
		this.password = password;
	}

}
