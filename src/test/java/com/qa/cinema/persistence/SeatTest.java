package com.qa.cinema.persistence;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SeatTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		seat2 = new Seat(2,'b',2);
		seat1 = new Seat();
		seat1.setSeatId(1);
		seat1.setRow('a');
		seat1.setColumn(1);
		seat1.setBlock(1);
	}

	@After
	public void tearDown() throws Exception {
	}

	
	Seat seat1 = new Seat();
	Seat seat2 = new Seat();
	
	
	@Test
	public void  getSeatIdSetterTest() {
		assertEquals(1, seat1.getSeatId());
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
	
	
	@Test
	public void  getBlockConstructerTest() {
		assertEquals(1, seat1.getBlock());
	}
	@Test
	public void  getBlockSetterTest() {
		assertEquals(2, seat2.getBlock());
	}
	
	

}
