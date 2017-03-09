package com.qa.cinema.rest;


import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.qa.cinema.service.ShowingService;

@Path("/movieApp/showing")
public class ShowingEndPoint {

	
	@Inject
	private ShowingService showing;
	
	@Path("/json")
	@GET
	@Produces({"application/json"})
	public String getAllShowings(){
		return showing.getAllShowings();
	}
	
	
}
