package com.qa.cinema.persistence;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Sam.Jarvis
 *
 */
public class BookingTest {

	Booking testBooking;
	List<Ticket> tickets;
	Ticket testTicket;
	Ticket testTicket2;
	Long datetime = Calendar.getInstance().getTime().getTime();
	private Seat seat;
	
	@Before
	public void setUp() {
		seat = new Seat();
		seat.setSeatId(1);
		tickets = new ArrayList<Ticket>();
		testTicket = new Ticket(null, seat, "CHILD", 4.40f);
		testTicket2 = new Ticket(null, seat, "ADULT", 6.70f);
		tickets.add(testTicket);
		testBooking = new Booking(datetime, tickets, "payment@email.com", "user@email.com");
		tickets.add(testTicket2);
	}

	@Test
	public void constructorTest() {
		assertNotNull("Constructor Success", testBooking);
	}

	@Test
	public void getId() {
		assertNull(testBooking.getBookingId());
	}

	@Test
	public void getDateTest() {
		assertEquals(testBooking.getDateBooked(), datetime);
	}

	@Test
	public void getTicketListTest() {
		assertEquals(testTicket, testBooking.getTickets().get(0));
	}

	@Test
	public void getPaymentEmail() {
		assertEquals("payment@email.com", testBooking.getPaymentEmail());
	}

	@Test
	public void getUserEmail() {
		assertEquals("user@email.com", testBooking.getUserEmail());
	}

	@Test
	public void setTicketListTest() {
		testBooking.setTickets(tickets);
		assertEquals(testTicket2, testBooking.getTickets().get(1));
	}

	@Test
	public void setPaymentEmail() {
		testBooking.setPaymentEmail("newpayment@email.com");
		assertEquals("newpayment@email.com", testBooking.getPaymentEmail());
	}

	@Test
	public void setUserEmail() {
		testBooking.setUserEmail("newuser@email.com");
		assertEquals("newuser@email.com", testBooking.getUserEmail());
	}

}
