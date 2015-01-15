import org.junit.*;
import static org.junit.Assert.*;

import agence.Voiture;

public class VoitureTest {

	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(VoitureTest.class);
	}

	@Test
	public void getTest() {
		Voiture v = new Voiture("Trueno","86",1998,71);
		assertEquals("la marque de la voiture est-elle valide ?",v.getMarque(),"Trueno");
		assertEquals("le modele de la voiture est-il valide ?",v.getModele(),"86");
		assertEquals("l'annee de la voiture est-elle valide ?",v.getAnnee(),1998);
		assertEquals("le prix de la voiture est-il valide ?",v.getPrix(),71);
	}

	@Test
	public void equalsTest() {
		Voiture v1 = new Voiture("Trueno","86",1998,71);
		Voiture v2 = new Voiture("86","Trueno",2002,69);
		Voiture v3 = new Voiture("Trueno","86",1998,71);
		String s = new String("VoitureTest");
		assertFalse("les deux objets sont-ils egaux ?",v1.equals(v2));
		assertTrue("les deux objets sont-ils egaux ?",v1.equals(v3));
		assertFalse("les deux objets sont-ils egaux ?",v1.equals(s));
	}

}