/**
 * @Author Mark Lester
 */
package com.qa.cinema.service.block;

public interface BlockService {
	
	
	public String getBlock(int blockId);
	public String getAllBlocks(int screenId);
	
	public String increaseColCount(int increase, String block);
	public String increaseRowCount(int increase, String block);
	public String decreaseColCount(int decrease, String block);
	public String decreaseRowCount(int decrease, String block);
	
	public String increaseStatingCol(int increase, String block);
	public String increaseStartingRow(int increase, String block);
	public String decreaseStartingRow(int decrease, String block);
	public String decreaseStatingCol(int decrease, String block);
	
	public String updateXPosition(String block);
	public String updateYPosition(String block);
	public String updateAngle(String block);
	
	public String addBlock(String block);
	public String deleteBlock(int id);
	
	
	
}