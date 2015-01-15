package ppc.util;

/**
 * Classe permettant de representer une strategie permettant a un joueur humain de taper son coup a la saisie dans le jeu de pierre-papier-ciseaux
 */
public class StrategieHumaine implements Strategie {

	/**
	 * interprete la chaine saisie au clavier et la transforme en coup
	 * @param entree la chaine saisie au clavier
	 * @return le coup correspondant a la chaine si c'est un coup valide, null sinon
	 */
	public Coup litCoup(String entree) {
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
	 * permet de taper son propre coup a la saisie
	 * @return le coup tape
	 */
	public Coup coupAJouer() {
		Input entree = new Input();
		System.out.print("> ");
		return litCoup(entree.readString());
	}

}
	
