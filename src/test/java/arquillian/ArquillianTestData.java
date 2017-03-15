/*
 * @Author Mark lester
 */

package arquillian;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import com.qa.cinema.persistence.Screen;


public class ArquillianTestData{
	
	@PersistenceContext
	private EntityManager em;
	    
	@Inject
	private UserTransaction utx;
	
	
	
	public void createTestData(){
		Screen s1 = new Screen("hit");
		Screen s2 = new Screen("me");
		Screen s3 = new Screen("one");
		Screen s4 = new Screen("more");
		
		try {
			utx.begin();
				em.persist(s1);
				em.persist(s2);
				em.persist(s3);
				em.persist(s4);
			utx.commit();
			
			
		} catch (NotSupportedException | SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicMixedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
