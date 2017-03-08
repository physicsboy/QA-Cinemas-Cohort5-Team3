import static org.junit.Assert.*;

import org.junit.Test;

import com.qa.cinema.persistence.Showing;
public class ShowingTest {

	@Test
	public void test() {
		
		Showing showing = new Showing("09-04-2017 11:35:00");
		
		assertNotNull(showing);
		
		equals(showing == new Showing("09-04-2017 11:35:00"));
		
	}

}
