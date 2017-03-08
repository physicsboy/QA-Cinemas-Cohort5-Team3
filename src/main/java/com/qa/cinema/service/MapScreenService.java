package com.qa.cinema.service;

import java.util.ArrayList;
import java.util.List;

import com.qa.cinema.persistence.Screen;

public class MapScreenService implements ScreenService{

	
	private Screen screeen1;
	private Screen screeen2;
	private List<Screen> screens;
	
	public MapScreenService() {
		super();
		init();
		
	}
	
	private void init(){
		screeen1 = new Screen('a', (byte)1);
		screeen2 = new Screen('b', (byte)2);
		
		screeen1.setScreenId(1);
		screeen2.setScreenId(2);
		
		screens = new ArrayList<>();
		screens.add(screeen1);
		screens.add(screeen2);
	}
	
	
	
	@Override
	public List<Screen> getScreens() {
		return screens;
	}

	
	@Override
	public Screen getScreen(int id) {
		Screen screen = new Screen();
		for(Screen s: screens){
			if(s.getScreenId() == id){
				screen = s;
			}
		}
		return screen;
	}

	@Override
	public void addScreen(Screen screen) {
		screens.add(screen);
	}

	@Override
	public void deleteScreen(Screen screen) {
		screens.remove(screen);
	}

	@Override
	public void updateScreen(Screen screen) {
		for(Screen s: screens){
			if(s.getScreenId() == screen.getScreenId()){
				screens.remove(s);
			}
		}
		screens.add(screen);
		
	}

	

	

}
