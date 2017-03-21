package com.qa.cinema.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class MovieTest {

	Movie movie;

	@Before
	public void TestSetup() {
		movie = new Movie();
		movie = new Movie("The Lord of the Rings", "Fantasy",
				"Two hobbits seek to destroy the ring", "2001", Classification.CLASS_12, "Ian McKellen", 228, true);
	}

	@Test
	public void TestGetId() {
	 assertNull(movie.getId());
	 
	 movie.setID(new Long(1));
	 assertEquals(new Long(1), movie.getId());
 	}

	@Test
	public void TestGetTitle() {
		assertEquals("The Lord of the Rings", movie.getTitle());
	}

	@Test
	public void TestSetTitle() {
		movie.setTitle("Inception");
		assertEquals("Inception", movie.getTitle());
	}
	
	@Test
	public void testGetMedia(){
		assertEquals(0, movie.getMedia().size());
		//TODO
		/*Media media = new Media("abvavgf", MediaType.TRAILER);
		movie.addMedia(media);
		assertEquals(1,  movie.getMedia().size());*/
	}

	@Test
	public void TestGetGenre() {
		assertEquals("Fantasy", movie.getGenre());
	}

	@Test
	public void TestSetGenre() {
		movie.setGenre("Action");
		assertEquals("Action", movie.getGenre());
	}

	@Test
	public void TestGetYear() {
		assertEquals("2001", movie.getYear());
	}

	@Test
	public void TestSetYear() {
		movie.setYear("2010");
		assertEquals("2010", movie.getYear());
	}

	@Test
	public void TestGetDescription() {
		assertEquals("Two hobbits seek to destroy the ring", movie.getDescription());
	}

	@Test
	public void TestSetDescription() {
		movie.setDescription("A dream in a dream in a dream...");
		assertEquals("A dream in a dream in a dream...", movie.getDescription());
	}

	@Test
	public void TestGetClassification() {
		movie.setClassification(Classification.CLASS_12);
		System.out.println(movie.getClassification());
		assertEquals(Classification.CLASS_12.getUrl(), movie.getClassification());
	}

	@Test
	public void TestSetClassification() {
		movie.setClassification(Classification.CLASS_15);
		assertEquals(Classification.CLASS_15.getUrl(), movie.getClassification());
	}

	@Test
	public void TestGetCast() {
		assertEquals("Ian McKellen", movie.getCast());
	}

	@Test
	public void TestSetCast() {
		movie.setCast("Leonardo Decaprio");
		assertEquals("Leonardo Decaprio", movie.getCast());
	}

	@Test
	public void TestGetLength() {
		assertEquals(228, movie.getLength());
	}

	@Test
	public void TestSetLength() {
		movie.setLength(170);
		assertEquals(170, movie.getLength());
	}

}
