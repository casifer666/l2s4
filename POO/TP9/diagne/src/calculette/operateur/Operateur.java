package calculette.operateur;

/**
 * Interface qui definit un operateur
 */
public interface Operateur {

	/**
	 * effectue l'operation courante entre deux entiers
	 * @param a le premier entier
	 * @param b le second entier
	 */
	public int eval(int a, int b);

}