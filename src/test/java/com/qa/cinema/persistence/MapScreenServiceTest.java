package com.qa.cinema.persistence;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.cinema.service.MapScreenService;

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
	public void getScreens() {
		assertEquals(2,service.getScreens().size());
	}

	
	@Test
	public void getScreen() {
		Screen s = service.getScreen(1);
		assertEquals('a',s.getColumn());
	}

	@Test
	public void addScreen() {
		service.addScreen(screen);
		assertEquals(3,service.getScreens().size());
	}

	@Test
	public void deleteScreen() {
		int numberOfScreens = service.getScreens().size();
		Screen s = service.getScreen(1);
		service.deleteScreen(s);
		service.getScreen(1);
		assertEquals(numberOfScreens - 1, service.getScreens().size());
	}

	@Test
	public void updateScreen() {
		Screen screen = new Screen('q', (byte)1);
		screen.setScreenId(1);
		
		service.updateScreen(screen);
		assertEquals('q',service.getScreen(1).getColumn());
	}

}
