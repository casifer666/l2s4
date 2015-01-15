import org.junit.*;
import static org.junit.Assert.*;

import calculette.operateur.*;

public class OperateurTest {

	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(OperateurTest.class);
	}
	
	@Test
	public void PlusTest() {
		Operateur plus = new Plus();
		int a = 8; int b = 3; int c = a + b;
		assertEquals("l'addition est-elle correcte ?", plus.eval(a,b), c);
	}

	@Test
	public void MoinsTest() {
		Operateur moins = new Moins();
		int a = 8; int b = 3; int c = a - b;
		assertEquals("la soustraction est-elle correcte ?", moins.eval(a,b), c);
	}

	@Test
	public void MultTest() {
		Operateur mult = new Mult();
		int a = 8; int b = 3; int c = a * b;
		assertEquals("la multiplication est-elle correcte ?", mult.eval(a,b), c);
	}

	@Test
	public void DivTest() {
		Operateur div = new Div();
		int a = 8; int b = 3; int c = a / b;
		assertEquals("la division est-elle correcte ?", div.eval(a,b), c);
	}

}
