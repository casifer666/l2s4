package ppc.util;

/**
 * Interface permettant de representer une strategie a adopter dans le jeu de pierre-papier-ciseaux
 */
public interface Strategie {

	/**
	 * choisit un coup selon la strategie a adopter
	 * @return le coup a jouer
	 */
	public Coup coupAJouer();

}

