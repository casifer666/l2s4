
/**
 * Classe permettant de modeliser des ampoules
 * 
 * @author Salla Diagne
 * @version 01/02/13
 */
import java.awt.*;

public class Ampoule {
    // les attributs de la classe Ampoule
    /**
     * @param puissance = la puissance de l'ampoule
     * @param couleur = la couleur de l'ampoule
     * @param etat = l'etat de l'ampoule (allumee ou eteinte)
     */
    private int puissance;
    private static Color couleur;
    private boolean etat;
    
    // les constructeurs pour les objets de la classe Ampoule
    /**
     * constructeur pour les objets de la classe Ampoule sans initialisation des attributs
     */
    public Ampoule () {
        this.puissance = 60;
        this.couleur = Color.WHITE;
        this.etat = false;
    }
    
    /**
     * constructeur pour les objets de la classe Ampoule sans initialisation des attributs
     */
    public Ampoule (int puissance, Color couleur, boolean etat) {
        this.puissance = puissance;
        this.couleur = couleur;
        this.etat = etat;
    }
    
    // les methodes de la classe Ampoule
    /**
     * retourne la puissance de l'ampoule
     * @return la puissance de l'ampoule
     */
    public int getPuissance () {
        return (this.puissance);
    }
    
    /**
     * modifie la puissance de l'ampoule
     * @param la nouvelle puissance de l'ampoule
     */
    public void setPuissance (int newPuissance) {
        this.puissance = newPuissance;
    }
    
    /**
     * retourne la couleur de l'ampoule
     * @return la couleur de l'ampoule
     */
    public Color getCouleur () {
        return (this.couleur);
    }
    
    /**
     * modifie la couleur de l'ampoule
     * @param la nouvelle couleur de l'ampoule
     */
    public void setCouleur (Color newCouleur) {
        this.couleur = newCouleur;
    }
    
    /**
     * retourne l'etat de l'ampoule
     * @return l'etat de l'ampoule
     */
    public boolean getEtat () {
        return (this.etat);
    }
    
    /**
     * allume l'ampoule
     */
    public void allume () {
        this.etat = true;
    }
    
    /**
     * eteint l'ampoule
     */
    public void eteint () {
        this.etat = false;
    }
    
    /**
     * affiche l'etat de l'ampoule
     * @return l'etat de l'ampoule
     */
    public String toString () {
        if (this.etat) {
            return ("ampoule allumee.");
        }
        else {
            return ("ampoule eteinte.");
        }
    }
}
