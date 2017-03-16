package com.qa.cinema.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author AlexNewton
 */

@Entity
public class Media {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String url;
	private MediaType type;
	
	public Media(){
		super();
	}
	
	public Media(String url, MediaType type){
		this.url = url;
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getType() {
		return type.getName();
	}

	public void setType(MediaType type) {
		this.type = type;
	}
}
