/**
 * Mark Lester
 */


package com.qa.cinema.persistence;

import static org.junit.Assert.*;

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
		screen1 = new Screen();
		screen1.setColumn('a');
		screen1.setRow((byte)1);
		screen1.setScreenId(1);
		screen2 = new Screen('b', (byte)2);
	}

	@After
	public void tearDown() throws Exception {
	}

	private Screen screen1;
	private Screen screen2;
	
	
	
	
	@Test
	public void getScreenIdScreen1() {
		assertEquals(1,screen1.getScreenId());
	}
	
	
	@Test
	public void getColumnScreen1() {
		assertEquals('a',screen1.getColumn());
	}
	@Test
	public void getColumnScreen2() {
		assertEquals('b',screen2.getColumn());
	}
	
	
	@Test
	public void getRowScreen1() {
		assertEquals(1,screen1.getRow());
	}
	@Test
	public void getRowScreen2() {
		assertEquals(2,screen2.getRow());
	}
	

}
