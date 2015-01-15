package ppc.util;

/**
 * Classe representant un joueur dans le jeu de pierre-papier-ciseaux
 */
public class Joueur {

	/**
	 * le nom du joueur
	 */
	private String nom;

	/**
	 * le nombre de points du joueur
	 */
	private int score;

	/**
	 * la strategie qu'adopte le joueur
	 */
	private Strategie strategie;
	
	/**
	 * un constructeur pour les objets de la classe Joueur
	 * @param nom le nom du joueur
	 */
	public Joueur (String nom) {
		this.nom = nom;
		this.score = 0;
	}

	/**
	 * un autre constructeur pour les objets de la classe Joueur
	 * @param nom le nom du joueur
	 * @param strategie la strategie qu'adopte le joueur
	 */
	public Joueur (String nom, Strategie strategie) {
		this.nom = nom;
		this.score = 0;
		this.strategie = strategie;
	}

	/**
	 * renvoie le score du joueur
	 * @return le score du joueur
	 */
	public int getScore() {
		return this.score;
	}

	/**
	 * renvoie le nom du joueur
	 * @return le nom du joueur
	 */
	public String toString() {
		return this.nom;
	}

	/**
	 * compare deux scores
	 * @param j le joueur dont le score doit etre compare au score de this
	 * @return <code>1</code> si this.score > <code>j</code>.score, <code>-1</code> si <code>j</code>.score > this.score, <code>0</code> si this.score et <code>j</code>.score sont egaux
	 */
	public int compareScores(Joueur j) {
		if (this.score == j.score) {
			return 0;
		}
		else {
			if (this.score > j.score) {
				return 1;
			}
			else {
				return -1;	
			}
		}
	}
 
	/**
	 * incremente le score du joueur
	 * @param p le nombre de points a ajouter au score
	 */
	public void ajoutePoints(int p) {
		this.score += p;
	}

	/**
	 * joue un coup
	 * @return le coup joue
	 */
	public Coup joueUnCoup() {
		return this.strategie.coupAJouer();
	}

}

