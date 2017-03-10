package com.qa.cinema.service.user;

/**
 * @author Matt Gordon
 */

public interface UserService {
	String getAllUsers();

	String getUserByID(String email);

	String createUser(String user);

	String updateUser(String email, String user);

	String deleteUser(String email);
}
