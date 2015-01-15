 


/**
 * (Documentation should be in english...)
 * la classe des TapisRoulant sur lesquels pn peut poser les caisses jusqu'un certain poids
 * les tapis ont une (meme) capacite maximale definie par <t>capcacite</t>
 * @author jc 
 * @version 1.0
 */

// parce que l'on utilise des listes (sera vu plus tard)
import java.util.*;

public class TapisRoulant {

    private int capacite = 2;

    // les attributs de la classe TapisRoulant
    /** le poids maximum des caisses supporte */
    private int poidsMax;
    /** le tapis proprement dit : les caisses portees */
    private ArrayList<Caisse> tapis;   // on utilise une liste de caisses pour gerer le tapis

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
    public int donnePoidsMax() { return this.poidsMax; }
    
    /** la tapis recoit une caisse 
     * @param caisse la caisse recue
     */
    public void recoit(Caisse caisse) {
        if (!this.estPlein()) {
            this.tapis.add(caisse);
        }
        else {          // pas de gestion d'exception pour l'instant
            System.out.println("tapis plein, impossible de deposer");
        }
    }
    /** indique si le tapis est plein
     * @return <t>true</t> si le tapis est plein de caisses
     */
    public boolean estPlein() {
        return this.tapis.size() == capacite;
    }
    /** verifie si le tapis peut accepter la caisse, ie. si elle n'est pas trop lourde
     * @param caisse : la caisse a verifier
     * @return <t>true</t> si la caisse peut etre portee, <t>false</t> sinon
     */
    public boolean accepte(Caisse caisse) {
        return caisse.donnePoids() <= this.poidsMax;
    }
    /** affiche le contenu du tapis roulant
     */
    public void affiche() {
        System.out.println("le tapis porte "+this.tapis.size()+" caisse(s)");
        for (Caisse caisse : this.tapis) {
            System.out.println(caisse.toString());
        }                   
    }
    /** vide le tapis roulant (supprime toutes les caisses)
     */
    public void videTapis() {
	// ce code sera explique plus tard dans le cours
        Iterator<Caisse> lesCaisses_it = this.tapis.iterator();
        while(lesCaisses_it.hasNext()) {
            lesCaisses_it.next();
            lesCaisses_it.remove();
        }
    }
}
