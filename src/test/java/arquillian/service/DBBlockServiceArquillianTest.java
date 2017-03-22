/**
 * @Author Mark Lester
 */

package arquillian.service;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.qa.cinema.persistence.Block;
import com.qa.cinema.persistence.Seat;
import com.qa.cinema.persistence.ticket.Ticket;
import com.qa.cinema.service.block.BlockService;
import com.qa.cinema.service.block.DBBlockService;
import com.qa.cinema.util.JSONUtil;

@RunWith(Arquillian.class)
public class DBBlockServiceArquillianTest {
	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}
	@PersistenceContext
	private EntityManager em;
	@Inject
	UserTransaction utx;
	@EJB
	@Named("dbBlockService")
	BlockService service;
	@Inject
	private JSONUtil util;

	@Deployment
	public static WebArchive createDeployment() {
		File[] files = Maven.resolver().loadPomFromFile("pom.xml").importRuntimeDependencies().resolve().withTransitivity().asFile();
		return ShrinkWrap.create(WebArchive.class, "test.war").addPackage(Ticket.class.getPackage()).addPackage(JSONUtil.class.getPackage()).addPackage(DBBlockService.class.getPackage()).addPackage(Block.class.getPackage()).addAsResource("wildfly-persistence.xml", "META-INF/persistence.xml").addAsResource("import.sql").addAsWebInfResource("wildfly-ds.xml").addAsWebInfResource(EmptyAsset.INSTANCE, ArchivePaths.create("beans.xml")).addAsLibraries(files);
	}

	@Test
	public final void getBlockobj() throws Exception {
		assertEquals(8, service.getBlockobj(1).getColCount());
	}

	@Test
	public final void getBlock() throws Exception {
		assertEquals(3506, service.getBlock(1).length());
	}

	@Test
	public final void getAllBlocks() {
		String s = service.getAllBlocks(1);
		boolean stringHasContent = false;
		if (s != null) {
			stringHasContent = true;
		}
		assertEquals(true, stringHasContent);
	}

	@Test
	public final void addBlockCheckMaxRowMaxCol() throws Exception {
		utx.begin();
		service.addBlock("{\"colCount\":5," + "\"rowCount\":5," + "\"xPosition\":1," + "\"yPosition\":1," + "\"angle\":34," + "\"startingRow\":\"a\"," + "\"startingCol\":1}");
		List<Seat> seats = em.find(Block.class, 11L).getSeats();
		boolean isCorrect = false;
		char row = 'a';
		int col = 1;
		for (Seat s : seats) {
			if (col < s.getColumn()) {
				col = s.getColumn();
			}
			if (row < s.getRow()) {
				row = s.getRow();
			}
		}
		utx.commit();
		if (col == 5 && row == 'e') {
			isCorrect = true;
		}
		assertEquals(true, isCorrect);
	}

	@Test
	public final void deleteBlock() throws Exception {
		utx.begin();
		boolean isNull = false;
		long blockId = 7L;
		service.deleteBlock(blockId);
		if(em.find(Block.class, blockId) == null){
			isNull = true;
		}
		assertEquals(true, isNull);
	}

	
	
	
	
	
	
	
	
	

	@Test
	public final void increaseStatingCol() throws Exception {
		utx.begin();
		Long blockId = 4L;
		
		StringBuilder message = new StringBuilder();
		service.increaseStartingCol(blockId, 3);
		List<Seat> seats = em.find(Block.class, blockId).getSeats();
		for (Seat s: seats){
			message.append(s.getColumn());
		}
		utx.commit();
		
		assertEquals("34563456", message.toString());
	}
	
	@Test
	public final void decreaseStartingCol() throws Exception {
		utx.begin();
		Long blockId = 5L;
		
		StringBuilder message = new StringBuilder();
		service.decreaseStatingCol(blockId, 1) ;
		List<Seat> seats = em.find(Block.class, blockId).getSeats();
		for (Seat s: seats){
			message.append(s.getColumn());
		}
		utx.commit();
		
		assertEquals("34123412", message.toString());
	}

	@Test
	public final void increaseStartingRow() throws Exception {
		utx.begin();
		Long blockId = 4L;
		
		StringBuilder message = new StringBuilder();
		service.increaseStartingRow(blockId, 'D') ;
		List<Seat> seats = em.find(Block.class, blockId).getSeats();
		for (Seat s: seats){
			message.append(s.getRow());
		}
		utx.commit();
		
		assertEquals("DDDDEEEE", message.toString());
	}
	
	@Test
	public final void decreaseStartingRow() throws Exception {
		utx.begin();
		Long blockId = 5L;
		
		StringBuilder message = new StringBuilder();
		service.decreaseStartingRow(blockId, 'B') ;
		List<Seat> seats = em.find(Block.class, blockId).getSeats();
		for (Seat s: seats){
			message.append(s.getRow());
		}
		utx.commit();
		
		assertEquals("BBBBCCCC", message.toString());
	}

	

	
	
	
	
	
	
	
	@Test
	public final void updateBlock() throws Exception {
		utx.begin();
			boolean isCorrect = false;
			Long blockId = 4L;
			service.updateBlock(blockId, 3,3,3);
			Block block = em.find(Block.class, blockId);
			if(block.getAngle() == 3){
				isCorrect = true;
			}
			if(block.getxPosition() == 3){
				isCorrect = true;	
			}
			if(block.getyPosition() == 3){
				isCorrect = true;
			}
		utx.commit();
		assertEquals(true, isCorrect);
	}

	
}
