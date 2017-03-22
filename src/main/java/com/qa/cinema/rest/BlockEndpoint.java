/**
 * @Author Martyn Green
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



@Path("/block")
public class BlockEndpoint {
	
	@Inject
	private BlockService service;

	
	
	@Path("/json/{id}")
	@GET
	@Produces({"application/json"})
	public String getBlock(@PathParam("id") int blockId) {
		return service.getBlock(blockId);
	}
	
	@Path("/json/screen/{id}")
	@GET
	@Produces({"application/json"})
	public String getBlocksForScreen(@PathParam("id")int screenId) {
		return service.getBlocksForScreen(screenId);
	}
	
	
	
	@Path("/json")
	@POST
	@Produces({ "application/json" })
	public String addBlock(String block) {
		return service.addBlock(block);
	}
	
	
	
	
	
	@Path("/json/increase/startColumn/{id}/{size}")
	@PUT
	@Produces({ "application/json" })
	public String increaseStatingCol(@PathParam("size")int increase, @PathParam("id")Long block) {
		return service.increaseStartingCol(block, increase);
	}
	
	@Path("/json/decrease/startColumn/{id}/{size}")
	@PUT
	@Produces({ "application/json" })
	public String decreaseStartingCol(@PathParam("size")int decrease,@PathParam("id")Long block) {
		return service.decreaseStartingCol(block,decrease);
	}
	
	@Path("/json/increase/startRow/{id}/{size}")
	@PUT
	@Produces({ "application/json" })
	public String increaseStartingRow(@PathParam("size")int increase,@PathParam("id")Long block) {
		return service.increaseStartingRow(block, increase);
	}
	
	@Path("/json/decrease/startRow/{id}/{size}")
	@PUT
	@Produces({ "application/json" })
	public String decreaseStartingRow(@PathParam("size")int decrease,@PathParam("id")Long block) {
		return service.decreaseStartingRow(block,decrease);
	}
	
	
	
	

	
	@Path("/json/update/{id}/{x}/{y}/{a} ")
	@PUT
	@Produces({ "application/json" })
	public String updateBlock(@PathParam("id")Long block, @PathParam("x")int x,@PathParam("y")int y,@PathParam("a")int a) {
		return service.updateBlock(block, x,y,a);
	}
	
	
	@Path("/json/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteBlock(@PathParam("id") Long id) {
		return service.deleteBlock(id);
	}
	
	
		
}
