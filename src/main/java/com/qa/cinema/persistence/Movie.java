package com.qa.cinema.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PostLoad;
import javax.persistence.Transient;


@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String genre;
	private String description;
	private String year;
	private String cast;
	private int length;
	private boolean outNow;
	
	@Enumerated(EnumType.STRING)
	private Classification classif;
	
	@Transient
	private String classification;
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "movieID")
	private List<Media> media = new ArrayList<>();

	public Movie() {
	}

	public Movie(String title, String genre, String description, String year, Classification classification, String cast, int length, boolean outNow) {
		super();
		this.title = title;
		this.genre = genre;
		this.description = description;
		this.year = year;
		this.classif = classification;
		this.cast = cast;
		this.length = length;
		this.outNow = outNow;
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

	public void setClassification(Classification classification) {
		this.classification = classification.getUrl();
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
	
	public void setOutNow(boolean outNow){
		this.outNow = outNow;
	}
	
	public boolean getOutNow(){
		return outNow;
	}

	@PostLoad
	public void setClassificationUrl(){
		this.classification = classif.getUrl();
	}
	
}
