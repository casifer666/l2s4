package agence;

/**
 * Classe permettant de representer un critere de prix pour une voiture
 */
public class CriterePrix implements Critere {

	/**
	 * le prix
	 */
    private int prix;

    /**
     * le constructeur pour les objets de la classe CriterePrix
     */
    public CriterePrix(int prix) {
		this.prix = prix;
    }

    /**
     * teste la satisfaisabilite d'une voiture au critere
     * @param v la voiture dont on teste la satisfaisabilite avec le critere
     * @return <code>true</code> si <code>v</code> satisfait le critere, <code>false</code> sinon
     */
    public boolean estSatisfaitPar(Voiture v) {
		return this.prix > v.getPrix();
    }

}
