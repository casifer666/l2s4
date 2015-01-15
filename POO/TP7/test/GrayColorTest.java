import org.junit.*;
import static org.junit.Assert.*;

import image.color.GrayColor;

public class GrayColorTest {

	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(GrayColorTest.class);
	}

	@Test
	public void getLevelTest() {
		GrayColor g = new GrayColor(127);
		assertEquals("le niveau de gris est-il valide ?",g.getLevel(),127);
	}

	@Test
	public void equalsTest() {
		GrayColor g1 = new GrayColor(127);
		GrayColor g2 = new GrayColor(82);
		GrayColor g3 = new GrayColor(127);
		String s = new String("Test");
		assertFalse("les deux couleurs sont-elles differentes ?",g1.equals(g2));
		assertTrue("les deux couleurs sont-elles egales ?",g1.equals(g3));
		assertFalse("les deux objets sont-ils differents ?",g1.equals(s));
	}

}
