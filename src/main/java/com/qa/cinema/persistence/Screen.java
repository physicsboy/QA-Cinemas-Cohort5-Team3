/**
 * Mark Lester
 */


package com.qa.cinema.persistence;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Screen {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int screenId;
	private String url;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="screen_ID")
	private List<Block> blocks;
	
	
	public Screen() {
	}
	
	public Screen(String url) {
		super();
		this.url = url;
	}
	
	
	
	public int getScreenId() {
		return screenId;
	}
	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}
	
	
	public String getURL() {
		return url;
	}
	public void setURL(String url) {
		this.url = url;
	}	

}
