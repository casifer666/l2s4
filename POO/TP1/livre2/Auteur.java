   
/**
 * (Documentation should be in english...)
 * Les informations sur un auteur de <i>Livre</i>
 * 
 * @author JC
 * @version 1.0
 */
 

public class Auteur {
	/**
	 * Constructor for objects of class Auteur
	 */
	public Auteur(String nom, String prenom, int naissance) {
		this.nom = nom;
		this.prenom = prenom;
		this.naissance = naissance;
	}

	// les attributs de la classe Auteur
	private String nom;
	private String prenom;
	private int naissance;
	private int deces;
	
	//les methodes de la classe Auteur

	/** affiche les informations sur l'auteur
	*/
	public void affiche() {
		System.out.println(this.prenom+" "+this.nom+" ne en "+this.naissance);
	}
	/** met a jour la date de deces
	*@param deces la date de deces de l'auteur
	*/
	public void fixeDeces(int deces) {
		this.deces = deces;
	}
}
