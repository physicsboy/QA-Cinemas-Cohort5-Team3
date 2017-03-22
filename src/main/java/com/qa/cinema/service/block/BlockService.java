/**
 * @Author Mark Lester
 */
package com.qa.cinema.service.block;

public interface BlockService {
	
	public String getBlock(long blockId);
	public String getBlocksForScreen(int screenId);
	
	public String increaseStartingCol(long blockId, int increase);
	public String increaseStartingRow(long blockId, int increase);
	public String decreaseStartingRow(long blockId, int decrease);
	public String decreaseStartingCol(long blockId, int decrease);
	
	public String updateBlock(long blockId, int x, int y, int angle);
	public String addBlock(String block);
	public String deleteBlock(Long id);
	
	
	
}