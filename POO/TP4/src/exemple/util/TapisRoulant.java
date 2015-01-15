/**
 * la classe des TapisRoulant sur lesquels pn peut poser les caisses jusqu'un certain poids
 * les tapis ont une (meme) capacite maximale definie par <tt>tailleMax</tt>
 * @author jc 
 */

package exemple.util;

import java.util.*; // pour permettre l'utilisation des classes de ce paquetage,
                    // comme ArrayList<T>

public class TapisRoulant {

	static final private int capacite = 2;

    // les attributs de la classe TapisRoulant
	/** le poids maximum des caisses supportees */
	private int poidsMax;
	/** le tapis proprement dit : les caisses portees */
	private ArrayList<Caisse> tapis;


    /**
     * constructeurs d'objets de la classe TapisRoulant
     */
    public TapisRoulant(int poidsMax) {
		this.poidsMax = poidsMax;
		this.tapis = new ArrayList<Caisse>();
    }
	
	
    // les methodes de la classe TapisRoulant
    /** donne le poids maximal accepte
     * @return le pods maximal accepte
     */
    public int donnePoidsMax() { 
	return poidsMax;
}
    
    /** la tapis recoit une caisse 
     * @param caisse la caisse recue
     */
    public void recoit(Caisse caisse) {
	if (!this.estPlein()) {
	    this.tapis.add(caisse);
	}
	else { 			// pas de gestion d'exception pour l'instant
	    System.out.println("tapis plein, impossible de deposer");
	}
    }
    /** indique si le tapis est plein
     * @return <tt>true</tt> si le tapis est plein de caisses
     */
    public boolean estPlein() {
	return this.tapis.size() == this.capacite;
    }

    /** verifie si le tapis peut accepter la caisse, ie. si elle n'est pas trop lourde
     * @param caisse : la caisse a verifier
     */
    public boolean accepte(Caisse caisse) {
	return caisse.donnePoids() <= this.poidsMax;
    }
    /** affiche le contenu du tapis roulant
     */
    public void affiche() {
	System.out.println("le tapis porte "+tapis.size()+" caisse(s)");
	for (Caisse caisse : this.tapis) {
	    System.out.println(caisse.toString());
	}					
    }
    /** vide le tapis
     */
    public void videTapis() {
	this.tapis.clear();
    }
}
