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

	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private Movie movie;
	
	private Long dateShowing;

	@ManyToOne
	@JoinColumn(referencedColumnName = "screenId")
	private Screen screen;

	public Showing() {

	}

	public Showing(Movie movie, Long dateShowing, Screen screen) {
		this.movie = movie;
		this.dateShowing = dateShowing;
		this.screen = screen;
	}

	public Long getId() {
		return id;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Long getDateShowing() {
		return dateShowing;
	}

	public void setDateShowing(Long dateShowing) {
		this.dateShowing = dateShowing;
	}

	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}
}
