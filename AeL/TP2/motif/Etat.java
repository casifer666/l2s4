package src.motif ;

import java.util.Set ;
import java.util.HashSet ;

/** La classe Etat d�finit la notion la plus g�n�rale d'�tat 
 *  d'un automate associ� � un motif.
 * @author yroos@lifl.fr
 * @version 2.3.4 <a HREF="./sujet/sujet.html">TD de COO</a>, Licence d'informatique
 * @see <a HREF="../../src/motif/Etat.java">source</a>
 */

public abstract class Etat {
  /** Indique l'existence ou non d'une boucle.
   * Un �tat est sans boucle � la cr�ation. 
  */
  private boolean avec_boucle = false ;
  /** Ajoute une boucle �tiquet�e par l'alphabet tout entier � l'�tat */
  public void avecBoucle() {avec_boucle = true ;} 
  /** Retourne l'ensemble d'�tats atteints � partir 
   * de cet �tat en lisant la lettre c.
   *@param c un caract�re quelconque.
  */   
  public Set action(char c) {
    Set set = new HashSet() ;
    if (avec_boucle) set.add(this) ;
    return set ;
  }
}
