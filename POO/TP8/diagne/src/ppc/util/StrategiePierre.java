package ppc.util;

/**
 * Classe permettant de representer une strategie consistant a toujours jouer pierre dans le jeu de pierre-papier-ciseaux
 */
public class StrategiePierre implements Strategie {

	/**
	 * permet de toujours jouer pierre
	 * @return pierre
	 */
	public Coup coupAJouer() {
		return Coup.pierre;
	}

}
