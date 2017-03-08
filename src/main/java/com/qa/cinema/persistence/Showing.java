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
	private Long movieID;
	private String dateTime;
	private Integer screenID;
	
	public Showing() {
		
	}
	
	public Showing(String dateTime){
		this.dateTime = dateTime;
	}

	public Long getId() {
		return id;
	}

	public Long getMovieID() {
		return movieID;
	}

	public void setMovieID(Long movieID) {
		this.movieID = movieID;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public Integer getScreenID() {
		return screenID;
	}

	public void setScreenID(Integer screenID) {
		this.screenID = screenID;
	}
}
