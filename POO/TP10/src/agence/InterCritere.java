package agence;
import java.util.List;
import java.util.ArrayList;

/**
 * Classe permettant de representer une liste de criteres pour les voitures
 */
public class InterCritere implements Critere {
    
    /**
     * la liste des criteres
     */
    private List<Critere> lesCriteres;

    /**
     * le constructeur pour les objets de la classes InterCritere
     */
    public InterCritere() {
	   this.lesCriteres = new ArrayList<Critere>();
    }

    /**
     * ajoute un critere a la liste
     * @param c le critere a ajouter
     */
    public void addCritere(Critere c) {
	   lesCriteres.add(c);
    }

    /**
     * teste la satisfaisabilite d'une voiture avec tous les criteres de la liste
     * @param v la voiture dont on teste la satisfaisabilite avec tous les criteres de la liste
     */
    public boolean estSatisfaitPar(Voiture v) {
        for (int i = 0 ; i < this.lesCriteres.size() ; i++) {
            if (!this.lesCriteres.get(i).estSatisfaitPar(v))
                return false;
        }
        return true;
    }

}
