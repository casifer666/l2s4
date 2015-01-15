package agence;

/**
 * Classe permettant de representer un critere de marque pour une voiture
 */
public class CritereMarque implements Critere {

	/**
	 * la marque
	 */
    private String marque;

    /**
     * le constructeur pour les objets de la classe CritereMarque
     */
    public CritereMarque(String marque) {
		this.marque = marque;
    }

    /**
     * teste la satisfaisabilite d'une voiture au critere
     * @param v la voiture dont on teste la satisfaisabilite avec le critere
     * @return <code>true</code> si <code>v</code> satisfait le critere, <code>false</code> sinon
     */
    public boolean estSatisfaitPar(Voiture v) {
		return this.marque.equals(v.getMarque());
    }

}
