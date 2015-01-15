/**
 * Classe permettant de modeliser des tours de capacite fixe sous la forme d'un tableau de disques et sur lesquelles sont empiles des disques
 * @author Salla Diagne
 */

package hanoi.util;

public class Tour {

	/**
	 * le nombre de disques contenus dans la tour
	 */
	private int nbreDisques;

	/** 
	 * la capacite de la tour (le nombre maximum de disques qu'elle peut contenir)
	 */
	public static int capacite;

	/**
	 *le tableau des disques contenus dans la tour
	 */
	private Disque[] laTour;

	/**
     * le constructeur pour les objets de la classe Tour
     * @param c = la capacite de la tour
     */
	public Tour(int c) {
		this.nbreDisques = 0;
		capacite = c;
		this.laTour = new Disque[c];
	}

	/**
	 * renvoie le nombre de disques dans la tour
     * @return le nombre de disques dans la tour
     */
	public int getNbreDisques() {
		return (this.nbreDisques);
	}

	/**
	 * renvoie la tour (le tableau de disques)
	 * @return la tour
     */
	public Disque[] getLaTour() {
		return (this.laTour);
	}

	/**
	 * renvoie le disque au sommet de la tour
	 * @return le disque au sommet de la tour
	 */
	public Disque disqueAuSommet() {
		return this.laTour[this.nbreDisques - 1];
	}

	/**
	 * empile un disque dans la tour
     * @param d = le disque a empiler
     */
	public void empile(Disque d) {
		if (this.nbreDisques < this.capacite) {
			this.laTour[this.nbreDisques] = d;
			this.nbreDisques ++;
		}
	}

	/**
	 * depile un disque de la tour
	 * @return le disque depile de la tour
	 */
	public Disque depile() {
		if (this.nbreDisques > 0) {
			Disque d = this.laTour[this.nbreDisques - 1];
			this.laTour[nbreDisques - 1] = null;
			this.nbreDisques --;
			return d;
		}
		else {
			return null;
		}
	}

}
