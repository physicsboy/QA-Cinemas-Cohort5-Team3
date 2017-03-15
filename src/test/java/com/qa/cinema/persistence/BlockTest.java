/**
 * Mark lester
 */

package com.qa.cinema.persistence;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BlockTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		seat1.setSeatId(1L);
		seat2.setSeatId(2L);
		seats.add(seat1);
		seats.add(seat2);
		screen1.setScreenId(1);
		screen2.setScreenId(2);
		block1.setBlockId(1L);
		block1.setAngle(180);
		block1.setColCount(1);
		block1.setRowCount(1);
		block1.setScreen(screen1);
		block1.setSeats(seats);
		block1.setStartingCol(1);
		block1.setStartingRow('a');
		block1.setxPosition(1);
		block1.setyPosition(1);
		block2 = new Block(2, 2, 2, 2, 180, 'b', 2);
	}

	@After
	public void tearDown() throws Exception {
	}

	private Seat seat1 = new Seat();
	private Seat seat2 = new Seat();
	private Block block1 = new Block();
	private Block block2;
	private List<Seat> seats = new ArrayList<Seat>();
	
	private Screen screen1 = new Screen();
	private Screen screen2 = new Screen();
	
	
	
	

	@Test
	public void getBlockId() {
		long id = block1.getBlockId();
		assertEquals(1L, id);
	}
	

	
	@Test
	public void getColCount() {
		assertEquals(1,block1.getColCount());
	}
	@Test
	public void getColCountConstructerTest() {
		assertEquals(2,block2.getColCount());
	}

	
	@Test
	public void getRowCount() {
		assertEquals(1,block1.getRowCount());
	}
	@Test
	public void getRowCountConstructerTest() {
		assertEquals(2,block2.getRowCount());


	
	@Test
	public void getxPosition() {
		assertEquals(1,block1.getxPosition());
	}
	@Test
	public void getxPositionConstructerTest() {
		assertEquals(2,block2.getxPosition());
	}

	
	@Test
	public void getyPosition() {
		assertEquals(1,block1.getyPosition());
	}
	@Test
	public void getyPositionConstructerTest() {
		assertEquals(2,block2.getyPosition());
	}

	
	@Test
	public void getAngle() {
		assertEquals(180,block1.getAngle());
	}
	@Test
	public void getAngleConstructerTest() {
		assertEquals(180,block2.getAngle());
	}

	
	@Test
	public void getStartingRow() {
		assertEquals('a',block1.getStartingRow());
	}
	@Test
	public void getStartingRowConstructerTest() {
		assertEquals('b',block2.getStartingRow());
	}

	
	@Test
	public void getStartingCol() {
		assertEquals(1,block1.getStartingCol());
	}
	@Test
	public void getStartingColConstructerTest() {
		assertEquals(2,block2.getStartingCol());
	}

	
	@Test
	public void getScreen() {
		assertEquals(1,block1.getScreen().getScreenId());
	}
	

	
	@Test
	public void getSeats() {
		long id = block1.getSeats().get(0).getSeatId();
		assertEquals(1L, id);
	}
	
	
	
}
