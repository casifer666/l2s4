import org.junit.*;
import static org.junit.Assert.*;

import ppc.util.*;

public class JoueurTest {

	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(JoueurTest.class);
	}

	@Test
	public void scoreTest() {
		Joueur unJoueur = new Joueur("Test");
		unJoueur.ajoutePoints(2);
		assertEquals("le score du joueur est-il correct ?",unJoueur.getScore(),2);
	}

	@Test
	public void compareScoresTest() {
		Joueur joueur1 = new Joueur("Test");
		Joueur joueur2 = new Joueur("Test");
		Joueur joueur3 = new Joueur("Test");
		Joueur joueur4 = new Joueur("Test");
		joueur1.ajoutePoints(2);
		joueur2.ajoutePoints(3);
		joueur3.ajoutePoints(1);
		joueur4.ajoutePoints(3);
		assertEquals("le score du joueur 1 est-il inferieur a celui du joueur 1 ?",joueur1.compareScores(joueur2),-1);
		assertEquals("le score du joueur 1 est-il superieur a celui du joueur 3 ?",joueur1.compareScores(joueur3),1);
		assertEquals("le score du joueur 2 est-il egal a celui du joueur 4 ?",joueur2.compareScores(joueur4),0);
	}

	@Test
	public void joueUnCoupTest() {
		Joueur joueur1 = new Joueur("Test",new StrategiePierre());
		Joueur joueur2 = new Joueur("Test",new StrategiePapier());
		assertEquals("le joueur joue t-il toujours pierre ?",joueur1.joueUnCoup(),Coup.pierre);
		assertEquals("le joueur joue t-il toujours papier ?",joueur2.joueUnCoup(),Coup.papier);
	}

}
