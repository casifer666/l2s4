
/**
 * (Documentation should be in english...)
 * une collection de livres
 * 
 * @author JC
 * @version 1.0
 */
 

import java.util.*;

/**
 * Pour simplifier dans cet exemple introductif, les livres sont stockes dans un tableau.
 */
public class Bibliotheque {
    // definition d'une constante pour le nombre max de livres
    private int NB_LIVRES_MAX = 10;

    // les attributs de la classe Livre	
    /** le tableau de livres */
    private Livre[] lesLivres;
    /** le nombre de livres actuellemet dans la bibliotheque */
    private int nbLivres;
	
    /**
     * Constructor for objects of class Bibliotheque
     */
    public Bibliotheque() {
	this.lesLivres = new Livre[NB_LIVRES_MAX];
	this.nbLivres = 0;
    }


    // les methodes de la classe Livre
	
    /** ajoute un livre a la bibliotheque si il y a de la place, sinon rien ne se passe
     * @param livre le livre a ajouter
     */
    public void ajouteLivre(Livre livre) {
	if (nbLivres < lesLivres.length) {
	    this.lesLivres[nbLivres] = livre;
	    nbLivres = nbLivres +1;
	}
    }
    /** affiche la liste des livres 
     */
    public void afficheLivres() {
	int cpt = 0; 
	while (cpt < this.nbLivres) {
	    this.lesLivres[cpt].affiche();
	    cpt = cpt + 1;
	}
    }
    /** retourne le nombre de livres de la bibliotheques
     * @return le  nombre de livres de la bibliotheques
     */
    public int nombreDeLivres() {
	return this.nbLivres;
    }	

}
