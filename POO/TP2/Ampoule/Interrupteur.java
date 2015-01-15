
/**
 * Classe permettant de modeliser des interrupteurs electriques pour l'allumage et l'extinction d'une ampoule donnee
 * 
 * @author Salla Diagne
 * @version 01/02/13
 */
public class Interrupteur {
    // les attributs de la classe Interrupteur
    /**
     * @param ampoule = l'ampoule controlee par l'interrupteur
     */
    private Ampoule ampoule;
    
    // le constructeur pour les objets de la classe Interrupteur
    /**
     * constructeur pour les objets de la classe Interrupteur
     */
    public Interrupteur (Ampoule ampoule) {
        this.ampoule = ampoule;
    }
    
    // les methodes de la classe Interrupteur
    /**
     * appuie sur l'interrupteur
     */
    public void appuiInterrupteur () {
        if (this.ampoule.getEtat()) {
            this.ampoule.eteint();
        }
        else {
            this.ampoule.allume();
        }
    }
    
    /**
     * renvoie l'etat de l'ampoule controlee par l'interrupteur
     * @return l'etat de l'ampoule controlee par l'interrupteur
     */
    public String toString () {
        if (this.ampoule.getEtat()) {
            return ("cet interrupteur controle une ampoule allumee.");
        }
        else {
            return ("cet interrupteur controle une ampoule eteinte.");
        }
    }
}
