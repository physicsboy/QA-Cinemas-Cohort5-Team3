package com.qa.cinema.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.cinema.service.ticket.TicketService;

/**
 * @author AlexNewton
 */

@Path("/ticket")
public class TicketEndPoint {

	@Inject
	private TicketService service;
	
	
	@Path("/json")
	@GET
	@Produces({ "application/json" })
	public String getAllTickets() {
		return service.getAllTickets();
	}

	@Path("/json/{id}")
	@GET
	@Produces({ "application/json" })
	public String getTicketByID(@PathParam("id") Long id) {
		return service.getTicketByID(id);
	}
	
	@Path("/json/booking/{bookingID}")
	@GET
	@Produces({"application/json"})
	public String getTicketsForBooking(@PathParam("bookingID") Long bookingID){
		return service.getAllTicketsForBooking(bookingID);
	}
	
	
	@Path("/json")
	@POST
	@Produces({ "application/json" })
	public String addTicket(String ticket) {
		return service.createTicket(ticket);
	}

	@Path("/json/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateTicket(@PathParam("id") Long id, String updated) {
		return service.updateTicket(id, updated);
	}

	@Path("/json/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteTicket(@PathParam("id") Long id) {
		return service.deleteTicket(id);
	}
	
	
	
}
