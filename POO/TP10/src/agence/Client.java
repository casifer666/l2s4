package agence;

/**
 * Classe permettant de representer un client
 */
public class Client {

	/**
	 * le nom du client
	 */
	private String nom;

	/**
	 * le constructeur pour les objets de la classe Client
	 * @param nom le nom du client
	 */
	public Client(String nom) {
		this.nom = nom;
	}

	/**
	 * affiche les informations sur les attributs du client
	 * @return les informations sur les attributs du client
	 */
	public String toString() {
		return this.nom;
	}

	/**
	 * renvoie le hashCode du client
	 * @return le hashCode du client
	 */
	public int hashCode() {
		return this.nom.hashCode();
	}

}