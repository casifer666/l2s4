public class ULIdent implements Yytoken {

	private Token token;

	private String valeur;

	public ULIdent(String valeur) {
		this.token = Token.identificateur;
		this.valeur = valeur;
	}

	public Token getToken() {
		return this.token;
	}

	public Object getValue() {
		return this.valeur;
	}

	public String toString() {
		return "ULIdent "+this.getToken()+" "+this.getValue();
	}

}