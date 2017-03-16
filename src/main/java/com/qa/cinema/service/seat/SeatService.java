/**
 * @Author Mark lester
 */
package com.qa.cinema.service.seat;

public interface SeatService {

	public String addSeat(int length, int width, int type, char column, int row, int blockId);
	public String addSeats(int length, int width, int type, char column, int row );
	
	public String deleteSeat(String seat);
	public String deleteSeats(int blockId);
	
	public String getSeats(int blockId);
	public String getSeat(int seatId);
	
	public String updateSeat(String seat);
	
	
	
	
}
