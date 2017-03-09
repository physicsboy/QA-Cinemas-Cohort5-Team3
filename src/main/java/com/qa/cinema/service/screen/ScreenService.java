package com.qa.cinema.service.screen;

public interface ScreenService {

	public String getScreens();
	public String getScreen(int id);
	public String addScreen(String screen);
	public String deleteScreen(int id);
	public String updateScreen(int id, String screen);
	
}
