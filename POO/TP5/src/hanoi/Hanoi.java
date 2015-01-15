/**
 * Classe permettant d'implementer le probleme des tours de Hanoi
 * @author Salla Diagne
 */

package hanoi;
import hanoi.util.*;
import io.*;

public class Hanoi {
	
	/**
	 * le plateau du jeu (tableau de tours)
	 */
	private Tour[] lesTours;

	/**
	 * le constructeur pour les objets de la classe Hanoi
	 */
	public Hanoi() {
		this.lesTours = new Tour[3];
		Tour tourA = new Tour(Tour.capacite);
		Tour tourB = new Tour(Tour.capacite);
		Tour tourC = new Tour(Tour.capacite);
		for (int i = Tour.capacite ; i >= 1 ; i--) {
			tourA.empile(new Disque(i));
		}
		this.lesTours[0] = tourA;
		this.lesTours[1] = tourB;
		this.lesTours[2] = tourC;
	}

	/**
	 * renvoie le tableau de tours
	 */
	public Tour[] getLesTours() {
		return this.lesTours;
	}

	/**
	 * deplace un disque d'une tour vers une autre
	 * @param tourA = la tour dont on doit depiler un disque et le deplacer vers tourB
	 * @param tourB = la tour dont on doit empiler le disque depile de tourA
	 */
	public void deplacerUnDisque(Tour tourA, Tour tourB) {
		try {
			if (tourA.getNbreDisques() == 0) {
				System.out.println ("Deplacement impossible, la tour de depart est vide");
			}
			else {
				if (tourA.getLaTour()[tourA.getNbreDisques() - 1].getDiametre() >= tourB.getLaTour()[tourB.getNbreDisques() - 1].getDiametre()) {
					System.out.println ("Deplacement impossible, disque au sommet de la tour d'arrivee superieur");
				}
				else {
					if (tourA.getLaTour()[tourA.getNbreDisques() - 1].getDiametre() < tourB.getLaTour()[tourB.getNbreDisques() - 1].getDiametre()) {
						tourB.empile(tourA.depile());
					}
				}
			}
		}
		catch (NullPointerException e) {
			tourB.empile(tourA.depile());
		}
		catch (ArrayIndexOutOfBoundsException e) {
			tourB.empile(tourA.depile());
		}
	}
	
	/**
	 * deplace un certain nombre de disques de la tour initiale vers la tour finale en se servant d'une tour intermediaire
	 * @param n = le nombre de disques a deplacer de tourA vers tourB
     * @param tourA = la tour dont on doit deplacer des disques
	 * @param tourC = la tour finale dont on doit empiler les disques depiles de tourA
	 * @param tourB = la tour intermediaire dont on doit se servir pour les deplacer les disques de tourA vers tourC
	 */
	public void deplacerDesDisques(int n,Tour tourA,Tour tourC,Tour tourB) {
		if (n == 1) {
			deplacerUnDisque(tourA,tourC);
		}
		else {
			deplacerDesDisques(n-1,tourA,tourB,tourC);
			deplacerUnDisque(tourA,tourC);
			deplacerDesDisques(n-1,tourB,tourC,tourA);
		}
	}
	
	/**
	 * resoud le jeu des tours de Hanoi en deplacant les disques de la premiere tour vers la troisieme tour
	 */
	public void resolution() {
		deplacerDesDisques(this.lesTours[0].getNbreDisques(),this.lesTours[0],this.lesTours[2],this.lesTours[1]);
	}

