/**
 * Mark Lester
 * Martin Green
 */

package com.qa.cinema.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Seat {

	public enum SeatType{
		DIRECTOR(14, 16), 
		STANDARD(10, 12), 
		LUXURY(12, 14);
		
		private int length;
		private int width;
		
		SeatType(int length, int width){
			this.length = length;
			this.width = width;
		}
		
		public int getLength(){
			return length;
		}
		
		public int getWidth(){
			return width;
		}
		
	}
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long seatId;
	private int column;
	private char row;
	private SeatType type;

	@ManyToOne
	@JoinColumn(name = "blockId")//, referencedColumnName = "blockId")
	private Block block;
	
	
	
	public Seat() {
		super();
	}
	
	public Seat(int column, char row, SeatType type) {
		super();
		this.column = column;
		this.row = row;
		this.type = type;
	
	}

	
	
	public Long getSeatId() {
		return seatId;
	}
	public void setSeatId(Long newSeatId) {
		this.seatId = newSeatId;
	}

	
	public Block getBlock() {
		return block;
	}
	public void setBlock(Block block) {
		this.block = block;
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
	
	public SeatType getType() {
		return type;
	}
	public void setType(SeatType type) {
		this.type = type;
	}
	
	
}
