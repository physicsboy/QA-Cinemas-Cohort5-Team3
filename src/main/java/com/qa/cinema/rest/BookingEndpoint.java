package com.qa.cinema.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.cinema.service.BookingService;
import com.qa.cinema.service.ticket.TicketService;

/**
 * 
 * @author Sam.Jarvis
 *
 */
@Path("/booking")
public class BookingEndpoint {

	@Inject
	private BookingService service;
	private TicketService tickserv;

	@Path("/json")
	@GET
	@Produces({ "application/json" })
	public String getAllBookings() {
		return service.getAllBookings();
	}
	
	@Path("/json/user/{id}")
	@GET
	@Produces({ "application/json" })
	public String getBookingsByUserId(@PathParam("id") Long userId) {
		return service.getBookingsByUserId(userId);
	}
	
	@Path("/json/{id}")
	@GET
	@Produces({ "application/json" })
	public String getBookingsById(@PathParam("id") Long bookingId) {
		return service.getBookingByBookingId(bookingId);
	}

	@Path("/json")
	@POST
	@Produces({ "application/json" })
	public String createBooking(String booking) {
	    String returnVal = service.createBooking(booking);
		return returnVal;
	}

	@Path("/json/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteBooking(@PathParam("id") Long bookingId) {
		return service.deleteBooking(bookingId);
	}
	
	@Path("/json/{bookingId}/{showingId}/{seatId}")
	@POST
	@Produces({ "application/json" })
	public String addTicketToBooking(@PathParam("bookingId") Long bookingId,@PathParam("showingId") Long showingId,@PathParam("seatId") Long seatId,String ticket) {
	    String returnVal = service.addTicketToBooking(bookingId,showingId,seatId,ticket);
		return returnVal;
	}
	
	
}

