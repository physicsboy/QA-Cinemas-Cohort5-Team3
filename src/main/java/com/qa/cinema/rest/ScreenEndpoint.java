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

	@Path("/screen/json")
	@GET
	@Produces({"application/json"})
	public String getAllScreens() {
		return service.getScreens();
	}
	
	@Path("/screen/json/{id}")
	@GET
	@Produces({"application/json"})
	public String getScreen(@PathParam("id") int id) {
		return service.getScreen(id);
	}
	
	@Path("/screen/json")
	@POST
	@Produces({ "application/json" })
	public String createScreen(String screen) {
		return service.createScreen(screen);
	}
	
	@Path("/screen/json/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateScreen(@PathParam("id") int id, String screen) {
		return service.updateScreen(id, screen);
	}

	@Path("/screen/json/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteMovie(@PathParam("id") int id) {
		return service.deleteScreen(id);
	}
		
		
}
