 
/**
 * (Documentation should be in english...)
 * Seconde version de livre pour un premier contatc avec les objets
 * 
 * @author jc
 * @version 1.0
 */
 

public class Livre {
    /**
     * Constructeur d'objets de la classe Livre
     */
    public Livre(Auteur auteur, String titre, int annee,String texte) {
        this.auteur = auteur;
        this.titre = titre;
        this.annee = annee;
        this.texte = texte;
    }


    // les attributs de la classe livre 

    private Auteur auteur;
    private String titre;
    private int annee;
    private String texte;

    // les methodes de la classe Livre

    /** affiche les informations sur le livre
    */
    public void affiche() {
        System.out.println(this.titre);
        System.out.println(" par ");
        this.auteur.affiche();
        System.out.println(" paru en "+annee);
    }
    /** lit le livre (affiche le texte)
    */
    public void lit() {
        System.out.println(this.texte);
    }
    /** retourne l'auteur de livre
    * @return l'auteur du livre
    */
    public Auteur getAuteur() {
        return this.auteur;
    }
}
