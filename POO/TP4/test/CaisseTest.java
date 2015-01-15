import org.junit.*;
import static org.junit.Assert.*;

import exemple.util.Caisse;

public class CaisseTest {	

    @Test
    public void creationCaisse() {
	Caisse uneCaisse = new Caisse(10);
	assertNotNull("construction caisse ?", uneCaisse);
    }
    
    @Test
    public void donnePoids() {
	Caisse uneCaisse = new Caisse(10);
	assertEquals("poids valide ? ",uneCaisse.donnePoids(),10);
    }



    // ---Pour permettre l'execution des test----------------------
    public static junit.framework.Test suite() {
	return new junit.framework.JUnit4TestAdapter(CaisseTest.class);
    }

}
