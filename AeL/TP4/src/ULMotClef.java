public class ULMotClef implements Yytoken {

	private Token tokenCle;

	public ULMotClef(Token tokenCle) {
		this.tokenCle = tokenCle;
	}

	public Token getToken() {
		return this.tokenCle;
	}

	public Object getValue() {
		return null;
	}

	public String toString() {
		return "ULMotClef "+this.getToken()+" "+this.getValue();
	}

}