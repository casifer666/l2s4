import org.junit.*;
import static org.junit.Assert.*;

import hanoi.util.*;

public class TourTest {

	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(TourTest.class);
	}
	
	@Test
	public void tourTest() {
		Tour uneTour = new Tour(3);
		assertEquals ("la tour est-elle bien initialisee ?",uneTour.getNbreDisques(),0);
	}

	@Test
	public void empileTest() {
		Tour uneTour = new Tour (3);
		Disque unDisque = new Disque (10);
		uneTour.empile(unDisque);
		assertEquals("le disque est-il empile dans la tour ?",uneTour.getLaTour()[uneTour.getNbreDisques()-1],unDisque);
	}
	
	@Test
	public void getNbreDisquesTest() {
		Tour uneTour = new Tour(3);
		Disque disque1 = new Disque(10);
		Disque disque2 = new Disque(8);
		uneTour.empile(disque1);
		uneTour.empile(disque2);
		assertEquals ("la tour est-elle bien initialisee ?",uneTour.getNbreDisques(),2);
	}

	@Test
	public void depileTest() {
		Tour uneTour = new Tour (3);
		Disque unDisque = new Disque (10);
		uneTour.empile(unDisque);
		assertEquals("le disque a-t-il ete depile de la tour ?",uneTour.depile(),unDisque);
	}

}

