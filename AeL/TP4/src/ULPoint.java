import java.awt.Point;

public class ULPoint implements Yytoken {

	private Token token;

	private Point valeur;

	public ULPoint(int x,int y) {
		this.token = Token.point;
		this.valeur = new Point(x,y);
	}

	public Token getToken() {
		return this.token;
	}

	public Object getValue() {
		return this.valeur;
	}

	public String toString() {
		return "ULPoint "+this.getToken()+" "+this.getValue();
	}
	
}