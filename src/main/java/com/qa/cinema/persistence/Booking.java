package com.qa.cinema.persistence;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.qa.cinema.persistence.Ticket;

/**
 * 
 * @author Sam.Jarvis
 *
 */
@Entity
public class Booking {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long bookingId;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateBooked;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="ticket_booking_id")
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


	public void setId(Long bookingId) {
		this.bookingId = bookingId;	
	}
	
		
}
