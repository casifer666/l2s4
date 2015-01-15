package calculette.operateur;

/**
 * Cree l'operateur de soustraction
 */
public class Moins implements Operateur {

	/**
	 * effectue une operation de soustraction sur deux entiers
	 * @param a le premier terme
	 * @param b le second terme
	 */
	public int eval(int a, int b) {
		return (a - b);
	}
	
}