	/**
	 * affiche le plateau
	 */
	public void affichePlateau() {
		for (int i = Tour.capacite - 1 ; i >= 0 ; i--) {
			try {
				this.getLesTours()[0].getLaTour()[i].afficheDisque();
				System.out.print("");
			}
			catch (NullPointerException e) {
				for (int j = 1 ; j <= Tour.capacite ; j++) {
					System.out.print(" ");
				}
				System.out.print("|");
				for (int k = 1 ; k <= Tour.capacite ; k++) {
					System.out.print(" ");
				}
			}
			try {
				this.getLesTours()[1].getLaTour()[i].afficheDisque();
				System.out.print("");
			}
			catch (NullPointerException e) {
				for (int j = 1 ; j <= Tour.capacite ; j++) {
					System.out.print(" ");
				}
				System.out.print("|");
				for (int k = 1 ; k <= Tour.capacite ; k++) {
					System.out.print(" ");
				}
			}
			try {
				this.getLesTours()[2].getLaTour()[i].afficheDisque();
				System.out.print(" ");
			}
			catch (NullPointerException e) {
				for (int j = 1 ; j <= Tour.capacite ; j++) {
					System.out.print(" ");
				}
				System.out.print("|");
				for (int k = 1 ; k <= Tour.capacite ; k++) {
					System.out.print(" ");
				}
			}
			System.out.println("");
		}
		System.out.println("");
	}

	/**
	 * met en place le jeu interactif des tours de Hanoi
	 */
	public void jeuInteractif() {
		HanoiInput input = new HanoiInput();
		boolean id = input.isDeplacement();
		while (id && (this.getLesTours()[2].getNbreDisques() != Tour.capacite)) {
			try {
				input.readInput();
				String commande = new String(input.getDe()+""+input.getVers());
				if (commande.equals("01")) {
					this.deplacerUnDisque(this.getLesTours()[0],this.getLesTours()[1]);
					this.affichePlateau();
				}
				else {
					if (commande.equals("02")) {
						this.deplacerUnDisque(this.getLesTours()[0],this.getLesTours()[2]);
						this.affichePlateau();
					}
					else {
						if (commande.equals("10")) {
							this.deplacerUnDisque(this.getLesTours()[1],this.getLesTours()[0]);
							this.affichePlateau();
						}
						else {
							if (commande.equals("12")) {
								this.deplacerUnDisque(this.getLesTours()[1],this.getLesTours()[2]);
								this.affichePlateau();
							}
							else {
								if (commande.equals("20")) {
									this.deplacerUnDisque(this.getLesTours()[2],this.getLesTours()[0]);
									this.affichePlateau();
								}
								else {
									if (commande.equals("21")) {
										this.deplacerUnDisque(this.getLesTours()[2],this.getLesTours()[1]);
										this.affichePlateau();
									}
								}
							}
						}
					}
		 		}
			}
			catch (IllegalStateException e) {
				id = !id;
			}
		}
		System.out.println("Jeu termine !");
	}

	/**
	 * lance le jeu des tours de Hanoi avec comme unique argument la capacite de chaque tour
	 */
	public static void main(String[] args) {
		Tour.capacite = Integer.parseInt(args[0]);
		Hanoi plateau = new Hanoi();
		plateau.affichePlateau();
		System.out.println("Ceci est une simulation du jeu des tours de Hanoi concue par Salla DIAGNE ");
		System.out.println("(interdit a la copie, a la vente, au pret et au troc, droits d'auteurs oblige). ");
		System.out.println("Le but est de deplacer les disques de la tour de gauche vers celle de droite, ");
		System.out.println("la tour du centre servant d'axe et rendant possible la resolution du jeu. ");
		System.out.println("Les trois tours sont désignées respectivement par les lettres : ");
		System.out.println("g qui represente la tour de gauche , c qui represente la tour du centre, ");
		System.out.println("et d qui represente la tour de droite. Pour effectuer un deplacement, il faut ");
		System.out.println("taper le mot de deux lettres correspondant aux tours de depart et d'arrivee. ");
		System.out.println("Par exemple en tapant cd, on deplace le disque au sommet de la tour du centre ");
		System.out.println("sur la tour de droite si possible. Quitter en tapant la commande quit.\n");
		plateau.jeuInteractif();
	}

}
