import org.junit.*;
import static org.junit.Assert.*;

import naval.Mer;
import naval.Direction;
import naval.DirectionSud;
import naval.Position;
import naval.Bateau;
import naval.Reponse;

public class MerTest {

	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(MerTest.class);
	}

	@Test
	public void viseTest() {
		Mer plateau = new Mer(9,9);
		Position p = new Position(1,1);
		assertEquals("a t-on une reponse valide ?",plateau.vise(p),Reponse.DANS_LEAU);
	}

	@Test
	public void poseBateauTEst() {
		Mer plateau = new Mer(9,9);
		Position p = new Position(1,1);
		Bateau b = new Bateau(2);
		Direction d = new DirectionSud();
		Position p1 = d.positionSuivante(p);
		plateau.poseBateau(b,p,d);
		assertEquals("le bateau est-il bien pose ?",plateau.getPlateau()[p.getX()][p.getY()].getBateau(),b);
		assertEquals("le bateau est-il bien pose ?",plateau.getPlateau()[p1.getX()][p1.getY()].getBateau(),b);
		assertFalse("le bateau est-il bien pose ?",plateau.getPlateau()[d.positionSuivante(p1).getX()][d.positionSuivante(p1).getY()].getBateau() == b);
	}

}
