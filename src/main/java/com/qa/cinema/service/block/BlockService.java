/**
 * @Author Mark Lester
 */
package com.qa.cinema.service.block;

import com.qa.cinema.persistence.Block;

public interface BlockService {
	
	public Block getBlockobj(long blockId);
	public String getBlock(long blockId);
	public String getAllBlocks(int screenId);
	
	public String increaseStartingCol(long blockId, int increase);
	public String increaseStartingRow(long blockId, int increase);
	public String decreaseStartingRow(long blockId, int decrease);
	public String decreaseStatingCol(long blockId, int decrease);
	
	public String updateBlock(long blockId, int x, int y, int angle);
	
	
	public String addBlock(String block);

	public String deleteBlock(Long id);
	
	
	
}