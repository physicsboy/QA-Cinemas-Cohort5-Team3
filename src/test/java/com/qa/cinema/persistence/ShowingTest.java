//package com.qa.cinema.persistence;
//import static org.junit.Assert.*;
//
//import org.junit.Test;
//
//import com.qa.cinema.persistence.Showing;
//public class ShowingTest {
//	
//	
//	//public Movie(String title, String posterURL, String genre, String description, String year, String classification,
//	//String cast, int length) {
//
//	
//	Movie movie = new Movie("Lord of the Rings", "Fantasy", "Frodo visits a volcano to dispose of some old heirloom", "2003", Classification.CLASS_PG, "Ian Mckellen", 2, true);
//	Screen screen = new Screen();
//	Showing showing = new Showing(movie, 040320017183500, screen);
//	
//	@Test
//	public void testObject() {
//		
//		assertNotNull(showing);
//		Showing showingTwo = showing;
//		assertEquals(showing, showingTwo);
//		
//	}
//	
//	@Test
//	public void testDateTime(){
//		showing.setDateTime("050320017183500");
//		
//		equals(showing.getDateTime());
//	}
//	
//	@Test
//	public void testScreen(){
//		
//		showing.setScreen(screen);
//		
//		assertEquals(screen, showing.getScreen());
//	}
//	
//	@Test
//	public void testMovie(){
//		
//		showing.setMovie(movie);
//		
//		assertEquals(movie, showing.getMovie());
//	}
//	
//}
