package com.qa.cinema.service;

import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.qa.cinema.persistence.Booking;
import com.qa.cinema.util.JSONUtil;

/**
 * 
 * @author Sam.Jarvis
 *
 */
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
	public String getBookingsByUserId(Long userId) {
		Query query = em.createQuery("SELECT b FROM Booking b WHERE b.booking_id = "+userId);
		@SuppressWarnings("unchecked")
		Collection<Booking> bookings = (Collection<Booking>) query.getResultList();
		return util.getJSONForObject(bookings);
	}

	@Override
	public String createBooking(String booking) {
		Booking newBooking = util.getObjectForJSON(booking, Booking.class);
		em.persist(newBooking);
		return "{\"message\": \"Booking sucessfully added\"}";
	}

	@Override
	public String updateBooking(Long id, String updatedBooking) {
		Booking updateBooking = util.getObjectForJSON(updatedBooking, Booking.class);
		Booking bookingInDB = findBooking(new Long(id));
		if (bookingInDB != null) {
			bookingInDB = updateBooking;
			em.merge(updatedBooking);
		}
		return "{\"message\": \"Booking sucessfully updated\"}";
	}

	@Override
	public String deletebooking(Long id) {
		Booking bookingInDB = findBooking(new Long(id));
		if (bookingInDB != null) {
			em.remove(bookingInDB);
		}
		return "{\"message\": \"Booking sucessfully deleted\"}";
	}
	
	private Booking findBooking(Long id) {
		return em.find(Booking.class, id);
	}

}