package com.qa.cinema.service;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.qa.cinema.persistence.Booking;
import com.qa.cinema.persistence.Seat;
import com.qa.cinema.persistence.Showing;
import com.qa.cinema.persistence.ticket.Ticket;
import com.qa.cinema.util.JSONUtil;

/**
 * 
 * @author Sam.Jarvis
 *
 */
@Stateless
@Default
public class DBBookingService implements BookingService {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Inject
	private JSONUtil util;

	@Override
	public String getAllBookings() {
		Query query = em.createQuery("SELECT b FROM Booking b");
		@SuppressWarnings("unchecked")
		Collection<Booking> bookings = (Collection<Booking>) query.getResultList();

		return util.getJSONForObject(bookings);
	}

	@Override
	public String getBookingByBookingId(Long bookingId) {
		Query query = em.createQuery("SELECT b FROM Booking b WHERE b.bookingId = "+bookingId);
		@SuppressWarnings("unchecked")
		Collection<Booking> bookings = (Collection<Booking>) query.getResultList();
		return util.getJSONForObject(bookings);
	}
	
	@Override
	public String getBookingsByUserId(Long userId) {
		Query query = em.createQuery("SELECT b FROM Booking b WHERE b.user_id = "+userId);
		@SuppressWarnings("unchecked")
		Collection<Booking> bookings = (Collection<Booking>) query.getResultList();
		return util.getJSONForObject(bookings);
	}

	@Override
	public String createBooking(String booking) {
		Booking newBooking = util.getObjectForJSON(booking, Booking.class);
		em.persist(newBooking);
		return "{\"bookingId\": \""+newBooking.getBookingId()+"\"}";
	}

	@Override
	public String deleteBooking(Long id) {
		Booking bookingInDB = findBooking(new Long(id));
		if (bookingInDB != null) {
			em.remove(bookingInDB);
			return "{\"message\": \"Booking sucessfully deleted\"}";
		}
		return "{\"message\": \"Old Booking not found\"}";
	}
	
	private Booking findBooking(Long id) {
		return em.find(Booking.class, id);
	}
	
	private Seat findSeat(Long id) {
		return em.find(Seat.class, id);
	}
	
	private Showing findShowing(Long id) {
		return em.find(Showing.class, id);
	}
	
	


	@Override
	public String addTicketToBooking(Long bookingId, Long showingId, Long seatId, String ticket) {
		Booking book = findBooking(bookingId);
		Ticket ticketToAdd = util.getObjectForJSON(ticket, Ticket.class);
		ticketToAdd.setSeat(findSeat(seatId));
		ticketToAdd.setShowing(findShowing(showingId));
		book.addTicket(ticketToAdd);
		em.persist(book);
		return util.getJSONForObject(book);
	}



}
