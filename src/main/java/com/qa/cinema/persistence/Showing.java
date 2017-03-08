package com.qa.cinema.persistence;



/**
 * @author James Lamkin
 */

import javax.persistence.*;

@Entity
public class Showing {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Movie movie;
	private String dateTime;
	private Screen screen;
	
	public Showing() {
		
	}
	
	public Showing(String dateTime){
		this.dateTime = dateTime;
	}

	public Long getId() {
		return id;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovieID(Movie movie) {
		this.movie = movie;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public Integer getScreen() {
		return screen;
	}

	public void setScreenID(Screen screen) {
		this.screen = screenID;
	}
}
