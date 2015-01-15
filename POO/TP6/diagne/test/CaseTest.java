import org.junit.*;
import static org.junit.Assert.*;

import naval.Case;
import naval.Bateau;

public class CaseTest {

	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(CaseTest.class);
	}

	@Test
	public void getSetBateauTest() {
		Case laCase = new Case();
		Bateau leBateau = new Bateau(3);
		assertNull("le bateau a-t-il ete pose sur la case ?",laCase.getBateau());
		laCase.setBateau(leBateau);
		assertEquals("le bateau a-t-il ete pose sur la case ?",laCase.getBateau(),leBateau);
	}

	@Test
	public void viseeTest() {
		Case laCase = new Case();
		assertFalse("la case a-t-elle ete visee ?",laCase.aEteVisee());
		laCase.vise();
		assertTrue("la case a-t-elle ete visee ?",laCase.aEteVisee());
	}

	@Test
	public void getCaractereTest() {
		Case laCase = new Case();
		Bateau leBateau = new Bateau(3);
		assertSame("le caractere est-il correct ?",laCase.getCaractere(true),'~');
		laCase.setBateau(leBateau);
		assertSame("le caractere est-il correct ?",laCase.getCaractere(true),'B');
		assertSame("le caractere est-il correct ?",laCase.getCaractere(false),'.');
	}

}
