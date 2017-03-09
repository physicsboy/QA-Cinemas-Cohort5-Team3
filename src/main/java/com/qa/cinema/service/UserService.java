package com.qa.cinema.service;

public interface UserService {
	String getAllUsers();

	String createUser(String user);
	
	String updateUser(String email, String user);

	String deleteUser(String email);
}
