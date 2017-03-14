package com.qa.cinema.service.screen;

public interface BlockService {

	public String getBlocks();
	public String getBlock(int id);
	public String deleteBlock(int id);
	public String updateBlock(int id, String block);
	public String createBlock(String block);
	
}
