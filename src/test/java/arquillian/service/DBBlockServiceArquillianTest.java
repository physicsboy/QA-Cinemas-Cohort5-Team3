/**
 * @Author Mark Lester
 */

package arquillian.service;


import static org.junit.Assert.*;

import java.io.File;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
import com.qa.cinema.service.block.BlockService;
import com.qa.cinema.service.block.DBBlockService;
import com.qa.cinema.util.JSONUtil;


 


@RunWith(Arquillian.class)
public class DBBlockServiceArquillianTest {
	
	@Before
	public void setUp() {
	}

	@After
	public void tearDown(){	
	}

	
    @PersistenceContext
    private EntityManager em;
       
    @EJB
    @Named("dbBlockService")
    BlockService service;
   
	
    @Deployment
    public static WebArchive createDeployment() {
    	File[] files = Maven.resolver()
                .loadPomFromFile("pom.xml")
                .importRuntimeDependencies()
                .resolve()
                .withTransitivity()
                .asFile();
        return ShrinkWrap.create(WebArchive.class, "test.war")
        	.addPackage(JSONUtil.class.getPackage())
        	.addPackage(DBBlockService.class.getPackage())
            .addPackage(Block.class.getPackage())
            .addAsResource("wildfly-persistence.xml", "META-INF/persistence.xml")
            .addAsResource("import.sql")
            .addAsWebInfResource("wildfly-ds.xml")
            .addAsWebInfResource(EmptyAsset.INSTANCE, ArchivePaths.create("beans.xml"))
            .addAsLibraries(files);
            		
    }
  
    
//    @Test
//    public final void testGetBlock() throws Exception {
//    	String nulll = "notnull";
//    	if(service != null){
//    		nulll = service.toString();
//    	}
//    	//service.getBlock(1);
//        assertEquals("fail", service.getBlockobj(1));
//    }
    
    
    @Test
    public final void testGetBlockobj() throws Exception {
        assertEquals(3, service.getBlockobj(1).getColCount());
    }
    
//    @Test
//    public final void testGson() throws Exception {
//    	Block b = new Block();
//    	JSONUtil ju = new JSONUtil();
//    	String obj = ju.getJSONForObject(b);
//        assertEquals("[{\"colCount\":0,\"rowCount\":0,\"xPosition\":0,\"yPosition\":0,\"angle\":0,\"startingRow\":\"\u0000\",\"startingCol\":0}]", obj);
//    }
    
    
}
