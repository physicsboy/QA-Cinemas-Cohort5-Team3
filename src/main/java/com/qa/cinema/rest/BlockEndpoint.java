package com.qa.cinema.rest;


import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.cinema.service.screen.BlockService;






@Path("/Block")
public class BlockEndpoint {
	

	//@Inject
	private BlockService service;

	@Path("/json")
	@GET
	@Produces({"application/json"})
	public String getAllBlocks() {
		return service.getBlocks();
	}
	
	@Path("/json/{id}")
	@GET
	@Produces({"application/json"})
	public String getBlock(@PathParam("id") int id) {
		return service.getBlock(id);
	}
	
	@Path("/json")
	@POST
	@Produces({ "application/json" })
	public String createBlock(String Block) {
		return service.createBlock(Block);
	}
	
	@Path("/json/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateBlock(@PathParam("id") int id, String Block) {
		return service.updateBlock(id, Block);
	}

	@Path("/json/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteBlock(@PathParam("id") int id) {
		return service.deleteBlock(id);
	}
		
		
}
