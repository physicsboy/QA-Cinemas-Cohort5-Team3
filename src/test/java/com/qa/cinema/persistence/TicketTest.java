package com.qa.cinema.persistence;


/**
 * @author AlexNewton
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TicketTest {
	
	private Ticket ticket;
	private Showing showing;
	private Seat seat;

	@Before
	public void setUp() {
		seat = new Seat();
		seat.setSeatId(1);
		ticket = new Ticket(null, seat , "Child", 9.99f);
		
	}
	
	
	
	
	@Test
	public void testNoArgsConstructor(){
		ticket = new Ticket();
		assertNull(ticket.getShowing());
		assertNull(ticket.getSeat());
		assertEquals(0, ticket.getPrice(), 0.0001);
	}

	@Test
	public void testGetShowing() {
		assertEquals(showing, ticket.getShowing());
	}
	
	@Test
	public void testSetShowing(){
		Showing newShowing = new Showing(null, "12-01-1995-13-08-12", null);
		
		ticket.setShowing(newShowing);
		assertEquals(newShowing, ticket.getShowing());
	}
	
	@Test
	public void testGetSeat(){
		assertEquals(1, ticket.getSeat().getSeatId());
	}
	
	@Test
	public void testSetSeat(){
		ticket.setSeat(seat);
		assertEquals(1, ticket.getSeat().getSeatId());
	}
	
	@Test
	public void testGetPrice(){
		assertEquals(9.99f, ticket.getPrice(), 0.001);
	}
	
	@Test
	public void testSetPrice(){
		ticket.setPrice(6.99f);
		assertEquals(6.99f, ticket.getPrice(), 0.001);
	}
	
	@Test
	public void testGetType(){
		assertEquals("Child", ticket.getType());
	}
	
	@Test
	public void testSetType(){
		ticket.setType("Adult");
		assertEquals("Adult", ticket.getType());
	}
	
	@Test
	public void testGetID(){
		Long id = new Long(1);
		ticket.setId(id);
		assertEquals(id, ticket.getId());
	}

}
