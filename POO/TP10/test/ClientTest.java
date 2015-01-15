import org.junit.*;
import static org.junit.Assert.*;

import agence.Client;

public class ClientTest {

	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(ClientTest.class);
	}

	@Test
	public void nomTest() {
		Client client1 = new Client("Takumi");
		assertEquals("le nom du client est-il valide ?",client1.toString(),"Takumi");
	}

	@Test
	public void hashCodeTest() {
		Client client1 = new Client("Takumi");
		Client client2 = new Client("Takumi");
		Client client3 = new Client("Itsuki");
		assertTrue("les hashCode des deux clients sont-ils egaux ?",client1.hashCode()==client2.hashCode());
		assertFalse("les hashCode des deux clients sont-ils differents ?",client1.hashCode()==client3.hashCode());
	}

}