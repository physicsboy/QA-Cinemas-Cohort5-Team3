/**
 * @Author Mark Lester
 */


package com.qa.cinema.service.block;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.qa.cinema.persistence.Block;
import com.qa.cinema.persistence.Screen;
import com.qa.cinema.persistence.Seat;
import com.qa.cinema.util.JSONUtil;

@Stateless
@Default
@Named("dbBlockService")
@Transactional
public class DBBlockService implements BlockService {
	
	private static final String UPDATE_SUCCESS = "{\"message\": \"Block sucessfully updated\"}";

	
	@PersistenceContext
	private EntityManager em;
	
	@Inject()
	private JSONUtil util;
	
	
	@Override
	public Block getBlockobj(long blockId) {
		return em.find(Block.class, blockId);
	}
	
	
	@Override
	public String getBlock(long blockId) {
		Block b = em.find(Block.class, blockId);
		return util.getJSONForObject(b);
	}

	@Override
	public String getAllBlocks(int screenId) {
		Collection<Block> blocks =
				em.find(Screen.class, screenId).getBlocks();
		return util.getJSONForObject(blocks);
	}
	
	@Override
	public String addBlock(String block) {
		Block blockObj = util.getObjectForJSON(block, Block.class);
		return addBlock(blockObj);
	}
	public String addBlock(Block block) {
		int colCount = block.getColCount();
		int rowCount = block.getRowCount();
		int startingCol = block.getStartingCol();
		int startingRow = block.getStartingRow();
		
		int lastColToAdd = (startingCol + colCount);
		int lastRowToAdd = (startingRow + rowCount);
		List<Seat> seats = new ArrayList<>();
		
		for(int newCol = startingCol; newCol < lastColToAdd; newCol++){
			for(int newRow = startingRow; newRow < lastRowToAdd; newRow++){
				seats.add(
					new Seat(newCol, (char)newRow, Seat.SeatType.STANDARD)
				);
			}
		}
		block.setSeats(seats);
		em.persist(block);
		return "{\"message\": \"Block sucessfully added\"}";
	}
	

	@Override
	public String deleteBlock(Long id) {
		Block block = em.find(Block.class,id);
	    List<Seat> seats = new ArrayList();
	    block.setSeats(seats);
	    em.persist(block);
		em.remove(block);
		return "{\"message\": \"Block sucessfully deleted\"}";
	}
	
	
	
	@Override
	public String increaseColCount(long blockId, int increase) {
		Block block = em.find(Block.class, blockId);	
		int colCount = block.getColCount();
		int startingCol = block.getStartingCol();
		int rowCount = block.getRowCount();
		int startingRow = block.getStartingRow();
	
		int firstNewRow = (startingRow + rowCount + 1);
		int lastRowToAdd = firstNewRow + increase;
		int firstNewCol = (startingCol + colCount + 1);
		int lastColToAdd = firstNewCol + increase;
		
		List<Seat> seats = block.getSeats();
		for(int newCol = firstNewCol; newCol < lastColToAdd; newCol++){
			for(int newRow = startingRow; newRow < lastRowToAdd; newRow++){
				seats.add(
					new Seat(newCol, (char)newRow, Seat.SeatType.STANDARD)
				);
			}
		}
		block.setRowCount(colCount + increase);
		block.setSeats(seats);
		em.persist(block);
		return "{\"message\": \"Column increase accepted\"}";
	}

	@Override
	public String increaseRowCount(long blockId, int increase) {
		Block block = em.find(Block.class, blockId);
		int colCount = block.getColCount();
		int startingCol = block.getStartingCol();
		int rowCount = block.getRowCount();
		int startingRow = block.getStartingRow();
	
		
		int firstNewRow = (startingRow + rowCount + 1);
		int lastRowToAdd = firstNewRow + increase;
		int firstNewCol = (startingCol + colCount + 1);
		int lastColToAdd = firstNewCol + increase;
		
		List<Seat> seats = block.getSeats();
		for(int newCol = firstNewRow; newCol < lastColToAdd; newCol++){
			for(int newRow = startingRow; newRow < lastRowToAdd; newRow++){
				seats.add(
					new Seat(newCol, (char)newRow, Seat.SeatType.STANDARD)
				);
			}
		}
		block.setRowCount(rowCount + increase);
		block.setSeats(seats);
		em.persist(block);
		return "{\"message\": \"Row increase accepted\"}";
	}

	
	
	
	@Override
	public String decreaseColCount(long blockId, int decrease) {
		Block block = em.find(Block.class, blockId);	
		int colCount = block.getColCount();
		int startingCol = block.getStartingCol();
		
		int lastColToRemove = startingCol + colCount - decrease;
		
		List<Seat> seats = block.getSeats();
		for(Seat s: seats){
			if(s.getColumn() <= lastColToRemove){
				seats.remove(s);
			}
		}
		block.setRowCount(colCount - decrease);
		block.setSeats(seats);
		em.persist(block);
		return "{\"message\": \"Column decrease accepted\"}";
	}
	
	

