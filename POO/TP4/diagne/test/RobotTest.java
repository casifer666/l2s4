import org.junit.*;
import static org.junit.Assert.*;

import exemple.util.*;
import exemple.Robot;

public class RobotTest {

	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(RobotTest.class);
	}

	@Test
	public void prendTest() {
		Robot Robbie = new Robot();
		assertNull("le robot porte-t-il une caisse valide ?",Robbie.getCaisseTenue());
		Caisse uneCaisse = new Caisse(15);
		Robbie.prend(uneCaisse);
		assertEquals("le robot porte-t-il une caisse valide ?",Robbie.getCaisseTenue(),uneCaisse);
	}

	@Test
	public void porteCaisseTest() {
		Robot Robbie = new Robot();
		assertFalse("le robot porte-t-il une caisse ?",Robbie.porteCaisse());
		Caisse uneCaisse = new Caisse(10);
		Robbie.prend(uneCaisse);
		assertTrue("le robot porte-t-il une caisse ?",Robbie.porteCaisse());
	}

	@Test
	public void poseSurTest() {
		Robot Robbie = new Robot();
		Caisse CaisseValide = new Caisse(10);
		Caisse CaisseInvalide = new Caisse(15);
		TapisRoulant leTapis = new TapisRoulant(12);
		Robbie.prend(CaisseValide);
		Robbie.poseSur(leTapis);
		assertFalse("le robot porte-t-il une caisse apres en avoir depose une ?",Robbie.porteCaisse());
		Robbie.prend(CaisseInvalide);
		Robbie.poseSur(leTapis);
		assertTrue("le robot porte-t-il une caisse apres en avoir depose une ?",Robbie.porteCaisse());
	}

}

