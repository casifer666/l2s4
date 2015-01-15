
/**
 * (Documentation should be in english...)
 * une petite classe de manipulation : televiseur
 * 
 * @author JC 
 * @version 1.0
 */
 

public class Tv {

    // LES ATTRIBUTS = definition de l'etat de la classe

    /** statut de la tele, <t>true</t> pour allume, <t>false</t> sinon
     */
    private boolean allume;
    /** le numero de la chaine courante
     */
    private int chaine;
    /** niveau de volume courant. entre 0 et <i>sonMax</i>
     */
    private int volumeSon;
    /** niveau de son maximum possible */
    private int sonMax;
  
    // LE CONSTRUCTEUR : pour construire les instances

    /**
     * Constructor for objects of class Tv
     */
    public Tv() {
        this.allume = false;
        this.chaine = 5;
        this.volumeSon = 3;
        this.sonMax = 10;
    }

    
    // LES METHODES : le comportement de la classe
    
    /** allume la tele
     */
    public void allume() {
        this.allume = true;
    }
    /** eteint la tele
     */
    public void eteint() {
        this.allume = false;
    }
    /** change la chaine de la tele si la tele est allumee
     * @param numChaine la nouvelle chaine (>0)
     */
    public void changeChaine(byte numChaine) {
	if (this.allume && numChaine > 0) {
	    this.chaine = numChaine;
	}
    }    
    /** indique la chaine courante 
     * @return la chaine courante
     */
    public int chaineCourante() {
        return this.chaine;
    }
    /** monte le son si la tele est allumee
     */
    public void monteSon() {
	if (this.allume && this.volumeSon < sonMax) {
	    this.volumeSon = this.volumeSon + 1;  // ou this.volumeSon++
	}
    }
    /** baisse le son si la tele est allumee
     */
    public void baisseSon() {
	if (this.allume && this.volumeSon >0) {
	    this.volumeSon--; // equivaut a this.volumeSon = this.volumeSon - 1,
	}
    }     
    /** affiche un etat de la tele
     */
    public void afficheEtat() {
	System.out.print("tele ");
	if (this.allume) {
	    System.out.println(" allumee");
	}
	else {
	    System.out.println(" eteinte");
	}
	System.out.println("chaine : " + this.chaine +" - volume du son : "+ this.volumeSon);
    }
}
