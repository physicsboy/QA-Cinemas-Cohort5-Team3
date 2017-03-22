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
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transaction;
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
	public String increaseStartingCol(long blockId, int newMax) {
		Block block = em.find(Block.class, blockId);
		int increase = newMax - block.getStartingCol();
		
		List<Seat> seats = block.getSeats();
			for(Seat s: seats){
				int newColPosition = s.getColumn() + increase;
				s.setColumn(newColPosition);
			}
		block.setSeats(seats);
		em.persist(block);
		return UPDATE_SUCCESS;
	}
	
	@Override
	public String decreaseStatingCol(long blockId, int newMin) {
		Block block = em.find(Block.class, blockId);
		int decrease = block.getStartingCol() - newMin;
		
		List<Seat> seats = block.getSeats();
			for(Seat s: seats){
				int newColPosition = s.getColumn() - decrease;
				s.setColumn(newColPosition);
			}
		block.setSeats(seats);
		em.persist(block);
		return UPDATE_SUCCESS;
	}
	

	@Override
	public String increaseStartingRow(long blockId, int newMax) {
		Block block = em.find(Block.class, blockId);
		int increase = newMax - block.getStartingRow();
		List<Seat> seats = block.getSeats();
			for(Seat s: seats){
				int newRowPosition = s.getRow() + increase;
				s.setRow((char)(newRowPosition));
			}
		block.setSeats(seats);
		em.persist(block);
		return UPDATE_SUCCESS;
	}
	
	
	@Override
	public String decreaseStartingRow(long blockId, int newMin) {
		Block block = em.find(Block.class, blockId);
		int decrease = block.getStartingRow() - newMin;
		List<Seat> seats = block.getSeats();
			for(Seat s: seats){
				int newRowPosition = s.getRow() - decrease;
				s.setRow((char)(newRowPosition));
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
