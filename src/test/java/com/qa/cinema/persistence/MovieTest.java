package com.qa.cinema.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class MovieTest {

	Movie movie;

	@Before
	public void TestSetup() {
		movie = new Movie("The Lord of the Rings", "1234.image.com", "1234.trailer.com", "Fantasy",
				"Two hobbits seek to destroy the ring", "2001", "PG", "Ian McKellen", 228);
	}

	@Test
	public void TestGetId() {
	 assertNull(movie.getId());
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
	public void TestGetPosterURL() {
		assertEquals("1234.image.com", movie.getPosterURL());
	}

	@Test
	public void TestSetPosterURL() {
		movie.setPosterURL("5678.image.com");
		assertEquals("5678.image.com", movie.getPosterURL());
	}
	
	@Test
	public void TestGetTrailerURL() {
		assertEquals("1234.trailer.com", movie.getTrailerURL());
	}

	@Test
	public void TestSetTrailerURL() {
		movie.setTrailerURL("5678.triler.com");
		assertEquals("5678.triler.com", movie.getTrailerURL());
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
		assertEquals("PG", movie.getClassification());
	}

	@Test
	public void TestSetClassification() {
		movie.setClassification("12");
		assertEquals("12", movie.getClassification());
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