	@Override
	public String decreaseRowCount(long blockId, int decrease) {
		Block block = em.find(Block.class, blockId);
		int rowCount = block.getRowCount();
		int startingRow = block.getStartingRow();
	
		int lastRowToRemove = startingRow + rowCount - decrease;
		
		List<Seat> seats = block.getSeats();
		for(Seat s: seats){
			if(s.getRow() <= lastRowToRemove ){
				seats.remove(s);
			}
		}
		block.setRowCount(rowCount - decrease);
		block.setSeats(seats);
		em.persist(block);
		return "{\"message\": \"Row decrease accepted\"}";
	}

	
	
	
	@Override
	public String increaseStatingCol(long blockId, int increase) {
		Block block = em.find(Block.class, blockId);
		if(increase <= 0 ){
			return "{\"message\": \"Increase must be greater than 0\"}";
		}
		
		int startingCol = block.getStartingCol();
		int colCount = block.getColCount();
		int newStartingRow = startingCol -increase;
	
		List<Seat> seats = block.getSeats();
		for(int col = startingCol; col < (startingCol - increase); col--){
			for(Seat s: seats){
				if(s.getRow() == col){
					s.setRow((char)(col + colCount +1));
				}
			}
		} 
		block.setSeats(seats);
		em.persist(block);
		return UPDATE_SUCCESS;
	}
	
	

	@Override
	public String increaseStartingRow(long blockId, int increase) {
		Block block = em.find(Block.class, blockId);
		if(increase <= 0 ){
			return "{\"message\": \"Increase must be greater than 0\"}";
		}
		
		int startingRow = block.getStartingRow();
		int rowCount = block.getRowCount();
		int newEndingRow = startingRow + rowCount + increase;
		
		if(newEndingRow > 90 ){
			return "{\"message\": Final row cannot exceed Z\"\"}";
		}
		
		List<Seat> seats = block.getSeats();
		
		for(int row = startingRow; row > (startingRow + increase); row++){
			for(Seat s: seats){
				if(s.getRow() == row){
					s.setRow((char)(row + rowCount +1));
				}
			}
		} 
		block.setSeats(seats);
		em.persist(block);
		return UPDATE_SUCCESS;
	}
	

	
	
	
	@Override
	public String decreaseStartingRow(long blockId, int decrease) {
		Block block = em.find(Block.class, blockId);
		if(decrease <= 0 ){
			return "{\"message\": \"Decrease must be greater than 0\"}";
		}
		int startingRow = block.getStartingRow();
		int rowCount = block.getRowCount();
		int newStartingRow = startingRow -decrease;
		
		
		if(newStartingRow < 65 ){
			return "{\"message\": \"Row can not be less than A\"}";
		}
		List<Seat> seats = block.getSeats();
		
		for(int row = startingRow; row < (startingRow - decrease); row--){
			for(Seat s: seats){
				if(s.getRow() == row){
					s.setRow((char)(row + rowCount +1));
				}
			}
		} 
		block.setSeats(seats);
		em.persist(block);
		return UPDATE_SUCCESS;
	}
	

	
	
	@Override
	public String decreaseStatingCol(long blockId, int decrease) {
		Block block = em.find(Block.class, blockId);
		if(decrease <= 0 ){
			return "{\"message\": \"Decrease must be greater than 0\"}";
		}
		int startingCol = block.getStartingCol();
		int colCount = block.getColCount();
		int newStartingCol = startingCol -decrease;
		
		if(newStartingCol < 1 ){
			return "{\"message\": \"Column cannot be less than 1\"}";
		}
		List<Seat> seats = block.getSeats();
		
		for(int col = startingCol; col < (startingCol - decrease); col--){
			for(Seat s: seats){
				if(s.getColumn() == col){
					s.setColumn((col + colCount +1));
				}
			}
		} 
		block.setSeats(seats);
		em.persist(block);
		return UPDATE_SUCCESS;
	}
	
	
	
	@Override
	public String updateBlock(long blockId, int x, int y, int angle) {
		Block block = em.find(Block.class, blockId);
		block.setxPosition(x);
		block.setyPosition(y);
		block.setAngle(angle);
		em.persist(block);
		return UPDATE_SUCCESS;
	}
	

	

	
	
	
	
	
	
	
	

	

	

	

}
