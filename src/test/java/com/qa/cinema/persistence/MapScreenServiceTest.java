package com.qa.cinema.persistence;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.cinema.service.screen.MapScreenService;



public class MapScreenServiceTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		service = new MapScreenService();
		screen = new Screen('c', (byte)3);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	MapScreenService service;
	Screen screen;
	
	
	@Test
	public void getScreenObjects() {
		assertEquals(2,service.getScreenObjects().size());
	}

	@Test
	public void getScreenObject() {
		Screen s = service.getScreenObject(1);
		assertEquals('a',s.getColumn());
	}
	
	
	@Test
	public void getScreen() {
		String s = service.getScreen(1);
		assertEquals("{\"ScreenId\":1,\"column\":\"a\",\"row\":1}", s);
	}

	@Test
	public void getScreens() {
		assertEquals("[{\"ScreenId\":1,\"column\":\"a\",\"row\":1},{\"ScreenId\":2,\"column\":\"b\",\"row\":2}]",service.getScreens());
	}

	@Test
	public void deleteScreen() {
		int numberOfScreens = service.getScreenObjects().size();
		Screen s = service.getScreenObject(1);
		service.deleteScreen(1);
		service.getScreen(1);
		assertEquals(numberOfScreens - 1, service.getScreenObjects().size());
	}

	@Test
	public void updateScreen() {
		Screen screen = new Screen('q', (byte)1);
		screen.setScreenId(1);
		service.updateScreen(1,"{\"ScreenId\":1,\"column\":\"q\",\"row\":1}");
		assertEquals('q',service.getScreenObject(1).getColumn());
	}

}
