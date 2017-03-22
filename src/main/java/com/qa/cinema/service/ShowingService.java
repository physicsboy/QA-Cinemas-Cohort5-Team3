package com.qa.cinema.service;

public interface ShowingService {
	
	String getAllShowings();
	
	String getShowingByDate(Long id, Long dateShowing);
	
	String addShowing(String showing);
	
	String deleteShowing(Long id);
	
	String getShowingById(Long showingId);
	
	String getShowingByMovie(Long movieID);
	
	String updateShowing(Long showingId, String showing);
	
	String getShowingsBetweenTimes(Long time1, Long time2);
}
