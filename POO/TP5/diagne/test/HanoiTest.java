import org.junit.*;
import static org.junit.Assert.*;

import hanoi.Hanoi;
import hanoi.util.*;

public class HanoiTest {

	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(HanoiTest.class);
	}

	@Test
	public void deplacerUnDisqueTest() {
		Hanoi lePlateau = new Hanoi ();
		Tour tourA = new Tour(10);
		Tour tourB = new Tour(10);
		tourA.empile(new Disque(15));
		tourB.empile(new Disque(20));
		int nbreDisquesA = tourA.getNbreDisques();
		int nbreDisquesB = tourB.getNbreDisques();
		lePlateau.deplacerUnDisque(tourA,tourB);
		assertEquals("le disque a-t-il ete depile ?",tourA.getNbreDisques(),nbreDisquesA - 1);
		assertEquals("le disque a-t-il ete empile ?",tourB.getNbreDisques(),nbreDisquesB + 1);
	}

	@Test
	public void resolutionTest() {
		Hanoi lePlateau = new Hanoi ();
		Tour tourA = new Tour(3);
		Tour tourB = new Tour(3);
		Tour tourC = new Tour(3);
		tourA.empile(new Disque(15));
		tourA.empile(new Disque(10));
		tourA.empile(new Disque(5));
		lePlateau.deplacerDesDisques(3,tourA,tourC,tourB);
		assertEquals("tous les disques ont-ils ete depiles de A ?",tourA.getNbreDisques(),0);
		assertEquals("tous les disques ont-ils ete depiles de B ?",tourB.getNbreDisques(),0);
		assertEquals("tous les disques ont-ils ete deplaces sur C ?",tourC.getNbreDisques(),3);
	}

}

