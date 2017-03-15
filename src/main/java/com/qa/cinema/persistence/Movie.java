package com.qa.cinema.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String genre;
	private String description;
	private String year;
	private String classification;
	private String cast;
	private int length;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="film_id")
	private List<Media> media = new ArrayList<>();

	public Movie() {
	}

	public Movie(String title, String genre, String description, String year, String classification, String cast, int length) {
		super();
		this.title = title;
		this.genre = genre;
		this.description = description;
		this.year = year;
		this.classification = classification;
		this.cast = cast;
		this.length = length;
	}

	public Long getId() {
		return id;
	}
	
	public void setID(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void addMedia(Media media){
		this.media.add(media);
	}

	public List<Media> getMedia(){
		return media;
	}
	
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getCast() {
		return cast;
	}

	public void setCast(String cast) {
		this.cast = cast;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

}
