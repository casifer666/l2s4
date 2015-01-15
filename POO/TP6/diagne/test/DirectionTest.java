import org.junit.*;
import static org.junit.Assert.*;

import naval.Position;
import naval.Direction;
import naval.DirectionNord;
import naval.DirectionEst;
import naval.DirectionOuest;
import naval.DirectionSud;

public class DirectionTest {
	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(DirectionTest.class);
	}

	@Test
	public void DirectionNordTest() {
		Direction d = new DirectionNord();
		Position p1 = new Position(1,2);
		Position p2 = new Position(0,2);
		assertEquals("la direction nord est-elle valide ?",d.positionSuivante(p1).getX(),p2.getX());
		assertEquals("la direction nord est-elle valide ?",d.positionSuivante(p1).getY(),p2.getY());
	}

	@Test
	public void DirectionEstTest() {
		Direction d = new DirectionEst();
		Position p1 = new Position(1,2);
		Position p2 = new Position(1,3);
		assertEquals("la direction nord est-elle valide ?",d.positionSuivante(p1).getX(),p2.getX());
		assertEquals("la direction nord est-elle valide ?",d.positionSuivante(p1).getY(),p2.getY());
	}

	@Test
	public void DirectionOuestTest() {
		Direction d = new DirectionOuest();
		Position p1 = new Position(1,2);
		Position p2 = new Position(1,1);
		assertEquals("la direction nord est-elle valide ?",d.positionSuivante(p1).getX(),p2.getX());
		assertEquals("la direction nord est-elle valide ?",d.positionSuivante(p1).getY(),p2.getY());
	}

	@Test
	public void DirectionSudTest() {
		Direction d = new DirectionSud();
		Position p1 = new Position(1,2);
		Position p2 = new Position(2,2);
		assertEquals("la direction nord est-elle valide ?",d.positionSuivante(p1).getX(),p2.getX());
		assertEquals("la direction nord est-elle valide ?",d.positionSuivante(p1).getY(),p2.getY());
	}

}