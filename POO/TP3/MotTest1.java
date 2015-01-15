import org.junit.*;
import static org.junit.Assert.*;

public class MotTest1 {
    

    @Test
    public void testEquals(){
	Mot mot1 = new Mot("bonjour");
	Mot mot2 = new Mot("bonjour");
	Object o = new Object();

	assertTrue(mot1.equals(mot2));
	assertFalse(mot1.equals(o));
    }

 


    // ---Pour permettre l'execution des test----------------------
    public static junit.framework.Test suite() {
	return new junit.framework.JUnit4TestAdapter(MotTest1.class);
    }

}

