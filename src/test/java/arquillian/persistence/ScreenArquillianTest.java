/**
 * @Author Mark Lester
 */

package arquillian.persistence;


import static org.junit.Assert.*;

import java.util.List;

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
import com.qa.cinema.persistence.Screen;
import com.qa.cinema.persistence.ticket.Ticket;
 


@RunWith(Arquillian.class)
public class ScreenArquillianTest {
	
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
            .addPackage(Screen.class.getPackage())
            .addPackage(Ticket.class.getPackage())
            .addAsResource("wildfly-persistence.xml", "META-INF/persistence.xml")
            .addAsResource("import.sql")
            .addAsWebInfResource("wildfly-ds.xml")
            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }
  
    
    
    @Test
    public final void testGetURL() throws Exception {
    	Screen screen;
    	screen = em.find(Screen.class, 3);
        assertEquals("lol", screen.getURL());
    }
    
    @Test
    public final void testGetId() throws Exception {
    	Screen screen;
    	screen = em.find(Screen.class, 3);
        assertEquals(3, screen.getScreenId());
    }
    
    @Test
    public final void testGetBlocks() throws Exception {
    	int size = em.find(Screen.class, 3).getBlocks().size();
    	List<Block> blocks = em.find(Screen.class, 3).getBlocks();
    	int x = 0;
    	for (Block b : blocks){
    		System.out.println( x++ + "BLOCK ID ========= " + b.getBlockId());
    		
    	}
    	
        assertEquals(2, size);
    }

    
}
