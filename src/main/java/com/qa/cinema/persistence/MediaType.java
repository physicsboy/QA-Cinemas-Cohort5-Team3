package com.qa.cinema.persistence;

import com.google.gson.annotations.SerializedName;

public enum MediaType {
	
	@SerializedName("POSTER")
	POSTER,
	
	@SerializedName("TRAILER")
	TRAILER,
	
	@SerializedName("IMAGE")
	IMAGE,
	
	@SerializedName("OFFER")
	OFFER;
	
	public String getName(){
		return this.name();
	}
}
