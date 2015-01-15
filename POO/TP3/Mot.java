
/**
 * Classe Mot : operations sur des mots (tp3) 
 * licence S4 - UE POO
 * @author : Salla Diagne
 */ 

public class Mot {

	// ATTRIBUTS
	private String valeur;


	// CONSTRUCTEURS
	public Mot (String s) {
		this.valeur = s;
	}


	// METHODES
	/** vaut vrai <code>o</code> est egal a ce mot, c'est-a-dire si
	* <code>o</code> est un Mot et si sa valeur est la meme que celle
	* de ce mot
	* @param o l'objet a comparer a ce mot
	* @return <code>true</code> ssi <code>o</code> est un Mot et sa
	* valeur est la meme que celle de ce mot
	*/
	public boolean equals (Object o) {
		if (o instanceof Mot) {
			Mot lAutre = (Mot) o;
			return this.valeur.equals(lAutre.valeur);
		}
		else {
		    return false;
		}
	}


	/**
	* renvoie la longueur du mot
	* @return la longueur du mot
	*/
	public int longueur () {
		return (this.valeur.length());
	}


	/**
	* retourne la valeur du mot
	* @return la valeur du mot
	*/
	public String toString () {
		return (this.valeur);
	}


	/**
	* calcule le nombre d'occurences dans le mot du caractere passe en parametre
	* @param c = le caractere dont l'occurence doit etre calculee
	* @return le nombre d'occurences du caractere
	*/
	public int nbOccurrencesOfChar (char c) {
		int nombre = 0; int i = 0;
		while ((i <= (this.valeur.length() - 1)) && (this.valeur.indexOf(c,i) != -1)) {
			nombre = nombre + 1;
			i = (this.valeur.indexOf(c,i)) + 1;
		}
		return nombre;
	}


	/**
	* renvoie le mot de valeur inverse
	* @return le mot de valeur inverse
	*/ 
	public Mot inverse() {
		String inverse = new String("");
		for (int i = (this.longueur() - 1) ; i >= 0 ; i --) {
			inverse += this.valeur.charAt(i);
		}
		return new Mot(inverse);
	}


	/**
	* verifie si le mot est un palindrome
	* @return vrai si le mot est un palindrome, faux sinon
	*/
	public boolean estPalindrome () {
		return (this.valeur.equals(this.inverse().valeur));
	}


	/** 
	* verifie si le mot en parametre est un "sous-mot" du mot courant
	* @param m = le mot dont on doit verifier s'il est un "sous-mot" du mot courant ou pas
	* @return vrai si le mot passe en parametre est un "sous-mot" du mot courant, faux sinon
	*/
	public boolean contient (Mot m)  {
		return (this.valeur.indexOf(m.valeur) != -1);
	}


	/** 
	* verifie si le mot en parametre rime avec le mot courant
	* @param m = le mot dont on doit verifier s'il rime avec le mot courant
	* @return vrai si les deux mots riment, faux sinon
	*/
	public boolean rimeAvec (Mot m) {
		return ((this.longueur() >= 3) && (m.longueur() >= 3) && (this.valeur.endsWith(m.valeur.substring(m.longueur() - 3))));
	}


	/**
	* verifie si le mot est un nom propre (commence par une majuscule)
	* @return vrai si le mot est un nom propre, faux sinon
	*/
	public boolean estNomPropre () {
		return (Character.isUpperCase(this.valeur.charAt(0)));
	}


	/** 
	* verifie si le mot en parametre est anagramme du mot courant
	* @param m = le mot dont on doit verifier s'il est anagramme du mot courant
	* @return vrai si les deux mots sont anagrammes, faux sinon
	*/
	public boolean estAnagramme (Mot m) {
		if (this.longueur() != m.longueur()) {
			return false;
		}
		else {
			int mot1 [] = new int [26]; int mot2 [] = new int [26];
			for (int i = 0; i < this.valeur.length(); i ++) {
				int k = (Character.getNumericValue(this.valeur.charAt(i)) - 10); int l = (Character.getNumericValue(m.valeur.charAt(i)) - 10);
				mot1[k] = mot1[k] + 1;
				mot2[l] = mot2[l] + 1;
			}
			int j = 0;
			while ((j < mot1.length) && (mot1[j] == mot2[j])) {
				j = j + 1;
			}
			return (j == mot1.length);
		}
	}


