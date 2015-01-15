import org.junit.*;
import static org.junit.Assert.*;

import image.Pixel;
import image.color.*;

public class PixelTest {

	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(PixelTest.class);
	}

	@Test
	public void getSetColorTest() {
		GrayColor g1 = new GrayColor(127);
		GrayColor g2 = new GrayColor(82);
		Pixel p = new Pixel(g1);
		assertEquals("le pixel a-t-il une couleur valide ?",p.getColor(),g1);
		p.setColor(g2);
		assertEquals("la couleur du pixel a-t-elle ete changee ?",p.getColor(),g2);
	}

	@Test
	public void equalsTest() {
		GrayColor g1 = new GrayColor(127);
		GrayColor g2 = new GrayColor(82);
		//GrayColor g3 = new GrayColor(127);
		String s = new String("Test");
		Pixel p1 = new Pixel(g1);
		Pixel p2 = new Pixel(g2);
		Pixel p3 = new Pixel(g1);
		assertFalse("les deux pixels sont-ils differentes ?",p1.equals(p2));
		assertTrue("les deux pixels sont-ils egaux ?",p1.equals(p3));
		assertFalse("les deux objets sont-ils differents ?",p1.equals(s));
	}

	@Test
	public void colorDifferenceTest() {
		GrayColor g1 = new GrayColor(127);
		GrayColor g2 = new GrayColor(82);
		Pixel p1 = new Pixel(g1);
		Pixel p2 = new Pixel(g2);
		assertEquals("l'ecart de niveaux de gris est-il valide ?",p1.colorDifference(p2),45);
	}

}

