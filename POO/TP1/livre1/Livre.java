
/**
 * (Documentation should be in english...)
 * Premiere version de livre pour un premier contact avec les objets
 * 
 * @author jc
 * @version 1.0
 */
 

public class Livre {
    /**
     * Constructeur d'objets de la classe Livre
     * @param auteur = l'auteur du livre
     * @param titre = le titre du livre
     * @param int = l'annee de parution du livre
     * @param texte = le texte du livre
     */
     public Livre(String auteur, String titre, int annee, String texte) {
        this.auteur = auteur;
        this.titre = titre;
        this.annee = annee;
        this.texte = texte;
     }
     
    // les attributs de la classe livre
    private String auteur;
    private String titre;
    private int annee;
    private String texte;
    // les methodes de la classe Livre

    /** donne l' <t>auteur</t> du livre
     * @return l'<t>auteur</t> du livre
     */
    public String getAuteur() { // ici pas de modificateur setAuteur, 
      return this.auteur;    // a priori quand un livre est cree il
    }                         // ne change pas d'auteur... 

    /** donne le <t>titre</t> du livre
     * @return le <t>titre</t> du livre
     */    
    public String getTitre() {
       return this.titre;      // idem pour titre;
    }
    /** affiche les informations sur le livre
     */
    public void affiche() {
       System.out.println(this.titre+" de "+this.auteur+" paru en "+this.annee);
    }
    /** lit le livre (affiche le texte)
     */
    public void lit() {
      System.out.println(this.texte);
    }
}
