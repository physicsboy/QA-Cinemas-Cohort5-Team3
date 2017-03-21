/**
 * @Author Martin Green
 * @Author Mark lester
 */
package com.qa.cinema.rest;


import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.cinema.service.block.BlockService;



@Path("/Block")
public class BlockEndpoint {
	
	@Inject
	private BlockService service;

	@Path("/json")
	@GET
	@Produces({"application/json"})
	public String getAllBlocks(int screenId) {
		return service.getAllBlocks(screenId);
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
	public String addBlock(String block) {
		return service.addBlock(block);
	}
	
	
	
	
	
	@Path("/json/{id}")
	@PUT
	@Produces({ "application/json" })
	public String increaseColCount(int increase, String block) {
		return service.increaseColCount(increase,block);
	}
	
	@Path("/json/{id}")
	@PUT
	@Produces({ "application/json" })
	public String decreaseColCount(int decrease, String block) {
		return service.decreaseColCount(decrease, block);
	}
	
	@Path("/json/{id}")
	@PUT
	@Produces({ "application/json" })
	public String increaseRowCount(int increase,String block) {
		return service.increaseRowCount(increase,block);
	}
	
	@Path("/json/{id}")
	@PUT
	@Produces({ "application/json" })
	public String decreaseRowCount(int decrease, String block) {
		return service.decreaseRowCount(decrease,block);
	}
	
	@Path("/json")
	@PUT
	@Produces({ "application/json" })
	public String increaseStatingCol(int increase, String block) {
		return service.increaseStatingCol(increase,block);
	}
	
	@Path("/json")
	@PUT
	@Produces({ "application/json" })
	public String decreaseStatingCol(int decrease,String block) {
		return service.decreaseStatingCol(decrease,block);
	}
	
	@Path("/json")
	@PUT
	@Produces({ "application/json" })
	public String increaseStartingRow(int increase,String block) {
		return service.increaseStartingRow(increase,block);
	}
	
	@Path("/json")
	@PUT
	@Produces({ "application/json" })
	public String decreaseStartingRow(int decrease,String block) {
		return service.decreaseStartingRow(decrease,block);
	}
	
	
	
	
	
	@Path("/json")
	@PUT
	@Produces({ "application/json" })
	public String updateXPosition(String block) {
		return service.updateXPosition(block);
	}
	
	@Path("/json")
	@PUT
	@Produces({ "application/json" })
	public String updateYPosition(String block) {
		return service.updateYPosition(block);
	}
	
	@Path("/json")
	@PUT
	@Produces({ "application/json" })
	public String updateAngle(String block) {
		return service.updateAngle(block);
	}
	
	
	
	
	
	

	@Path("/json/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteBlock(@PathParam("id") Long id) {
		return service.deleteBlock(id);
	}
	
	
		
}
