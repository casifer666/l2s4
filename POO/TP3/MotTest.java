import org.junit.*;
import static org.junit.Assert.*;

public class MotTest {
    
    @Test
    public void testEquals(){
	Mot mot1 = new Mot("bonjour");
	Mot mot2 = new Mot("bonjour");
	Object o = new Object();

	assertTrue("sont egaux ? ",mot1.equals(mot2));
	assertFalse("ne sont pas egaux ? ",mot1.equals(o));
    }


    @Test
    public void testLongueur(){
	Mot mot = new Mot("bonjour");
	assertEquals("est-ce la bonne longueur ?",mot.longueur(),7);
    }


    @Test
    public void testNbOccurencesOfChar() {
	Mot mot1 = new Mot("abracadabra");
	assertEquals("occurrences de caractere ?",mot1.nbOccurrencesOfChar('a'),5);
	assertEquals("occurrences de caractere ?",mot1.nbOccurrencesOfChar('z'),0);
    }


    @Test
    public void testInverse() {
	Mot mot1 = new Mot("abcde");
	Mot mot2 = new Mot("edcba");
	assertEquals("Inverses l'un de l'autre ?",mot1.inverse(),mot2);
    }


    @Test
    public void testContient() {
	Mot mot1 = new Mot("timoleon");
	Mot mot2 = new Mot("tim");
	Mot mot3 = new Mot("mole");
	Mot mot4 = new Mot("leon");
	Mot mot5 = new Mot("truc");
	Mot mot6 = new Mot("molee");
	
	assertTrue("contient ?" , mot1.contient(mot2));
	assertTrue("contient ?" , mot1.contient(mot3));
	assertTrue("contient ?" , mot1.contient(mot4));
	assertFalse("ne contient pas ?" , mot1.contient(mot5));
	assertFalse("ne contient pas ?" , mot1.contient(mot6));
    }


    @Test
    public void testRimeAvec() {
	Mot mot1 = new Mot("timoleon");
	Mot mot2 = new Mot("tim");
	Mot mot3 = new Mot("leon");
	Mot mot4 = new Mot("ti");
	Mot mot5 = new Mot("ti");

	assertTrue("rime avec ?" , mot1.rimeAvec(mot3));
	assertFalse("ne rime pas avec ?" , mot1.rimeAvec(mot2));	
	assertFalse("ne rime pas avec : trop court ?" , mot4.rimeAvec(mot5));	
    }


    @Test
    public void testExtraitAvant() {
	Mot mot1 = new Mot("timoleon");

	Mot[] extrait1 = mot1.extraitAvant('o');
	Mot[] extrait2 = mot1.extraitAvant('t');
	Mot[] extrait3 = mot1.extraitAvant('n');
	Mot[] extrait4 = mot1.extraitAvant('z');

	assertEquals("extrait avant",extrait1[0],new Mot("timo"));
	assertEquals("extrait avant",extrait1[1],new Mot("leon"));

	assertEquals("extrait avant",extrait2[0],new Mot("t"));
	assertEquals("extrait avant",extrait2[1],new Mot("imoleon"));

	assertEquals("extrait avant",extrait3[0],new Mot("timoleon"));
	assertEquals("extrait avant",extrait3[1],new Mot(""));

	assertEquals("extrait avant",extrait4[0],new Mot(""));
	assertEquals("extrait avant",extrait4[1],new Mot("timoleon"));
    }


    @Test
    public void testEstPalindrome() {
	Mot mot1 = new Mot("radar");
	Mot mot2 = new Mot("raddar");
	Mot mot3 = new Mot("probleme");

	assertTrue("palindrome ?",mot1.estPalindrome());
	assertTrue("palindrome ?",mot2.estPalindrome());
	assertFalse("pas palindrome ?",mot3.estPalindrome());
    }


    @Test
    public void testEstAnagramme() {
	Mot mot1 = new Mot("timoleon");
	Mot mot2 = new Mot("letomion");
	Mot mot3 = new Mot("letmion");
	Mot mot4 = new Mot("letmionoo");

	assertTrue("anagramme ?" , mot1.estAnagramme(mot2));
	assertFalse("pas anagramme ?" , mot1.estAnagramme(mot3));	
	assertFalse("pas anagramme ?" , mot3.estAnagramme(mot1));	
	assertFalse("pas anagramme ?" , mot1.estAnagramme(mot4));	
    }

    @Test
    public void testEstNomPropre() {
	Mot mot1 = new Mot("Timoleon");
	Mot mot2 = new Mot("timoleon");

	assertTrue("nom propre ?" , mot1.estNomPropre());
	assertFalse("pas nom propre ?" , mot2.estNomPropre());	
    }
 



    // ---Pour permettre l'execution des test----------------------
    public static junit.framework.Test suite() {
	return new junit.framework.JUnit4TestAdapter(MotTest.class);
    }

}

