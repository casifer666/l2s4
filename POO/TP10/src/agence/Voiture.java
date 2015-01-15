package agence;

/**
 * Classe permettant de representer une voiture
 */
public class Voiture {

	/**
	 * la marque de la voiture
	 */
    private String marque;

    /**
     * le modele de la voiture
     */
    private String modele;

    /**
     * l'annee de production de la voiture
     */
    private int annee;

    /**
     * le prix de la voiture
     */
    private int prix;

    /**
     * le constructeur pour les objets de la classe Voiture
     * @param marque la marque de la voiture
     * @param modele le modele de la voiture
     * @param annee l'annee de production de la voiture
     * @param prix le prix de la voiture
     */
    public Voiture(String marque, String modele, int annee, int prix) {
		this.marque = marque;
		this.modele = modele;
		this.annee = annee;
		this.prix = prix;
    }

    /**
     * renvoie la marque de la voiture
     * @return la marque de la voiture
     */
    public String getMarque() {
		return this.marque;
    }

    /**
     * renvoie le modele de la voiture
     * @return le modele de la voiture
     */
    public String getModele() {
		return this.modele;
    }

    /**
     * renvoie l'annee de production de la voiture
     * @return l'annee de production de la voiture
     */
    public int getAnnee() {
		return this.annee;
    }

    /**
     * renvoie le prix de la voiture
     * @return le prix de la voiture
     */
    public int getPrix() {
		return this.prix;
    }

    /**
     * teste l'egalite de la voiture avec un autre objet
     * @param o l'objet dont on teste l'egalite avec la voiture
     * @return <code>true</code> si les deux objets sont egaux, <code>false</code> sinon
     */
    public boolean equals(Object o) {
		if (o instanceof Voiture) {
		    Voiture lAutre = ((Voiture) o);
		    return this.marque.equals(lAutre.marque)
			&& this.modele.equals(lAutre.modele)
			&& this.annee == lAutre.annee 
			&& this.prix == lAutre.prix;
		}
		else {
		    return false;
		}
    }

    /**
     * renvoie les informations sur les attributs de la voiture
     * @return les informations sur les attributs de la voiture
     */
    public String toString() {
		return this.annee + " " + this.marque + " " + this.prix;
    }

}
