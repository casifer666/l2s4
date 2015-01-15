package ppc;

import ppc.util.*;

/**
 * Classe permettant de representer le jeu de pierre-papier-ciseaux
 */
public class Jeu {

	/**
	 * le nombre de tours
	 */
	private int nbreDeTours;

	/**
	 * le constructeur pour les objets de la classe Jeu
	 * @param n le nombre de tours
	 */
	public Jeu(int n) {
		this.nbreDeTours = n;
	}

	/**
	 * interprete la chaine saisie au clavier et la transforme en coup
	 * @param entree la chaine saisie au clavier
	 * @return le coup correspondant a la chaine si c'est un coup valide, null sinon
	 */
	public Coup readCoup(String entree) {
		if (entree.equals("pierre")) {
			return Coup.pierre;
		}
		else {
			if (entree.equals("papier")) {
				return Coup.papier;
			}
			else {
				if (entree.equals("ciseaux")) {
					return Coup.ciseaux;
				}
				else {
					return null;
				}
			}
		}
	}		

	/**
	 * joue un tour
	 * @param joueur1 le joueur 1
	 * @param joueur2 le joueur 2
	 */
	public void joueUnTour(Joueur joueur1, Joueur joueur2) {
		System.out.println(joueur1+", veuillez taper en minuscules le coup que vous voulez jouer...");
		Coup coup1 = joueur1.joueUnCoup();
		while (coup1 == null) {
			System.out.println("Ceci n'est pas un coup ! Veuillez entrer un coup valide !");
			coup1 = joueur1.joueUnCoup();
		}
		Coup coup2 = joueur2.joueUnCoup();
		System.out.println("\n- Coups joues\n"+joueur1+" : "+coup1+" | "+joueur2+" : "+coup2+"\n");
		switch (coup1.compareCoups(coup2)) {
			case -1 : System.out.println(joueur2+" bat "+joueur1+" sur ce tour.\n"); joueur2.ajoutePoints(2); break;
			case 1 : System.out.println(joueur1+" bat "+joueur2+" sur ce tour.\n"); joueur1.ajoutePoints(2); break;
			default : System.out.println(joueur1+" et "+joueur2+" sont a egalite sur ce tour.\n"); joueur1.ajoutePoints(1); joueur2.ajoutePoints(1); break;
		}
	}

	/**
	 * joue une partie
	 * @param joueur1 le joueur 1
	 * @param joueur2 le joueur 2
	 */
	public void joueUnePartie(Joueur joueur1, Joueur joueur2) {
		System.out.println("---------------------------------------------------------------");
		for (int i = 1 ; i <= this.nbreDeTours ; i++) {
			System.out.println("Tour "+i);
			this.joueUnTour(joueur1,joueur2);
			System.out.println("- Points\n"+joueur1+" : "+joueur1.getScore()+" | "+joueur2+" : "+joueur2.getScore()+"\n");
			System.out.println("- Tours restants : "+(this.nbreDeTours - i));
			System.out.println("---------------------------------------------------------------");
		}
		switch (joueur1.compareScores(joueur2)) {
			case 1 : System.out.println("\nBravo "+joueur1+" ! Vous avez battu "+joueur2+" sur le score de "+joueur1.getScore()+" a "+joueur2.getScore()+" !"); break;
			case -1 : System.out.println("\nBravo "+joueur2+" ! Vous avez battu "+joueur1+" sur le score de "+joueur2.getScore()+" a "+joueur1.getScore()+" !"); break;
			default : System.out.println(joueur1+" et "+joueur2+", vous avez fait match nul sur le score de "+joueur1.getScore()+" a "+joueur2.getScore()+" !"); break;
		}		
	}

	/**
	 * teste notre classe
	 */
	public static void main(String[] args) {
		Joueur joueur1 = new Joueur(args[0],new StrategieHumaine());
		Joueur joueur2 = new Joueur("Robot",new StrategieAleatoire());
		Jeu unJeu = new Jeu(Integer.parseInt(args[1]));
		unJeu.joueUnePartie(joueur1,joueur2);
	}

}
