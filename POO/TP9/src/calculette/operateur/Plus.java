package calculette.operateur;

/**
 * Cree l'operateur d'addition
 */
public class Plus implements Operateur {

	/**
	 * effectue une operation d'addition sur deux entiers
	 * @param a le premier terme
	 * @param b le second terme
	 */
	public int eval(int a, int b) {
		return (a + b);
	}

}