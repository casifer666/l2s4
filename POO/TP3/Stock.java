/** Une classe qui represente un stock identifie juste par sa quantite
 */
public class Stock {
 
    private int quantite;

    /** cree un stock avec une quantite initiale = 0
     */
    public Stock() {
	this.quantite = 0;
    }
    /** cree un stock avec une quantite initiale donnee
     * @param qteInitiale la quantite initiale du stock
     */
    public Stock(int qteInitiale) {
	this.quantite = qteInitiale;
    }

    /** fourni la quantite du stock
     * @return la quantite du stock
     */
    public int getQuantite() {
	return this.quantite;
    }

    /** retire des elements du stock dans la mesure du possible (sans
     * rendre le stock negatif)
     * @param la quantite que l'on souhaite retiree
     * @return la quantite que l'on a pu retirer au maximum sans rendre le stock negatif
     */
    public int retire(int retrait) {
	if (retrait <= this.quantite) {
	    this.quantite = this.quantite - retrait;
	    return retrait;
	} 
	else {
	    int result = this.quantite;
	    this.quantite = 0;
	    return result;
	}
    }

    /** ajoute une certaine quantite a ce stock
     * @param qte la quantite ajoutee
     */
    public void ajoute(int qte) {
	this.quantite = this.quantite + qte;
    }

    public String toString() {
	return "la quantite en stocke est de "+this.quantite;
    }

	public static void main(String[] args) {
	Stock unStock = new Stock();
	unStock.ajoute(Integer.parseInt(args[0]));
	System.out.println(unStock.getQuantite());
	}
}
