package com.qa.cinema.rest;


import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.cinema.service.ShowingService;

@Path("/showing")
public class ShowingEndPoint {

	
	@Inject
	private ShowingService service;
	
	@Path("/json")
	@GET
	@Produces({"application/json"})
	public String getAllShowings(){
		return service.getAllShowings();
	}
	
	@Path("/json/{id}")
	@GET
	@Produces({"application/json"})
	public String getShowingByShowingId(@PathParam("id")Long showingId){
		return service.getShowingById(showingId);
	}
	
	@Path("/json/movie/{id}")
	@GET
	@Produces({"application/json"})
	public String getShowingByMovieId(@PathParam("id")Long movieId){
		return service.getShowingByMovie(movieId);
	}
	
	@Path("/json")
	@POST
	@Produces({"application/json"})
	public String addShowing(String showing){
		return service.addShowing(showing);
	}
	
	@Path("/json/{id}")
	@PUT
	@Produces({"application/json"})
	public String updateShowing(@PathParam("id") Long showingId, String showing){
		return service.updateShowing(showingId, showing);
	}
	
	@Path("/json/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteShowing(@PathParam("id") Long id) {
		return service.deleteShowing(id);
		}
}
