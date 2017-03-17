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

import com.qa.cinema.persistence.Block;
 


@RunWith(Arquillian.class)
public class SeatArquillianTest {
	
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
            .addPackage(Block.class.getPackage())
            .addAsResource("wildfly-persistence.xml", "META-INF/persistence.xml")
            .addAsResource("import.sql")
            .addAsWebInfResource("wildfly-ds.xml")
            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }
    
    @Test
    public final void testGetBlockId() throws Exception {
    	long id = em.find(Block.class, 3L).getBlockId();
        assertEquals(3L, id);
    }
    
    @Test
    public final void testColCount() throws Exception {
        assertEquals(3, em.find(Block.class, 3L).getColCount());
    }
    
    @Test
    public final void testRowCount() throws Exception {
        assertEquals(5, em.find(Block.class, 3L).getRowCount());
    }

    @Test
    public final void testGetxPosition() throws Exception {
        assertEquals(5, em.find(Block.class, 3L).getxPosition());
    }
	
    @Test
    public final void testGetyPosition() throws Exception {
        assertEquals(1, em.find(Block.class, 3L).getyPosition());
    }
    
    @Test
    public final void testGetAngle() throws Exception {
        assertEquals(34, em.find(Block.class, 3L).getAngle());
    }
    
    @Test
    public final void testGetStartingRow() throws Exception {
        assertEquals(53, em.find(Block.class, 3L).getStartingRow());
    }
	
    @Test
    public final void testGetStartingCol() throws Exception {
        assertEquals(6, em.find(Block.class, 3L).getStartingCol());
    }
    
    @Test
    public final void testGetSeats() throws Exception {
        assertEquals(3, em.find(Block.class, 2L).getSeats().size());
    }
    
//    @Test
//    public final void testGetScreen() throws Exception {
//        assertEquals(1, em.find(Block.class, 3L).getScreen().getScreenId());
//    }
	
	
    
    
}
