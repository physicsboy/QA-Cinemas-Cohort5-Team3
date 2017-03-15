/**
 * @Author Mark Lester
 */


package com.qa.cinema.service.block;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.qa.cinema.persistence.Block;
import com.qa.cinema.persistence.Seat;
import com.qa.cinema.util.JSONUtil;

@Stateless
@Default
public class DBBlockService implements BlockService {

	
	@PersistenceContext
	EntityManager em;
	
	@Inject
	private JSONUtil util;
	
	
	
	@Override
	public String getBlock(int blockId) {
		Block b = em.find(Block.class, blockId);
		return util.getJSONForObject(b);
	}

	@Override
	public String getAllBlocks(int ScreenId) {
		Query query = em.createQuery("Select b From Block b");
		Collection<Block> blocks = (Collection<Block>)query.getResultList();
		return util.getJSONForObject(blocks);
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
		
		int newRowCount = rowCount + increase;
		char firstNewCol = (char)(startingCol + colCount + 1);
		int lastColToAdd = firstNewCol + increase;
		
		
		for(char newCol = firstNewCol; newCol <= lastColToAdd; newCol++){
			for(int newRow = startingRow; newRow <= newRowCount; newRow++){
				Seat seat = new Seat(newRow, newCol, Seat.SeatType.STANDARD);
				seat.setBlock(block);
				em.persist(seat);
			}
			
		}
		
		
	}

	@Override
	public String increaseRowCount(int increase, String block) {
		// TODO Auto-generated method stub
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

	@Override
	public String addBlock(String block) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteBlock(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	
	
	
	

	

	

	

}
