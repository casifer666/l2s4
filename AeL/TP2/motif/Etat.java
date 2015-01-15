package src.motif ;

import java.util.Set ;
import java.util.HashSet ;

/** La classe Etat définit la notion la plus générale d'état 
 *  d'un automate associé à un motif.
 * @author yroos@lifl.fr
 * @version 2.3.4 <a HREF="./sujet/sujet.html">TD de COO</a>, Licence d'informatique
 * @see <a HREF="../../src/motif/Etat.java">source</a>
 */

public abstract class Etat {
  /** Indique l'existence ou non d'une boucle.
   * Un état est sans boucle à la création. 
  */
  private boolean avec_boucle = false ;
  /** Ajoute une boucle étiquetée par l'alphabet tout entier à l'état */
  public void avecBoucle() {avec_boucle = true ;} 
  /** Retourne l'ensemble d'états atteints à partir 
   * de cet état en lisant la lettre c.
   *@param c un caractère quelconque.
  */   
  public Set action(char c) {
    Set set = new HashSet() ;
    if (avec_boucle) set.add(this) ;
    return set ;
  }
}
