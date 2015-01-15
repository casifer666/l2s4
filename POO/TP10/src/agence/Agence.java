package agence;

import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import java.util.MissingResourceException;

/**
 * Classe permettant de reprensenter une agence de location de voitures
 */
public class Agence {

    /**
     * la liste des voitures de l'agence
     */
    private List<Voiture> voitures;

    /**
     * la table des locations (client => voiture)
     */
    private Map<Client,Voiture> lesLocations;

    /**
     * le constructeur pour les objets de la classe Agence
     */
    public Agence() {
        this.voitures = new ArrayList<Voiture>();
        this.lesLocations = new HashMap<Client,Voiture>();
    }

    /**
     * ajoute une voiture a l'agence
     * @param v la voiture a ajouter a l'agence
     */
    public void ajouteVoiture(Voiture v) {
        this.voitures.add(v);
    }

    /**
     * renvoie la liste des voitures de l'agence
     * @return la liste des voitures de l'agence
     */
    public List<Voiture> lesVoitures() {
        return this.voitures;
    }

    /**
     * renvoie la liste des voitures qui satisfont le critere <code>c</code>
     * @param c le critere a satisfaire
     * @return la liste des voitures qui satisfont <code>c</code>
     */
    public List<Voiture> selectionne(Critere c) {	
        List<Voiture> selection = new LinkedList<Voiture>();
        for (int i = 0 ; i < this.voitures.size() ; i++) {
            Voiture v = this.voitures.get(i);
            if (c.estSatisfaitPar(v))
                selection.add(v);
        }
        return selection;
    }

    /**
     * affiche les voitures qui satisfont le critere <code>c</code>
     * @param c le critere a satisfaire
     */
    public void afficheSelection(Critere c) {
        Iterator<Voiture> it = this.selectionne(c).iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    /**
     * permet au client <code>c</code> de louer la voiture <code>v</code>
     * @param client le client loueur
     * @param v la voiture a louer
     */
    public void loueVoiture(Client client, Voiture v) throws MissingResourceException {
        if (!this.voitures.contains(v) || this.lesLocations.containsValue(v))
            throw new MissingResourceException("La voiture n'existe pas dans l'agence ou est deja louee",v.getClass().getName(),client.toString());
        else
            this.lesLocations.put(client,v);
    }

	/**
     * teste si le client <code>client</code> loue actuellement une voiture
     * @param client le client dont on teste s'il loue une voiture ou non
     * @return <code>true</code> si <code>client</code> loue une voiture, <code>false</code> sinon
     */
    public boolean estLoueur(Client client){
        return this.lesLocations.containsKey(client);
    }
    
    /**
     * teste si la voiture <code>v</code> est louee actuellement
     * @param v la voiture dont on teste si elle est louee ou non
     * @return <code>true</code> si <code>v</code> est louee, <code>false</code> sinon
     */
    public boolean estLoue(Voiture v){
        return this.lesLocations.containsValue(v);
    }
    
    /**
     * rend la voiture louee par le client <code>client</code>
     * @param client le client qui rend la voiture qu'il a louee
     */
    public void rendVoiture(Client client){
	   this.lesLocations.remove(client);
    }
    
    /**
     * renvoie la collection des voitures louees
     * @return la collection des voitures louees
     */
    public Collection<Voiture> lesVoituresLouees(){
        return this.lesLocations.values();
    }

}
