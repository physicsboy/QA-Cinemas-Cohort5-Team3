package com.qa.cinema.rest;


import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.cinema.service.screen.ScreenService;

public class ScreenEndpoint {
	

	@Inject
	private ScreenService service;

	@Path("/json")
	@GET
	@Produces({"application/json/screen"})
	public String getAllScreens() {
		return service.getScreens();
	}
	
	@Path("/json")
	@POST
	@Produces({ "application/json/screen" })
	public String addMovie(String screen) {
		return service.addScreen(screen);
	}
	
	@Path("/json/{id}")
	@PUT
	@Produces({ "application/json/screen" })
	public String updateScreen(@PathParam("id") int id, String screen) {
		return service.updateScreen(id, screen);
	}

	@Path("/json/{id}")
	@DELETE
	@Produces({ "application/json/screen" })
	public String deleteMovie(@PathParam("id") int id) {
		return service.deleteScreen(id);
	}
		
		
}
