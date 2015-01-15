import org.junit.*;
import static org.junit.Assert.*;

import naval.Bateau;

public class BateauTest {

	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(BateauTest.class);
	}

	@Test
	public void getVieTest() {
		Bateau leBateau = new Bateau(3);
		assertEquals("les points de vie du bateau sont-ils valides ?",leBateau.getVie(),3);
	}

	@Test
	public void toucheTest() {
		Bateau leBateau = new Bateau(5);
		leBateau.touche();
		assertEquals("le bateau a-t-il ete touche ?",leBateau.getVie(),4);
	}

}
