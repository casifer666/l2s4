package ppc.util;

import java.util.Random;

/**
 * Classe permettant de representant une strategie consistant a jouer un coup aleatoire dans le jeu de pierre-papier-ciseaux
 */
public class StrategieAleatoire implements Strategie {

	/**
	 * permet de jouer aleatoirement un coup
	 * @return un coup aleatoire
	 */
	public Coup coupAJouer() {
		return Coup.values()[(new Random()).nextInt(3)];
	}

}
