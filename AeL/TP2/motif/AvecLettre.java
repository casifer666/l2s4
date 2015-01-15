package src.motif ;
  
/** La classe AvecLettre définit la notion d'état
 *  d'où part une flèche étiquetée par une lettre donnée vers 
 *  vers un état différent.
 * @author yroos@lifl.fr
 * @version .23 <a HREF="./sujet/sujet.html">TD de COO</a>, Licence d'informatique
 * @see <a HREF="../../src/motif/AvecLettre.java">source</a>
*/
public class AvecLettre extends NonTerminal {
  /** correspond à la lettre étiquetant la flèche vers le voisin. 
  */
   private char label ;
  /** Crée un nouvel AvecLettre avec un voisin donné qu'on peut atteindre
  * avec une lettre donnée.
   *@param label un caractère quelconque qui étiquette la flèche vers le voisin.
   *@param voisin un état quelconque qui deviendra l'état voisin du nouvel état.
  */   
  public AvecLettre(char label , Etat voisin) {super(voisin) ; this.label = label ;}
  /** Teste si une lettre permet de passer à l'état voisin.
   *@param c1 un caractère quelconque.
   *@return true si et seulement si la lettre c1 permet 
   * de passer à l'état voisin.
   */     
  protected boolean test(char c1) {return (c1 == label) ;}
}
