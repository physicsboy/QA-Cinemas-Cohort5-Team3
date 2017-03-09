package com.qa.cinema.service.ticket;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.qa.cinema.persistence.Ticket;
import com.qa.cinema.util.JSONUtil;


/**
 * @author AlexNewton
 */

@Stateless
@Default
public class DBTicketService implements TicketService {
	
	
	@PersistenceContext(unitName="primary")
	private EntityManager manager;
	
	@Inject JSONUtil util;

	@Override
	public String getAllTickets() {
		Query query = manager.createQuery("Select t from Ticket t");
		
		@SuppressWarnings("unchecked")
		Collection<Ticket> tickets = (Collection<Ticket>) query.getResultList();
		return util.getJSONForObject(tickets);
	}

	@Override
	public String getTicketByID(Long id) {

		Ticket ticket = findByID(id);
		if(ticket == null){
			return "{\"message\": \"No such ticket found\"}";
		}
		
		return util.getJSONForObject(ticket);
	}

	@Override
	public String getAllTicketsForBooking(Long bookingID) {
		Query query = manager.createQuery("Select t from Booking.tickets t where Booking.booking_id = " + bookingID);
	
		@SuppressWarnings("unchecked")
		Collection<Ticket> tickets = (Collection<Ticket>) query.getResultList();
		
		return util.getJSONForObject(tickets);
	}

	@Override
	public String createTicket(String ticketJson) {
		Ticket ticket = util.getObjectForJSON(ticketJson, Ticket.class);
		manager.persist(ticket);
		
		return "{\"message\": \"Ticket added sucessfully\"}";
	}

	@Override
	public String updateTicket(Long idToUpdate, String newTicket) {
		Ticket ticketToUpdate = findByID(idToUpdate);
		
		if(ticketToUpdate == null){
			return "{\"message\": \"No ticket found\"}";
		}
		
		Ticket updatedTicket = util.getObjectForJSON(newTicket, Ticket.class);
		updatedTicket.setId(ticketToUpdate.getId());
		manager.merge(updatedTicket);
		
		return "{\"message\": \"Ticket updated sucessfully\"}";
	}

	@Override
	public String deleteTicket(Long idToDelete) {
		Ticket ticketToDelete = findByID(idToDelete);
		
		if(ticketToDelete == null){
			return "{\"message\": \"No ticket found\"}";
		}
		
		manager.remove(ticketToDelete);
		return "{\"message\": \"Ticket deleted sucessfully\"}";
	}
	
	
	private Ticket findByID(Long id){
		return manager.find(Ticket.class, id);
	}
	
}