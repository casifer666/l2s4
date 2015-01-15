/**
 * la classe des caisses
 *  Dans cette version simple elles sont de differents poids, mais on ne distingue
 * 	pas les instances autrement
 * 
 * @author jc 
 */

package exemple.util;

public class Caisse {	

    /**
     * constructeurs d'objets de la classe Caisse
     * @param poids : le poids de la caisse
     */
    public Caisse(int poids) {
	this.poids = poids;
    }
    
    // les attributs de la classe Caisse
    /**
     * les attributs de la classe Caisse 
     * @param poids = le poids de la caisse
     */
    private int poids;
    
    // les methodes de la classe Caisse	
    /**
     * retourne le poids de la caisse
     * @return le poids de la caisse
     */
    public int donnePoids() {
	return this.poids;
    }
    
    /**
     * affiche les informations sur la caisse
     * @return les informations sur la caisse
     */
    public String toString() {
	return "caisse de poids "+ this.poids;
    }
}
