import org.junit.*;
import static org.junit.Assert.*;

import naval.Position;

public class PositionTest {

	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(PositionTest.class);
	}

	@Test
	public void coordonneesTest() {
		Position laPosition = new Position(1,-1);
		assertEquals("la position a-t-elle une abscisse valide ?",laPosition.getX(),1);
		assertEquals("la position a-t-elle une ordonnee valide ?",laPosition.getY(),-1);
	}

	@Test
	public void equalsTest() {
		Position position1 = new Position(1,2);
		Position position2 = new Position(1,2);
		assertTrue("les deux positions sont-elles egales ?",position1.equals(position2));
	}

}

