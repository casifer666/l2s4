
/**
 * Classe permettant la modelisation des stocks et leur gestion
 * 
 * @author Salla Diagne
 * @version 01/02/13
 */
public class Stock {
    // les attributs de la classe Stock
    /**
     * @param quantite = la quantite en stock
     */
    private int quantite;
    
    // les constructeurs pour les objets de la classe Stock
    /**
     * constructeur pour les objets de la classe Stock avec une quantite initiallement nulle
     */
    public Stock () {
        this.quantite = 0;
    }
    
    /**
     * constructeur pour les objets de la classe Stock avec une quantite passee en parametre lors de l'initialisation
     */
    public Stock (int quantite) {
        this.quantite = quantite;
    }

    // les methodes de la classe Stock
    /**
     * consulte le stock
     * @return la quantite en stock
     */
    public int getQuantite () {
        return this.quantite;
    }
    
    /**
     * augmente la quantite en stock
     * @param la quantite a ajouter au stock
     */
    public void ajoute (int ajout) {
        if (ajout > 0) {
            this.quantite = this.quantite + ajout;
        }
        else {
            System.out.println ("la quantite a ajouter au stock doit etre positive !");
        }
    }
    
    /**
     * diminue la quantite en stock
     * @param la quantite a retirer du stock
     * @return la quantite retiree du stock
     */
    public int retire (int retrait) {
        if (retrait < this.quantite) {
            this.quantite = this.quantite - retrait;
            return retrait;
        }
        else {
            int resultat = this.quantite;
            this.quantite = 0;
            return resultat;
        }
    }
    
    /**
     * renvoie l'etat de la quantite en stock
     * @return l'etat de la quantite en stock
     */
    public String toString () {
        return ("la quantite en stock est de "+this.quantite);
    }
}
