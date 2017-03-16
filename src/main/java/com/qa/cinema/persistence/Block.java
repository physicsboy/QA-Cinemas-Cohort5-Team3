
package com.qa.cinema.persistence;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Block {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long blockId;
	private int colCount;
	private int rowCount;
	private int xPosition;
	private int yPosition;
	private int angle;
	private char startingRow;
	private int startingCol;
	
	
	@OneToMany
	@JoinColumn(name = "seatId")
	private List<Seat> seats;

	public Block() {
	}

	public Block(int colCount, int rowCount, int xPosition, int yPosition) {
		this(colCount, rowCount, xPosition, yPosition, 180, 'A', 1);
	}

	public Block(int colCount, int rowCount, int xPosition, int yPosition, char startingRow, int startingCol) {
		this(colCount, rowCount, xPosition, yPosition, 180, startingRow, startingCol);
	}

	public Block(int colCount, int rowCount, int xPosition, int yPosition, int angle, char startingRow, int startingCol) {
		this.colCount = colCount;
		this.rowCount = rowCount;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.angle = angle;
		this.startingRow = startingRow;
		this.startingCol = startingCol;
	}

	
	
	public Long getBlockId() {
		return blockId;
	}
	public void setBlockId(Long blockId) {
		this.blockId = blockId;
	}

	
	
	public int getColCount() {
		return colCount;
	}
	public void setColCount(int colCount) {
		this.colCount = colCount;
	}

	
	
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	
	
	public int getxPosition() {
		return xPosition;
	}
	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	
	
	public int getyPosition() {
		return yPosition;
	}
	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}

	
	
	public int getAngle() {
		return angle;
	}
	public void setAngle(int angle) {
		this.angle = angle;
	}

	
	
	public int getStartingRow() {
		return startingRow;
	}
	public void setStartingRow(char startingRow) {
		this.startingRow = startingRow;
	}

	
	
	public int getStartingCol() {
		return startingCol;
	}
	public void setStartingCol(int startingCol) {
		this.startingCol = startingCol;
	}

	
	public List<Seat> getSeats() {
		return seats;
	}
	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}
}
