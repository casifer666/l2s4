package ppc.util;

/**
 * Classe representant une enumeration qui liste l'ensemble des coups possibles dans le jeu de pierre-papier-ciseaux
 */
public enum Coup {

	pierre,
	papier,
	ciseaux;

	/**
	 * compare deux coups
	 * @param c le coup a comparer avec this
	 * @return <code>1</code> si this bat <code>c</code>, -1 si <code>c</code> bat this, 0 si this et <code>c</code> sont egaux
	 */
	public int compareCoups(Coup c) {
		if (this == c) {
			return 0;
		}
		else {
			switch (this) {
				case pierre : if (c == papier) { return -1; } else { return 1; }
				case papier : if (c == pierre) { return 1; } else { return -1; }
				default : if (c == pierre) { return -1; } else { return 1; }
			}
		}
	}

}
