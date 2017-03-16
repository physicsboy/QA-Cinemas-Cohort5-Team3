package com.qa.cinema.persistence;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

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
	
	private Long dateBooked;
	
	private String paymentEmail;

	private String userEmail;
	
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "Booking_bookingID")
	private List<Ticket> tickets;
	
	public Booking(){
		
	}
	
	
	public Booking(Long dateBooked, String paymentEmail, String userEmail) {
		super();
		this.dateBooked = dateBooked;
		this.paymentEmail = paymentEmail;
		this.userEmail = userEmail;
	}

	public Long getBookingId() {
		return bookingId;
	}
	
	public Long getDateBooked() {
		return dateBooked;
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
