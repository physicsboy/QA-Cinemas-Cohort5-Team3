package com.qa.cinema.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Seat {

	int seatId;
	int column;
	char row;
	int block;
	
	
	public Seat() {
		super();
	}
	
	public Seat(int column, char row, int block) {
		super();
		this.column = column;
		this.row = row;
		this.block = block;
	}

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	
	
}
