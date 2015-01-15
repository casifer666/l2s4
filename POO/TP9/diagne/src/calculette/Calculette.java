package calculette ;
/** Définit la notion générale de calculette */
public interface Calculette {
    /** Retourne la valeur courant de la calculette 
      * C'est cette valeur qui est affichée à l'écran de a calculatrice.
      * @return la valeur courante de la calculette 
    */
    public int getValeurCourante () ;
    /** Appui sur une touche de chiffre 
      * @param c la valeur entière correspondant à la touche chiffre enfoncée
    */
    public void enfoncerChiffre (int c) ;
    /** Appui sur la touche + */ 
    public void enfoncerPlus () ;
    /** Appui sur la touche - */ 
    public void enfoncerMoins () ;
    /** Appui sur la touche / */ 
    public void enfoncerDiv () ;
    /** Appui sur la touche * */ 
    public void enfoncerMult () ;
    /** Appui sur la touche = */ 
    public void enfoncerEgal () ;
    /** Appui sur la touche Del */ 
    public void enfoncerDel () ;
    /** Appui sur la touche CC */ 
    public void enfoncerRaz () ;
}
