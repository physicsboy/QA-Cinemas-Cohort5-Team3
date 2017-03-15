/**
 * Mark Lester
 */

package arquillian;


import static org.junit.Assert.*;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.qa.cinema.persistence.Screen;
 


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
            .addClass(ArquillianTestData.class)
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
    
      
   
   
    
    
}
