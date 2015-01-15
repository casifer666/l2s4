package calculette.operateur;

/**
 * Cree l'operateur de division
 */
public class Div implements Operateur {

	/**
	 * effectue une operation de division sur deux entiers
	 * @param a le numerateur
	 * @param b le denominateur
	 */
	public int eval(int a, int b) {
		return (a / b);
	}
	
}