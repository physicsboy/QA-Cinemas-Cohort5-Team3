package com.qa.cinema.service;

import java.util.List;
import com.qa.cinema.persistence.Screen;

public interface ScreenService {

	public List<Screen> getScreens();
	public Screen getScreen();
	public void createScreen();
	public void deleteScreen();
	
}
