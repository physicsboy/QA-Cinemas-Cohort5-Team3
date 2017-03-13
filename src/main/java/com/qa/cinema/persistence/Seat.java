package com.qa.cinema.persistence;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Seat {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int seatId;
	private int column;
	private char row;
	private int block;
	
	@OneToOne
	@JoinColumn(referencedColumnName="ticketId")
	private Ticket ticket;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="seats")
	private Screen screen;
	
	
	public Seat() {
		super();
	}
	
	public Seat(int column, char row, int block, Screen screen) {
		super();
		this.column = column;
		this.row = row;
		this.block = block;
		this.screen = screen;
	}

	
	
	public int getSeatId() {
		return seatId;
	}
	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}

	
	public char getRow() {
		return row;
	}
	public void setRow(char row) {
		this.row = row;
	}
	
	
	public int getBlock() {
		return block;
	}
	public void setBlock(int block) {
		this.block = block;
	}
	
	
	public Screen getScreen() {
		return screen;
	}
	public void setScreen(Screen screen) {
		this.screen = screen;
	}
	
	
}
