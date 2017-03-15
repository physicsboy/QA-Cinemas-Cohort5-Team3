package com.qa.cinema.persistence;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SeatTest {


	@Before
	public void setUp() {
		block1.setBlockId(1L);
		seat2 = new Seat(2,'b',Seat.SeatType.STANDARD);
		seat1 = new Seat();
		seat1.setSeatId(1L);
		seat1.setRow('a');
		seat1.setColumn(1);
	}

	@After
	public void tearDown() {
	}

	Block block1 = new Block();
	Seat seat1 = new Seat();
	Seat seat2 = new Seat();
	
	
	@Test
	public void  getSeatIdSetterTest() {
		assertEquals(new Long(1), seat1.getSeatId());
	}
	

	
	@Test
	public void  getColumnConstructerTest() {
		assertEquals(1, seat1.getColumn());
	}
	@Test
	public void  getColumnSetterTest() {
		assertEquals(2, seat2.getColumn());
	}
	
	
	@Test
	public void  getRowConstructerTest() {
		assertEquals('a', seat1.getRow());
	}
	@Test
	public void  getRowSetterTest() {
		assertEquals('b', seat2.getRow());
	}
	
}
