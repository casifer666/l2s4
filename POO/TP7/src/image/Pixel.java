package image;

import image.color.*;

/**
 * Classe permettant de modeliser les pixels d'une image
 */
public class Pixel {

	/**
	 * la couleur du pixel
	 */
	private GrayColor color;

	/**
	 * le constructeur pour les objets de la classe Pixel
	 */
	public Pixel(GrayColor color) {
		this.color = color;
	}

	/**
	 * renvoie la couleur du pixel
	 * @return la couleur du pixel
	 */
	public GrayColor getColor() {
		return (this.color);
	}

	/**
	 * modifie la couleur du pixel
	 * @param newColor = la nouvelle couleur du pixel
	 */
	public void setColor(GrayColor newColor) {
		this.color = newColor;
	}

	/**
	 * teste l'egalite entre deux objets
	 * @param o = l'objet dont on veut tester l'egalite avec le pixel courant
	 * @return <code>true</code> si les deux pixels sont egaux, <code>false</code> sinon
	 */
	public boolean equals(Object o) {
		if (o instanceof Pixel) {
			Pixel p = (Pixel) o;
			return (this.color == p.getColor());
		}
		else {
			return false;
		}
	}

	/**
	 * renvoie l'ecart entre les niveaux de gris des deux pixels
	 * @param p = le pixel dont on veut calculer l'ecart de niveaux de gris avec le pixel courant
	 * @return l'ecart entre les niveaux de gris des deux pixels
	 */
	public int colorDifference(Pixel p) {
		return (Math.abs(this.color.getLevel() - p.getColor().getLevel()));
	}

}

