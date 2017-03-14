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
	private Long seatId;
	private int column;
	private char row;

	private int blockID;

	
	public Seat() {
		super();
	}
	
	public Seat(int column, char row, int block) {
		super();
		this.column = column;
		this.row = row;
		this.blockID = block;
	
	}

	
	
	public Long getSeatId() {
		return seatId;
	}
	public void setSeatId(Long seatId) {
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
		return blockID;
	}
	public void setBlock(int block) {
		this.blockID = block;
	}
	
	
}
