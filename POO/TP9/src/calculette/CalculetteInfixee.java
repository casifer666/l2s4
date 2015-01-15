package calculette;

import calculette.operateur.*;

/**
 * Classe permettant de representer une calculette infixee
 */
public class CalculetteInfixee implements Calculette {

	/**
	 * la valeur courante
	 */
	private int valC;

	/**
	 * l'operateur courant
	 */
	private Operateur op;

	/**
	 * la valeur precedente
	 */
	private int valP;

	/**
     * le resultat d'une operation
     */
    private int res;

    /**
     * booleen qui remet a 0 la valeur courante apres avoir appuye sur =
     */
    private boolean raz;

	/**
	 * le constructeur pour les objets de la classe CalculetteInfixee
	 */
	public CalculetteInfixee() {
		this.valC = 0;
		this.op = null;
		this.valP = 0;
        this.res = 0;
        this.raz = false;
	}

	/**
	 * renvoie la valeur courante de la calculette
     * @return la valeur courante de la calculette 
     */
	public int getValeurCourante() {
		return this.valC;
	}

    /**
     * appuie sur une touche de chiffre 
     * @param c la valeur entiere correspondant a la touche chiffre enfoncee
     */
    public void enfoncerChiffre(int c) {
    	if (this.op == null) {
			if (this.valC != 0) {
                if (raz) {
                    this.valC = 0;
                }
                this.res = this.valC;
              	this.valP = this.res;
    			this.valC = (this.valC * 10) + c;
                this.raz = false;
    		}
    		else {
                this.valC = c;
                this.res = this.valC;
                this.valP = this.res;	
			}
		}
    	else {
            try {
                this.valC = c;
                this.res = this.op.eval(this.valP,c);
                this.valP = this.res;
            }
            catch (ArithmeticException e) {
                System.out.println("Erreur : Division par zero !");
            }
		}	
    }

    /**
     * appuie sur la touche +
     */ 
    public void enfoncerPlus() {
    	this.op = new Plus();
        this.valC = res;
    }

    /**
     * appuie sur la touche -
     */
    public void enfoncerMoins() {
    	this.op = new Moins();
        this.valC = res;
    }
  
    /**
     * appuie sur la touche /
     */
    public void enfoncerDiv() {
    	this.op = new Div();
        this.valC = res;
    }

    /**
     * appuie sur la touche *
     */
    public void enfoncerMult() {
    	this.op = new Mult();
        this.valC = res;
    }

    /**
     * appuie sur la touche =
     */
    public void enfoncerEgal() {
        this.valC = res;
    	this.valP = 0;
    	this.op = null;
        this.raz = true;
    }
 
    /**
     * appuie sur la touche Del
     */
    public void enfoncerDel() {
    	this.valC = this.valC/10;
    } 

    /**
     * appuie sur la touche CC
     */
    public void enfoncerRaz() {
    	this.valC = 0;
    	this.valP = 0;
    	this.op = null;
    }

    /**
     * lance une vue d'une calculette infixee
     */
    public static void main(String[] args) {
        new VueCalculette(new CalculetteInfixee()).lancer("Infixee");
    }
    
}
