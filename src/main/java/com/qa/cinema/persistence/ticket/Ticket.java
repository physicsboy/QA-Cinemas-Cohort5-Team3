package com.qa.cinema.persistence.ticket;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import com.qa.cinema.persistence.Seat;
import com.qa.cinema.persistence.Showing;

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
	
	@Enumerated(EnumType.STRING)
	private TicketType type;
	private float price;
	
	
	public Ticket(){
		super();
	}


	public Ticket(Showing showing, Seat seat, TicketType type) {
		super();
		this.showing = showing;
		this.seat = seat;
		this.type = type;
		this.price = type.getPrice();
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
		return type.name();
	}


	public void setType(TicketType type) {
		this.type = type;
	}


	public float getPrice() {
		return price;
	}


	@PrePersist
	public void setPrice() {
		this.price = Math.round(type.getPrice() * 100f) / 100f;
	}
}
