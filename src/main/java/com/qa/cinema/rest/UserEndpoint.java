package com.qa.cinema.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.qa.cinema.service.UserService;

@Path("/cinema")
public class UserEndpoint {

	@Inject
	private UserService service;

	@Path("/json/user")
	@GET
	@Produces({ "application/json" })
	public String getAllUsers() {
		return service.getAllUsers();
	}

	@Path("/json/user")
	@POST
	@Produces({ "application/json" })
	public String addUser(String user) {
		return service.createUser(user);
	}
}
