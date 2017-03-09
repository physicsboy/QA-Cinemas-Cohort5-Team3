/**
 * Mark Lester
 */


package com.qa.cinema.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Screen {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ScreenId;
	private char column;
	private byte row;
	
	
	
	public Screen() {
	}
	
	public Screen(char column, byte row) {
		super();
		this.column = column;
		this.row = row;
	}
	
	
	
	public int getScreenId() {
		return ScreenId;
	}
	public void setScreenId(int screenId) {
		ScreenId = screenId;
	}
	
	
	public char getColumn() {
		return column;
	}
	public void setColumn(char column) {
		this.column = column;
	}
	
	
	public byte getRow() {
		return row;
	}
	public void setRow(byte row) {
		this.row = row;
	}
	
	
	
	
	
	
	
	
	

}
