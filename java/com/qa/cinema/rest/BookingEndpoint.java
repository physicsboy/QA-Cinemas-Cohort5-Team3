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

/**
 * 
 * @author Sam.Jarvis
 *
 */
@Path("/movie")
public class BookingEndpoint {

	@Inject
	private BookingService service;

	@Path("/json")
	@GET
	@Produces({ "application/json" })
	public String getAllBookings() {
		return service.getAllBookings();
	}
	
	@Path("/json/{id}")
	@GET
	@Produces({ "application/json" })
	public String getBookingsByUserId(@PathParam("id") Long userId) {
		return service.getBookingsByUserId(userId);
	}

	@Path("/json")
	@POST
	@Produces({ "application/json" })
	public String createBooking(String booking) {
		return service.createBooking(booking);
	}

	@Path("/json/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateBooking(@PathParam("id") Long bookingId, String updatedBooking) {
		return service.updateBooking(bookingId, updatedBooking);
	}

	@Path("/json/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteMovie(@PathParam("id") Long bookingId) {
		return service.deletebooking(bookingId);
	}
}

