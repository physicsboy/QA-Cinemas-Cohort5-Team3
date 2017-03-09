/**
 * MarkLester
 */
package com.qa.cinema.persistence;

import java.util.ArrayList;
import java.util.List;


public class ScreenServiceOfflineTestData{

	private Screen screeen1;
	private Screen screeen2;
	private Screen screeen3;
	private Screen screeen4;
	private Screen screeen5;
	private Screen screeen6;
	private List<Screen> screens;
	
	
	public ScreenServiceOfflineTestData() {
		super();
		screeen1 = new Screen('a', (byte)1);
		screeen2 = new Screen('b', (byte)2);
		screeen3 = new Screen('c', (byte)3);
		screeen4 = new Screen('d', (byte)4);
		screeen5 = new Screen('e', (byte)5);
		screeen6 = new Screen('f', (byte)6);
		screeen1.setScreenId(1);
		screeen2.setScreenId(2);
		screeen3.setScreenId(3);
		screeen4.setScreenId(4);
		screeen5.setScreenId(5);
		screeen6.setScreenId(6);
		screens = new ArrayList<>();
		screens.add(screeen1);
		screens.add(screeen2);
		screens.add(screeen3);
		screens.add(screeen4);
		screens.add(screeen5);
		screens.add(screeen6);
	}


	public List<Screen> getScreens() {
		return screens;
	}


	
	
	
	
	
	
	
	
}
