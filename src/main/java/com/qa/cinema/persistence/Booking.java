package com.qa.cinema.persistence;

import java.util.Date;
import java.util.List;
import com.qa.cinema.persistence.Ticket;

public class Booking {
	
	private Long bookingId;
	private Date dateBooked;
	private List<Ticket> tickets;
	private String paymentEmail;
	private String userEmail;
	
	public Booking(){
		
	}
	
	
	public Booking(Date dateBooked, List<Ticket> tickets, String paymentEmail, String userEmail) {
		super();
		this.dateBooked = dateBooked;
		this.tickets = tickets;
		this.paymentEmail = paymentEmail;
		this.userEmail = userEmail;
	}

	public Long getBookingId() {
		return bookingId;
	}
	
	public Date getDateBooked() {
		return dateBooked;
	}
	
	
	public List<Ticket> getTickets() {
		return tickets;
	}
	
	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
	public String getPaymentEmail() {
		return paymentEmail;
	}
	public void setPaymentEmail(String paymentEmail) {
		this.paymentEmail = paymentEmail;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
		
}
