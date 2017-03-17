package com.qa.cinema.persistence.ticket;

/**
 * 
 * @author AlexNewton
 *
 */
public enum TicketType {
	
	ADULT(9.99f), CHILD(5.99f), CONCESSION(7.49f), PREMIUM(12.99f);
	
	private float price;
	private TicketType(float price){
		this.price = price;
	}
	
	public float getPrice(){
		return price;
	}
	
}
