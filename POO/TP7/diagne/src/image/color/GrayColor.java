package image.color;

/**
 * Classe permettant de representer les couleurs d'une image
 */
public class GrayColor {

	/**
	 * le niveau de gris
	 */
	private int level;

	/**
	 * couleur dont le niveau de gris est minimal (couleur noire)
	 */
	public static final GrayColor BLACK = new GrayColor(0);

		/**
	 * couleur dont le niveau de gris est maximal (couleur blanche)
	 */
	public static final GrayColor WHITE = new GrayColor(255);

	/**
	 * le contructeur pour les objets de la classe GrayColor
	 * @param level = le niveau de gris
	 */
	public GrayColor(int level) {
		this.level = level;
	}

	/**
	 * renvoie le niveau de gris de la couleur
	 * @return le niveau de gris de la couleur
	 */
	public int getLevel() {
		return (this.level);
	}

	/**
	 * teste l'egalite entre deux objets
	 * @param o = l'objet dont on doit tester l'egalite avec la couleur courante
	 * @return <code>true</code> si les deux couleurs sont egales, <code>false</code> sinon
	 */
	public boolean equals(Object o) {
		if (o instanceof GrayColor) {
			GrayColor color = (GrayColor) o;
			return (this.level == color.getLevel());
		}
		else {
			return false;
		}
	}

}

