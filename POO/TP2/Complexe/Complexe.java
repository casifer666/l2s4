
/**
 * Classe permettant de modeliser des nombres complexes
 * 
 * @author Salla Diagne
 * @version 01/02/13
 */
public class Complexe {
    // les attributs de la classe Complexe
    /**
     * @param a = la partie reelle du complexe
     * @param b = la partie imaginaire du complexe
     */
    private float a;
    private float b;
    
    // le constructeur pour les objets de la classe Complexe
    /**
     * constructeur pour les objets de la classe Complexe
     */
    public Complexe (float a, float b) {
        this.a = a;
        this.b = b;
    }
    
    // les methodes de la classe Complexe
    /**
     * renvoie le conjugue du complexe
     * @return le conjugue du complexe
     */
    public Complexe conjugue () {
        return new Complexe (this.a,-this.b);
    }
    
        /**
     * teste si l'entier est reel ou non
     * @return vrai si l'entier est reel, faux sinon
     */
    public boolean estReel () {
       return (this.b == 0);
    }
    
    /**
     * renvoie la partie reelle
     * @return la partie reelle
     */
    public float partieReelle () {
        return (this.a);
    }
    
    /**
     * renvoie la partie imaginaire
     * retourne la partie imaginaire
     */
    public float partieImaginaire () {
        return (this.b);
    }
    
    /**
     * calcule le module
     * @return le module
     */
    public double module () {
        double x = this.a;
        double y = this.b;
        return (Math.hypot (x,y));
    }
    
    /**
     * calcule la somme de deux complexes
     * @param un complexe qu'on veut ajouter a notre objet
     * @return la somme des deux nombres complexes
     */
    public Complexe add (Complexe c) {
        return new Complexe ((a+(c.partieReelle())),b+(c.partieImaginaire()));
    }
    
    /**
     * calcule le produit de deux complexes
     * @param un complexe qu'on veut multiplier a notre objet
     * @return le produit des deux nombres complexes
     */
    public Complexe mul (Complexe c) {
        return new Complexe (((this.a*(c.partieReelle())) - (this.b*(c.partieImaginaire()))),((this.a*(c.partieImaginaire())) + (this.b*(c.partieReelle()))));
    }
    
    /**
     * teste l'egalite de deux complexes
     * @param un autre complexe dont on veut tester l'egalite avec notre objet
     * @return vrai si les deux complexes sont egaux, faux sinon
     */
    public boolean equals (Complexe c) {
        return ((this.a == c.partieReelle()) && (this.b == c.partieImaginaire()));
    }
    
    /**
     * affiche les informations sur le complexe
     * @return les informations sur le complexe
     */
    public String toString () {
        return ("Ce nombre complexe est de partie reelle "+a+" et de partie imaginaire "+b);
    }
}
