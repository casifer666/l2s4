package src.motif ;
  
/** La classe AvecPoint définit la notion d'état
 *  d'où part une flèche étiquetée par l'alphabet tout entier 
 *  vers un état différent.
 * @author yroos@lifl.fr
 * @version 24. <a HREF="./sujet/sujet.html">TD de COO</a>, Licence d'informatique
 * @see <a HREF="../../src/motif/AvecPoint.java">source</a>
*/
public class AvecPoint extends NonTerminal {
  /** Crée un nouvel AvecPoint avec un voisin donné.
   *@param voisin un état quelconque qui deviendra l'état voisin du nouvel état.
  */   
  public AvecPoint(Etat voisin) {super(voisin) ;}
  /** Teste si une lettre permet de passer à l'état voisin.
   *@param c un caractère quelconque.
   *@return toujours true.
   */       
  protected boolean test(char c) {return true ;}
}
