package calculette;

import calculette.operateur.*;
import java.util.Stack;
import java.util.EmptyStackException;

/**
 * Classe permettant de representer une calculette postfixee
 */
public class CalculettePostfixee implements Calculette {

	/**
	 * la valeur courante de la calculette
	 */
	private int valC;

	/**
	 * l'operateur courant
	 */
	private Operateur op;

	/**
	 * pile d'entiers permettant de stocker les operandes
	 */
	private Stack<Integer> pile;

	/**
	 * booleen qui permet de savoir si une touche de chiffre ou la touche = a ete enfoncee
	 */
	private boolean raz;

	/**
	 * le constructeur pour les objets de la classe CalculettePostfixee
	 */
	public CalculettePostfixee() {
		this.valC = 0;
		this.pile = new Stack<Integer>();
	}

	/**
	 * renvoie la valeur courante de la calculette
	 * @return la valeur courante de la calculette
	 */
	public int getValeurCourante() {
		return this.valC;
	}

	/**
	 * appuie sur une touche de la calculette
	 * @param c la touche enfoncee
	 */
	public void enfoncerChiffre(int c) {
		if (raz) {
			this.valC = 0;
		}
		if (this.valC == 0) {
			this.valC = c;
			this.raz = false;

		}
		else {
			this.valC = (this.valC * 10) + c;
			this.raz = false;
		}
	}

	/**
	 * appuie sur la touche +
	 */
	public void enfoncerPlus() {
		try {
			this.op = new Plus();
			if (!raz) {
				this.pile.push(valC);
			}
			int a = this.pile.pop(); int b = this.pile.pop();
			this.valC = this.op.eval(b,a);
			this.pile.push(this.valC);
			this.raz = true;
		}
		catch (EmptyStackException e) {
			System.out.println("Erreur de syntaxe : Saisir deux operandes avant de saisir un operateur");
		}
	}

	/**
	 * appuie sur la touche -
	 */
	public void enfoncerMoins() {
		try {
			this.op = new Moins();
			if (!raz) {
				this.pile.push(valC);
			}
			int a = this.pile.pop(); int b = this.pile.pop();
			this.valC = this.op.eval(b,a);
			this.pile.push(this.valC);
			this.raz = true;
		}
		catch (EmptyStackException e) {
			System.out.println("Erreur de syntaxe : Saisir deux operandes avant de saisir un operateur");
		}
	}

	/**
	 * appuie sur la touche *
	 */
	public void enfoncerMult() {
		try {
			this.op = new Mult();
			if (!raz) {
				this.pile.push(valC);
			}
			int a = this.pile.pop(); int b = this.pile.pop();
			this.valC = this.op.eval(b,a);
			this.pile.push(this.valC);
			this.raz = true;
		}
		catch (EmptyStackException e) {
			System.out.println("Erreur de syntaxe : Saisir deux operandes avant de saisir un operateur");
		}
	}

	/**
	 * appuie sur la touche /
	 */
	public void enfoncerDiv() {
		try {
			this.op = new Div();
			if (!raz) {
				this.pile.push(valC);
			}
			int a = this.pile.pop(); int b = this.pile.pop();
			this.valC = this.op.eval(b,a);
			this.pile.push(this.valC);
			this.raz = true;
		}
		catch (ArithmeticException e) {
			System.out.println("Erreur : Division par zero !");
		}
		catch (EmptyStackException e) {
			System.out.println("Erreur de syntaxe : Saisir deux operandes avant de saisir un operateur");
		}
	}

	/**
	 * appuie sur la touche Del
	 */
	public void enfoncerDel() {
		this.valC = this.valC/10;
	}

	/**
	 * appuie sur la touche =
	 */
	public void enfoncerEgal() {
		this.pile.push(this.valC);
		this.raz = true;
	}

	/**
	 * appuie sur la touche CC
	 */
	public void enfoncerRaz() {
		this.valC = 0;
		this.op = null;
	}

	/**
     * lance une vue d'une calculette postfixee
     */
	public static void main(String[] args) {
    	new VueCalculette(new CalculettePostfixee()).lancer("Postfixee");
    }

}