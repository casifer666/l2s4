/**
 * Classe permettant de modeliser des disques representes par leur diametre
 * @author Salla Diagne
 */

package hanoi.util;

public class Disque {

	/**
     * le diametre du disque
     */
	private int diametre;

	/**
     * le contructeur pour les objets de la classe Disque
     * @param d = le diametre du disque
	 */
	public Disque(int d) {
		this.diametre = d;
	}

	/**
	 * renvoie le diametre du disque
	 * @return le diametre du disque
	 */
	public int getDiametre() {
		return (this.diametre);
	}

	/**
	 * affiche le disque
	 */
	public void afficheDisque() {
		for (int i = 1 ; i <=  Tour.capacite - this.getDiametre() ; i++) {
			System.out.print(" ");
		}
		for (int i = 1 ; i <= this.getDiametre() ; i++) {
			System.out.print("_");
		}
		System.out.print("|");
		for (int i = 1 ; i <= this.getDiametre() ; i++) {
			System.out.print("_");
		}
		for (int i = 1 ; i <= Tour.capacite - this.getDiametre() ; i++) {
			System.out.print(" ");
		}
	}

}
