/**
 * @Author Mark Lester
 */

package arquillian.persistence;


import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.qa.cinema.persistence.Seat;
import com.qa.cinema.persistence.ticket.Ticket;
 


@RunWith(Arquillian.class)
public class BlockArquillianTest {
	
	@Before
	public void setUp() {
	}

	@After
	public void tearDown(){	
	}

	
    @PersistenceContext
    private EntityManager em;
 
	
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
        	.addPackage(Ticket.class.getPackage())
            .addPackage(Seat.class.getPackage())
            .addAsResource("wildfly-persistence.xml", "META-INF/persistence.xml")
            .addAsResource("import.sql")
            .addAsWebInfResource("wildfly-ds.xml")
            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }
    
    @Test
    public final void testGetSeatId() throws Exception {
    	long id = em.find(Seat.class, 3L).getSeatId();
        assertEquals(3L, id);
    }
    
    @Test
    public final void testType() throws Exception {
        assertEquals(Seat.SeatType.LUXURY, em.find(Seat.class, 3L).getType());
    }

    @Test
    public final void testGetRow() throws Exception {
    	assertEquals('a', em.find(Seat.class, 3L).getRow());
    }
	
    @Test
    public final void testGetColumn() throws Exception {
    	assertEquals(2, em.find(Seat.class, 3L).getColumn());
    }
    
	
	
    
    
}
