/**
 * Mark Lester
 */
package com.qa.cinema.service.screen;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;

import com.qa.cinema.persistence.Screen;
import com.qa.cinema.util.JSONUtil;


@ApplicationScoped
@Alternative
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
		util = new JSONUtil();
	}
	
	private JSONUtil util;
	
	
	
	public List<Screen> getScreenObjects() {
		return screens;
	}
	
	@Override
	public String getScreens() {
		return util.getJSONForObject(screens);
	}

	
	public Screen getScreenObject(int id) {
		Screen screen = new Screen();
		for(Screen s: screens){
			if(s.getScreenId() == id){
				screen = s;
			}
		}
		return screen;
	}
	
	@Override
	public String getScreen(int id) {
		Screen screen = new Screen();
		for(Screen s: screens){
			if(s.getScreenId() == id){
				screen = s;
			}
		}
		return util.getJSONForObject(screen);
	}

	@Override
	public String createScreen(String screen) {
		Screen aScreen = util.getObjectForJSON(screen, Screen.class);
		screens.add(aScreen);
		return "Screen screen";
	}

	@Override
	public String deleteScreen(int id) {
		for(Screen s: screens){
			if(s.getScreenId() == id){
				screens.remove(s);
				break;
			}
		}
		return "Screen removed";
	}

	@Override
	public String updateScreen(int id, String screen) {
		Screen updatedScreen  = util.getObjectForJSON(screen, Screen.class);
		for(Screen s: screens){
			if(s.getScreenId() == updatedScreen.getScreenId()){
				screens.remove(s);
				
			}
		}
		screens.add(updatedScreen);
		return "Screen updated";
	}

	

	

}
