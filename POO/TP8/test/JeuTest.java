import org.junit.*;
import static org.junit.Assert.*;

import ppc.*;
import ppc.util.*;

public class JeuTest {

	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(JeuTest.class);
	}

	@Test
	public void readCoupTest() {
		Jeu unJeu = new Jeu(10);
		assertEquals("le coup est-il bien lu ?",unJeu.readCoup("pierre"),Coup.pierre);
		assertEquals("le coup est-il bien lu ?",unJeu.readCoup("papier"),Coup.papier);
		assertEquals("le coup est-il bien lu ?",unJeu.readCoup("ciseaux"),Coup.ciseaux);
		assertEquals("le coup est-il bien lu ?",unJeu.readCoup("test"),null);
	}

}
		
	