	/** 
	* retourne un tableau de deux mots selon l'occurence passee en parametre
	* @param c = l'occurence
	* @return le tableau de deux mots selon l'occurence
	*/
	public Mot[] extraitAvant (char c) {
		Mot chaines [] = new Mot [2];
		if (this.valeur.indexOf(c) == -1) {
			chaines[0] = new Mot("");
			chaines[1] = new Mot(this.valeur);
			return chaines;
		}
		else {
			chaines[0] = new Mot(this.valeur.substring(0,this.valeur.indexOf(c) + 1));
			chaines[1] = new Mot(this.valeur.substring(this.valeur.indexOf(c) + 1));
			return chaines;
		}
	}


	/**
	* TESTS :
	* - args[0] = la valeur de l'instance de la classe Mot
	* - args[1] = le caractere dont on doit rechercher l'occurence dans le mot courant
	* - args[2] = le mot dont on doit verifier la rime avec le mot courant
	* - args[3] = le mot dont on doit verifier s'il est un sous-mot du mot courant ou pas
	* - args[4] = le caractere dont on doit partir pour creer un tableau de deux mots selon l'occurence de ce caractere
	* - args[5] = le mot dont on doit verifier s'il est un anagramme du mot courant
	*/
	public static void main (String[] args) {
		if (args.length == 6) {
			Mot unMot = new Mot(args[0]);
			String occurence = new String(args[1]);
			Mot rime = new Mot(args[2]);
			Mot contient = new Mot(args[3]);
			String extrait = new String(args[4]);
			Mot anagramme = new Mot(args[5]);
			System.out.println("le mot "+unMot+" est de longueur "+unMot.longueur());
			System.out.println("le mot est "+unMot);
	 		System.out.println("le caractere '"+occurence+"' apparait "+unMot.nbOccurrencesOfChar(occurence.charAt(0))+" fois dans le mot "+unMot);
			System.out.println("l'inverse du mot "+unMot+" est "+unMot.inverse());
			if (unMot.contient(contient)) {
				System.out.println(contient+" est un sous-mot de "+unMot);
			}
			else {
				System.out.println(contient+" n'est pas un sous-mot de "+unMot);
			}
			if (unMot.rimeAvec(rime)) {
				System.out.println(rime+" rime avec "+unMot);
			}
			else {
				System.out.println(rime+" ne rime pas avec "+unMot);
			}
			for (Mot n: unMot.extraitAvant(args[4].charAt(0))) {
			System.out.print(n+"-");
			}
			System.out.println(" suivant l'occurence '"+args[4]+"'");
			if (unMot.estPalindrome()) {
				System.out.println(unMot+" est un palindrome");
			}
			else {
				System.out.println(unMot+" n'est pas un palindrome");
			}
			if (unMot.estAnagramme(anagramme)) {
				System.out.println(unMot+" et "+anagramme+ " sont des anagrammes");
			}
			else {
				System.out.println(unMot+" et "+anagramme+ " ne sont pas des anagrammes");
			}
			if (unMot.estNomPropre()) {
				System.out.println(unMot+" est un nom propre");
			}
			else  {
				System.out.println(unMot+" n'est pas un nom propre");
			}
		}
		else {
			System.out.println("args[0] = la valeur de l'instance de la classe Mot");
			System.out.println("args[1] = le caractere dont on doit rechercher l'occurence dans le mot courant");
			System.out.println("args[2] = le mot dont on doit verifier la rime avec le mot courant");
			System.out.println("args[3] = le mot dont on doit verifier s'il est un sous-mot du mot courant ou pas");
			System.out.println("args[4] = le caractere dont on doit partir pour creer un tableau de deux mots selon l'occurence de ce caractere");
			System.out.println("args[5] = le mot dont on doit verifier s'il est un anagramme du mot courant");
		}
	}
}

