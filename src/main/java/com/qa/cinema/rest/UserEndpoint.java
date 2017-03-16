package com.qa.cinema.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.cinema.service.user.UserService;

/**
 * @author Matt Gordon
 */

@Path("/user")
public class UserEndpoint {

	@Inject
	private UserService service;

	@Path("/json")
	@GET
	@Produces({ "application/json" })
	public String getAllUsers() {
		return service.getAllUsers();
	}
	
	@Path("/json/{id}")
	@GET
	@Produces({ "application/json" })
	public String getUserByID(@PathParam("id") String email) {
		return service.getUserByID(email);
	}

	@Path("/json")
	@POST
	@Produces({ "application/json" })
	public String addUser(String user) {
		return service.createUser(user);
	}
	
	@Path("/json/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateUser(@PathParam("id") String email, String user) {
		return service.updateUser(email, user);
	}

	@Path("/json/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteUser(@PathParam("id") String email) {
		return service.deleteUser(email);
	}
}
