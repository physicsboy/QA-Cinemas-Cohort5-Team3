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
		screen2 = new Screen("some/location 2");
		screen2.setScreenId(1);
		seat2 = new Seat(2,'b',2, screen2);
		seat1 = new Seat();
		seat1.setSeatId(1);
		seat1.setRow('a');
		seat1.setColumn(1);
		seat1.setBlock(1);
		seat1.setScreen(screen2);
	}

	@After
	public void tearDown() throws Exception {
	}

	Screen screen2 = new Screen();
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
	
	@Test
	public void  getScreenConstructerTest() {
		assertEquals("some/location 2", seat1.getScreen().getURL());
	}
	@Test
	public void  getScreenSetterTest() {
		assertEquals("some/location 2", seat2.getScreen().getURL());
	}

}
