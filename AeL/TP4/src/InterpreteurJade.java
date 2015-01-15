import java.io.*;
import java.awt.Point;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class InterpreteurJade {
	// La fenetre où dessiner
	private FenetreJade fenetre;
	// L'analyseur syntaxique décrit dans le fichier "analyseurjade.lex"
	private Yylex analyseur;
	// la table des symboles pour l'instruction complexe definir
	private TabSymboles symboles;
	
	private List<Yytoken> tokensRep = new ArrayList<Yytoken>();

	/**
	 * Constructeur
	 */
	public InterpreteurJade(){
		this.fenetre = new FenetreJade();
		// créer un Yylex qui va prendre ses entrées au clavier
		this.analyseur = new Yylex(new BufferedReader(new InputStreamReader(System.in)));
		// la table des symboles pour l'instruction complexe definir
		this.symboles = new TabSymboles();
	}
	
	/**
	 * Récupère la prochaine unité lexicale lue par l'analyseur lexical.
	 */
	public Yytoken lireProchaineUniteLexicale() throws Exception {
		return analyseur.yylex();
	}

	public void traiterListe(List<Yytoken> l) throws Exception {
		int j = 0;
		while (j < l.size()) {
			if (l.get(j).getToken() == Token.pas && l.get(j+1).getToken() == Token.entier) {
				Integer m = (Integer) l.get(j+1).getValue();
				this.fenetre.pas(m);
				j = j + 2;
			}
			else {
				if (l.get(j).getToken() == Token.origine && l.get(j+1).getToken() == Token.point) {
					Point p = (Point) l.get(j+1).getValue();
					this.fenetre.origine(p);
					j = j + 2;
				}
				else {
					if (l.get(j).getToken() == Token.entier && l.get(j+1).getToken() == Token.fois) {
						Integer a = (Integer) l.get(j).getValue();
						switch (l.get(j+2).getToken()) {
							case nord : for (int k = 0 ; k < a ; k++) this.fenetre.nord(); break;
							case sud : for (int k = 0 ; k < a ; k++) this.fenetre.sud(); break;
							case est : for (int k = 0 ; k < a ; k++) this.fenetre.est(); break;
							case ouest : for (int k = 0 ; k < a ; k++) this.fenetre.ouest(); break;
						}
						j = j + 3;
					}
					else {
						if (l.get(j).getToken() == Token.identificateur) {
							String s = (String) l.get(j).getValue();
							if (this.symboles.laTable.containsKey(s)) {
								this.traiterListe(this.symboles.laTable.get(s));
							}
							j = j + 1;
						}
						else {
							if (l.get(j).getToken() == Token.repeter && l.get(j+1).getToken() == Token.entier && l.get(j+2).getToken() == Token.fois ) {
								Integer b = (Integer) l.get(j+1).getValue();
								j = j + 3;
								while (l.get(j).getToken() != Token.repeter) {
									this.tokensRep.add(l.get(j));
									j++;
								}
								for (int c = 0 ; c < b ; c++) {
									this.traiterListe(this.tokensRep);
								}
								j++;
								this.tokensRep.clear();
							}
							else {
								this.traiterUniteLexicale(l.get(j));
								j = j + 1;
							}
						}
					}
				}
			}
		}
	}

	public void traiterUniteLexicale(Yytoken ul) throws Exception {
		try {
			switch (ul.getToken()) {
				case origine : ul = this.lireProchaineUniteLexicale();
					if (ul.getToken() == Token.point) {
						Point p = (Point) ul.getValue(); this.fenetre.origine(p);
					}
					break;
				case nord : this.fenetre.nord(); break;
				case sud : this.fenetre.sud(); break;
				case ouest : this.fenetre.ouest(); break;
				case est : this.fenetre.est(); break;
				case lever : this.fenetre.lever(); break;
				case baisser : this.fenetre.baisser(); break;
				case pas : ul = this.lireProchaineUniteLexicale();
					if (ul.getToken() == Token.entier) {
						Integer n = (Integer) ul.getValue();
						this.fenetre.pas(n);
					}
					break;
				case entier : Integer n = (Integer) ul.getValue(); ul = this.lireProchaineUniteLexicale();
					if (ul.getToken() == Token.fois) {
						ul = this.lireProchaineUniteLexicale();
						if (ul.getToken() == Token.nord || ul.getToken() == Token.sud || ul.getToken() == Token.est || ul.getToken() == Token.ouest) {
							switch (ul.getToken()) {
								case nord : for (int i = 0 ; i < n ; i++) this.fenetre.nord(); break;
								case sud : for (int i = 0 ; i < n ; i++) this.fenetre.sud(); break;
								case est : for (int i = 0 ; i < n ; i++) this.fenetre.est(); break;
								case ouest : for (int i = 0 ; i < n ; i++) this.fenetre.ouest(); break;
							}
						}
					}
					break;
				case repeter : ul = this.lireProchaineUniteLexicale();
					if (ul.getToken() == Token.entier) {
						Integer i = (Integer) ul.getValue(); ul = this.lireProchaineUniteLexicale();
						if (ul.getToken() == Token.fois) {
							ul = this.lireProchaineUniteLexicale();
							while (ul.getToken() != Token.fin) {
								tokensRep.add(ul);
								ul = this.lireProchaineUniteLexicale();
							}
							ul = this.lireProchaineUniteLexicale();
							if (ul.getToken() == Token.repeter) {
								for (int b = 0 ; b < i ; b++) {
									this.traiterListe(tokensRep);
								}
							}
						}
					}
					tokensRep.clear();
					break;
				case identificateur : String s = (String) ul.getValue();
					if (this.symboles.laTable.containsKey(s)) {
						this.traiterListe(this.symboles.laTable.get(s));
					}
					break;
				case definir : ul = this.lireProchaineUniteLexicale();
					LinkedList<Yytoken> tokensDef = new LinkedList<Yytoken>();
					if (ul.getToken() == Token.identificateur) {
						String nom = (String) ul.getValue();
						ul = this.lireProchaineUniteLexicale();
						while (ul.getToken() != Token.definir) {
							tokensDef.add(ul);
							ul = this.lireProchaineUniteLexicale();
						}
						tokensDef.removeLast();
						symboles.sauver(nom,tokensDef);
					}
					break;
				default : {};
			}
		}
		catch (NullPointerException e) {
			System.out.println("Fixez une origine");
		}
	}
	
	/**
	 * La classe principale de l'interpréteur jade.
	 */
	public static void main(String[] args){
		InterpreteurJade interpreteur = new InterpreteurJade();
		System.out.println("\nBienvenue dans l'interpréteur Jade !\n");
		Yytoken ul = null;
		try{
			while (ul == null || ul.getToken() != Token.eof){
				if(ul != null){
					if(ul.getToken() == Token.erreur){
						System.out.println("Erreur : la valeur entrée n'est pas une commande Jade valide.");
					} else {
						interpreteur.traiterUniteLexicale(ul);
					}
				}
				System.out.print("Jade > ");
				ul = interpreteur.lireProchaineUniteLexicale();
			}
			System.out.println("\n\nMerci d'avoir utilisé l'interpréteur Jade !\n");
			System.exit(1);
		} catch(Exception e){
			e.printStackTrace();
			System.out.println("\n\nUne erreur imprévue est survenue.\nL'interpréteur Jade doit se fermer.");
			System.exit(0);
		}
	}
}