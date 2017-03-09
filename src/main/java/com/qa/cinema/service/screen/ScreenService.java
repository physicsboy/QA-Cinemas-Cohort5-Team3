package com.qa.cinema.service.screen;

public interface ScreenService {

	public String getScreens();
	public String getScreen(int id);
	public String deleteScreen(int id);
	public String updateScreen(int id, String screen);
	public String createScreen(String screen);
	
}
