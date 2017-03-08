package com.qa.cinema.service;

import java.util.List;
import com.qa.cinema.persistence.Screen;

public interface ScreenService {

	public List<Screen> getScreens();
	public Screen getScreen(int id);
	public void addScreen(Screen screen);
	public void deleteScreen(Screen screen);
	public void updateScreen(Screen screen);
	
}
