
/**
 * (Documentation should be in english...)
 * la classe Jouet definit ... des jouets
 * 
 * @author jc 
 * @version 1.0
 */
 

public class Jouet {
    // constructeurs d'objets de la classe Jouet
    public Jouet(String marque) {
        this.marque = marque;
    }
    
    // les attributs de la classe Jouet
    /** la marque du jouet */
    private String marque;
    
    // les methodes de la classe Jouet
    public void affiche() {
        System.out.println("je suis un jouet de la marque "+this.marque);
    }
}
