package ppc.util;

/**
 * Classe permettant de representer une strategie consistant a toujours jouer papier dans le jeu de pierre-papier-ciseaux
 */
public class StrategiePapier implements Strategie {

	/**
	 * permet de toujours jouer papier
	 * @return pierre
	 */
	public Coup coupAJouer() {
		return Coup.papier;
	}

}
