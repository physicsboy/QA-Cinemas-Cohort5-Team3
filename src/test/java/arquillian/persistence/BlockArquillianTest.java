/**
 * @Author Mark Lester
 */

package arquillian.persistence;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.transaction.Transaction;
import javax.transaction.UserTransaction;

import org.hibernate.Hibernate;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.qa.cinema.persistence.Block;
import com.qa.cinema.persistence.Seat;
import com.qa.cinema.persistence.ticket.Ticket;
import com.qa.cinema.service.block.DBBlockService;

@RunWith(Arquillian.class)
public class BlockArquillianTest {
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

	@Deployment
	public static WebArchive createDeployment() {
		return ShrinkWrap.create(WebArchive.class, "test.war").addPackage(Ticket.class.getPackage()).addPackage(Block.class.getPackage()).addAsResource("wildfly-persistence.xml", "META-INF/persistence.xml").addAsResource("import.sql").addAsWebInfResource("wildfly-ds.xml").addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
	}

	@Test
	public final void testGetBlockId() throws Exception {
		long id = em.find(Block.class, 3L).getBlockId();
		assertEquals(3L, id);
	}

	@Test
	public final void testColCount() throws Exception {
		assertEquals(8, em.find(Block.class, 3L).getColCount());
	}

	@Test
	public final void testRowCount() throws Exception {
		assertEquals(8, em.find(Block.class, 3L).getRowCount());
	}

	@Test
	public final void testGetxPosition() throws Exception {
		assertEquals(1, em.find(Block.class, 4L).getxPosition());
	}

	@Test
	public final void testGetyPosition() throws Exception {
		assertEquals(1, em.find(Block.class, 3L).getyPosition());
	}

	@Test
	public final void testGetAngle() throws Exception {
		assertEquals(180, em.find(Block.class, 3L).getAngle());
	}

	@Test
	public final void testGetStartingRow() throws Exception {
		assertEquals('I', em.find(Block.class, 3L).getStartingRow());
	}

	@Test
	public final void testGetStartingCol() throws Exception {
		assertEquals(1, em.find(Block.class, 3L).getStartingCol());
	}

	@Test
	public final void testGetSeats() throws Exception {

		utx.begin();
			List<Seat> seats = em.getReference(Block.class, 3L).getSeats();
			int size = seats.size();
		utx.commit();
		
		assertEquals(64, size);
	}
	

	

}
