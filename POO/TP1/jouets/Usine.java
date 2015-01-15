 
/**
 * (Documentation should be in english...)
 * la classe Usine définit des fabriques de jouets
 * 
 * @author jc 
 * @version 1.0
 */ 
 

public class Usine {
    // constructeurs de la classe Usine
    public Usine() {
	this.marque = "generique";
    }
    public Usine(String marque) {
        this.marque = marque;
    }
    
    // les attributs de la classe Usine
    /** la marque des jouets de l'usine
     * par defaut  la marque est "generique"
     */ 
    private String marque;
    
    // les methodes de la classe Usine
    /** fabrique un nouveau jouet de la marque
     * @return le nouveau jouet fabrique
     */
    public Jouet fabrique() {
        // creation d'un nouvel objet
        Jouet jouet = new Jouet(marque);
        // on a la reference on peut donc acceder a son interface publique
        jouet.affiche();
        // on peut renvoyer la reference de l'objet
        return jouet;
    }
}
