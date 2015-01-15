import drawing.*;
import java.awt.Point;

public class FenetreJade {

	private DrawingFrame fenetre;

	private Token etatCrayon;

	private int pas;

	public FenetreJade() {
		this.fenetre = new DrawingFrame();
		this.etatCrayon = Token.baisser;
		this.pas = 1;
	}

	public void nord() throws DrawingException {
		int x = (int) this.fenetre.getCurrentPoint().getX();
		int y = (int) this.fenetre.getCurrentPoint().getY();
		Point p = new Point(x,y-this.pas);
		if (etatCrayon == Token.baisser)
			this.fenetre.drawTo(p);
		else
			this.fenetre.goTo(p);
	}

	public void sud() throws DrawingException {
		int x = (int) this.fenetre.getCurrentPoint().getX();
		int y = (int) this.fenetre.getCurrentPoint().getY();
		Point p = new Point(x,y+this.pas);
		if (etatCrayon == Token.baisser)
			this.fenetre.drawTo(p);
		else
			this.fenetre.goTo(p);
	}

	public void est() throws DrawingException {
		int x = (int) this.fenetre.getCurrentPoint().getX();
		int y = (int) this.fenetre.getCurrentPoint().getY();
		Point p = new Point(x+this.pas,y);
		if (etatCrayon == Token.baisser)
			this.fenetre.drawTo(p);
		else
			this.fenetre.goTo(p);
	}

	public void ouest() throws DrawingException {
		int x = (int) this.fenetre.getCurrentPoint().getX();
		int y = (int) this.fenetre.getCurrentPoint().getY();
		Point p = new Point(x-this.pas,y);
		if (this.etatCrayon == Token.baisser)
			this.fenetre.drawTo(p);
		else
			this.fenetre.goTo(p);
	}

	public void origine(Point p) throws DrawingException {
		this.fenetre.goTo(p);
	}

	public void lever() {
		this.etatCrayon = Token.lever;
	}

	public void baisser() {
		this.etatCrayon = Token.baisser;
	}

	public void pas(int n) {
		this.pas = n;
	}

}