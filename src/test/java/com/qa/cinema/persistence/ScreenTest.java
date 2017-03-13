/**
 * Mark Lester
 */


package com.qa.cinema.persistence;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.OneToMany;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ScreenTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		seats = new ArrayList<Seat>();
		seat2 = new Seat(2,'b',2);
		seats.add(seat2);
		screen1 = new Screen();
		screen1.setURL("some/location 1");
		screen1.setSeats(seats);
		screen1.setScreenId(1);
		screen2 = new Screen("some/location 2");
		
	}

	@After
	public void tearDown() throws Exception {
	}

	private Screen screen1;
	private Screen screen2;
	private Seat seat2;
	
	private List<Seat> seats;
	
	@Test
	public void getScreenIdScreen1() {
		assertEquals(1,screen1.getScreenId());
	}
	
	
	@Test
	public void getURLScreen1() {
		assertEquals("some/location 1", screen1.getURL());
	}
	@Test
	public void getURLScreen2() {
		assertEquals("some/location 2", screen2.getURL());
	}
	
	
	@Test
	public void getSeats() {
		assertEquals('b', screen1.getSeats().get(0).getRow());
	}
	

}
