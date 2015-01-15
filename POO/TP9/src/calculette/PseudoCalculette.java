package calculette ;
/** Un exemple d"implémentation de l'interface Calculette.
    A chaque "appui" sur une de ses touches, cette "calculette" 
    prend comme valeur le code de la touche correspondante du pavé
    numérique d'un clavier de PC
 */
public class PseudoCalculette implements Calculette {

  private int valeur ;
  
  public PseudoCalculette() { this.valeur = 0 ;}
  
    /** Retourne la valeur courante de la calculette 
      * @return la valeur courante de la calculette 
    */
    public int getValeurCourante() {return this.valeur ;}
    /** Action correspondant à l'appui sur une touche de chiffre 
      * @param c la valeur entière correspondant au chiffre 
    */
    public void enfoncerChiffre (int c) {this.valeur = 144 + c ;}
    /** Action correspondant à l'appui sur la touche + */ 
    public void enfoncerPlus () {this.valeur = 156 ;}
    /** Action correspondant à l'appui sur la touche - */ 
    public void enfoncerMoins () {this.valeur = 157 ;}
    /** Action correspondant à l'appui sur la touche / */ 
    public void enfoncerDiv () {this.valeur = 159 ;}
    /** Action correspondant à l'appui sur la touche * */ 
    public void enfoncerMult () {this.valeur = 158 ;}
    /** Action correspondant à l'appui sur la touche = */ 
    public void enfoncerEgal () {this.valeur = 155 ;}
    /** Action correspondant à l'appui sur la touche Del */ 
    public void enfoncerDel () {this.valeur = 154 ;}
    /** Action correspondant à l'appui sur la touche CC */ 
    public void enfoncerRaz () {this.valeur = 174 ;}
    
    public static void main(String[] arg) {
      new VueCalculette(new PseudoCalculette()).lancer("Pseudo") ;
    }
}
