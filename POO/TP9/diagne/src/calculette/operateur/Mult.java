package calculette.operateur;

/**
 * Cree l'operateur de multiplication
 */
public class Mult implements Operateur {

	/**
	 * effectue une operation de multiplication sur deux entiers
	 * @param a le premier facteur
	 * @param b le second facteur
	 */
	public int eval(int a, int b) {
		return (a * b);
	}
	
}