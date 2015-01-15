public class ULEntier implements Yytoken {

	private Token token;

	public Integer valeur;

	public ULEntier(Integer valeur) {
		this.token = Token.entier;
		this.valeur = valeur;
	}

	public Token getToken() {
		return this.token;
	}

	public Object getValue() {
		return this.valeur;
	}

	public String toString() {
		return "ULEntier "+this.getToken()+" "+this.getValue();
	}

}