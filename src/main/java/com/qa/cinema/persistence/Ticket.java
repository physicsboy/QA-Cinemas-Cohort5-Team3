package com.qa.cinema.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 
 * @author AlexNewton
 *
 */

@Entity
public class Ticket {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(referencedColumnName="id")
	private Showing showing;
	
	@ManyToOne
	@JoinColumn(referencedColumnName="seatId")
	private Seat seat;
	
	
	private String type;
	private float price;
	
	
	public Ticket(){
		super();
	}


	public Ticket(Showing showing, Seat seat, String type, float price) {
		super();
		this.showing = showing;
		this.seat = seat;
		this.type = type;
		this.price = price;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Showing getShowing() {
		return showing;
	}


	public void setShowing(Showing showing) {
		this.showing = showing;
	}


	public Seat getSeat() {
		return seat;
	}


	public void setSeat(Seat seat) {
		this.seat = seat;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}
	
	
}
