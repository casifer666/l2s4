import org.junit.*;
import static org.junit.Assert.*;

import ppc.util.Coup;

public class CoupTest {

	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(CoupTest.class);
	}

	@Test
	public void compareCoupsTest() {
		Coup coup1 = Coup.pierre;
		Coup coup2 = Coup.papier;
		Coup coup3 = Coup.ciseaux;
		Coup coup4 = Coup.ciseaux;
		assertEquals("le papier bat-il la pierre ?",coup1.compareCoups(coup2),-1);
		assertEquals("la pierre bat-il les ciseaux ?",coup1.compareCoups(coup3),1);
		assertEquals("les ciseaux battent-ils le papier ?",coup2.compareCoups(coup3),-1);
		assertEquals("les ciseaux sont-ils egaux eux-memes ?",coup3.compareCoups(coup4),0);
	}

}
