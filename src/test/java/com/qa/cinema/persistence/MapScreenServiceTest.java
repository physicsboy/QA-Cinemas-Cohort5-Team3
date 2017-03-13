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
		screen = new Screen("Some/url1");
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
		assertEquals("some/url1",s.getURL());
	}
	
	
	@Test
	public void getScreen() {
		String s = service.getScreen(1);
		assertEquals("{\"screenId\":1,\"url\":\"some/url1\"}", s);
	}

	@Test
	public void getScreens() {
		assertEquals("[{\"screenId\":1,\"url\":\"some/url1\"},{\"screenId\":2,\"url\":\"some/url2\"}]",service.getScreens());
	}
	
	
	@Test
	public void createScreen() {
		service.createScreen("{\"screenId\":1,\"column\":\"a\",\"row\":1}");
		assertEquals(3,service.getScreenObjects().size());
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
		Screen screen = new Screen("Some/url1");
		screen.setScreenId(1);
		service.updateScreen(1,"{\"screenId\":1,\"url\":\"some/url10\"}");
		assertEquals("some/url10",service.getScreenObject(1).getURL());
	}

}
