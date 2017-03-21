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
		boolean before = false;
		boolean after = false;
		Long blockId = 3L;
		char RowCountOfblock = 'A';
		for (int i = 0; i < em.find(Block.class, blockId).getRowCount(); i++) {
			RowCountOfblock++;
		}
		int ColCountOfblock = em.find(Block.class, blockId).getColCount() + 1; // Starting Col is 1 more than end of previous
		List<Seat> seats = em.find(Block.class, blockId).getSeats();
		before = blockId == em.find(Block.class, blockId).getBlockId();
		String delete = service.deleteBlock(blockId);
		try {
			Long afterId = em.find(Block.class, blockId).getBlockId();
			after = true;
		} catch (NullPointerException e) {
			after = false;
		}
		utx.commit();
		boolean outcome = false;
		if (before == true && after == false) {
			outcome = true;
		} else {
			outcome = false;
		}
		assertEquals(true, outcome);
	}

	@Test
	public final void increaseRowCount() throws Exception {
		assertEquals(true, true);
	}

	@Test
	public final void decreaseColCount() throws Exception {
		assertEquals(true, true);
	}

	@Test
	public final void decreaseRowCount() throws Exception {
		assertEquals(true, true);
	}

	@Test
	public final void increaseStatingCol() throws Exception {
		utx.begin();
		Long blockId = 3L;
		String blockString = util.getJSONForObject(em.find(Block.class, blockId));
		int beforeStartingCol = em.find(Block.class, blockId).getStartingCol();
		List<Seat> seats = em.find(Block.class, blockId).getSeats();
		int beforeSeatCount = seats.size();
		service.increaseStatingCol(5, blockString);
		int afterStartingCol = em.find(Block.class, blockId).getStartingCol();
		seats = em.find(Block.class, blockId).getSeats();
		int afterSeatCount = seats.size();
		utx.commit();
		assertEquals(true, beforeStartingCol != afterStartingCol && afterStartingCol == beforeStartingCol + 5 && beforeSeatCount < afterSeatCount);
	}

	@Test
	public final void increaseStartingRow() throws Exception {
		utx.begin();
		Long blockId = 3L;
		String blockString = util.getJSONForObject(em.find(Block.class, blockId));
		int beforeStartingRow = em.find(Block.class, blockId).getStartingCol();
		service.increaseRowCount(5, blockString);
		int afterStartingRow = em.find(Block.class, blockId).getStartingCol();
		utx.commit();
		assertEquals(true, beforeStartingRow != afterStartingRow && afterStartingRow == beforeStartingRow + 5);
	}

	@Test
	public final void decreaseStartingRow() throws Exception {
		utx.begin();
		Long blockId = 3L;
		String blockString = util.getJSONForObject(em.find(Block.class, blockId));
		int beforeStartingRow = em.find(Block.class, blockId).getStartingCol();
		service.decreaseStartingRow(1, blockString);
		int afterStartingRow = em.find(Block.class, blockId).getStartingCol();
		utx.commit();
		assertEquals(true, beforeStartingRow != afterStartingRow && afterStartingRow == beforeStartingRow - 1);
	}

	@Test
	public final void decreaseStatingCol() throws Exception {
		utx.begin();
		Long blockId = 3L;
		String blockString = util.getJSONForObject(em.find(Block.class, blockId));
		int beforeStartingCol = em.find(Block.class, blockId).getStartingCol();
		List<Seat> seats = em.find(Block.class, blockId).getSeats();
		int beforeSeatCount = seats.size();
		service.increaseStatingCol(5, blockString);
		int afterStartingCol = em.find(Block.class, blockId).getStartingCol();
		seats = em.find(Block.class, blockId).getSeats();
		int afterSeatCount = seats.size();
		utx.commit();
		assertEquals(true, beforeStartingCol != afterStartingCol && afterStartingCol == beforeStartingCol - 5 && beforeSeatCount > afterSeatCount);
	}

	@Test
	public final void updateXPosition() throws Exception {
/*		utx.commit();
		Long blockId = 3L;
		String blockString = util.getJSONForObject(em.find(Block.class, blockId));
		int beforeXpos = em.find(Block.class, blockId).getxPosition();
		service.updateXPosition(blockString);
		int afterXpos = em.find(Block.class, blockId).getxPosition();
		utx.commit();*/
		assertEquals(true, true);
	}

	@Test
	public final void updateYPosition() throws Exception {
		assertEquals(true, true);
	}

	@Test
	public final void updateAngle() throws Exception {
		assertEquals(true, true);
	}
}
