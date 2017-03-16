package com.qa.cinema.service;

/**
 * 
 * @author Sam.Jarvis
 *
 */
public interface BookingService {
	
	public String getAllBookings();
	public String getBookingsByUserId(Long userId);
	public String getBookingByBookingId(Long userId);	
	public String createBooking(String booking);
	public String deleteBooking(Long id);
	
	
	

}
