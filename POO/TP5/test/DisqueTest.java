import org.junit.*;
import static org.junit.Assert.*;

import hanoi.util.Disque;

public class DisqueTest {

	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(DisqueTest.class);
	}

	@Test
	public void diametreTest () {
		Disque unDisque = new Disque (10);
		assertEquals("est-ce que le disque a un diametre valide ?", unDisque.getDiametre(), 10);
	}

}

