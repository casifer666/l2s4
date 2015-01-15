package naval;

/**
 * Classe permettant de representer la position d'une case dans la mer
 */
public class Position {

	/**
	 * l'abscisse de la position
	 */
	private int x;

	/**
	 * l'ordonnee de la position
	 */
	private int y;

	/**
	 * le constructeur pour les objets de la classe Position
	 */
	public Position(int x,int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * renvoie l'abscisse de la position
	 * @return l'abscisse de la position
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * renvoie l'ordonnee de la position
	 * @return l'ordonnee de la position
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * affiche les informations sur les attributs de la position
	 * @return les informations sur les attributs de la position
	 */
	public String toString() {
			return ("cette position est d'abscisse "+this.x+" et d'ordonnee "+this.y);
	}

	/**
	 * teste l'egalite entre deux positions
	 * @param p = la position dont on doit tester l'egalite avec la position courante
	 */
	public boolean equals(Position p) {
		return ((this.x == p.getX()) && (this.y == p.getY()));
	}

}
