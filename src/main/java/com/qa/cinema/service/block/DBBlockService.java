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
import javax.persistence.Query;

import com.qa.cinema.persistence.Block;
import com.qa.cinema.persistence.Screen;
import com.qa.cinema.persistence.Seat;
import com.qa.cinema.util.JSONUtil;

@Stateless
@Default
@Named("dbBlockService")
public class DBBlockService implements BlockService {

	
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
	public String deleteBlock(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	@Override
	public String increaseColCount(int increase, String block) {
		Block blockObj = util.getObjectForJSON(block, Block.class);
		increaseColCount(increase, blockObj);
		return null;
	}
	private void increaseColCount(int increase, Block block){
		int colCount = block.getColCount();
		int startingCol = block.getStartingCol();
		int rowCount = block.getRowCount();
		int startingRow = block.getStartingRow();
		
		int firstNewRow = (startingRow + rowCount + 1);
		int lastRowToAdd = firstNewRow + increase;
		int firstNewCol = (startingCol + colCount + 1);
		int lastColToAdd = firstNewCol + increase;
		
		for(int newCol = firstNewCol; newCol <= lastColToAdd; newCol++){
			for(int newRow = firstNewRow; newRow <= lastRowToAdd; newRow++){
				//Seat seat = new Seat(newRow, newCol, Seat.SeatType.STANDARD);
				//em.persist(seat);
			}
		}
	}

	
	
	
	
	
	
	@Override
	public String increaseRowCount(int increase, String block) {
		Block blockObj = util.getObjectForJSON(block, Block.class);
		return null;
	}
	

	@Override
	public String decreaseColCount(int decrease, String block) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String decreaseRowCount(int decrease, String block) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String increaseStatingCol(int increase, String block) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String increaseStartingRow(int increase, String block) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String decreaseStartingRow(int decrease, String block) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String decreaseStatingCol(int decrease, String block) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateXPosition(String block) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateYPosition(String block) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateAngle(String block) {
		// TODO Auto-generated method stub
		return null;
	}

	

	

	
	
	
	
	
	
	
	

	

	

	

}
