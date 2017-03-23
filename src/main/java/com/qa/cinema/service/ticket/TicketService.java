package com.qa.cinema.service.ticket;

/**
 * @author AlexNewton
 */
public interface TicketService {
	
	String getAllTickets();
	
	String getTicketByID(Long id);
	
	String getAllTicketsForBooking(Long bookingID);
	
	String createTicket(String ticketJson);
	
	String updateTicket(Long idToUpdate, String newTicket);
	
	String deleteTicket(Long idToDelete);

	String getAllTicketSeatsForShowing(Long showingId);

}
