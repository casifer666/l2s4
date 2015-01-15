package src.motif ;

import java.util.Set ;

/** La classe NonTerminal définit la notion d'état non terminal
 *  d'un automate associé à un motif. Il s'agit d'états d'où part
 * une (unique) flèche vers un état différent appelé voisin.
 * @author yroos@lifl.fr
 * @version  . <a HREF="./sujet/sujet.html">TD de COO</a>, Licence d'informatique
 * @see <a HREF="../../src/motif/NonTerminal.java">source</a>
*/
public abstract class NonTerminal extends Etat {
  /** correspond au voisin de l'état. Le voisin existe toujours. 
  */
  private Etat voisin ;
  /** Crée un nouvel état non terminal avec un voisin donné.
   *@param voisin un état quelconque qui deviendra l'état voisin du nouvel état.
  */   
  NonTerminal(Etat voisin) {this.voisin = voisin ;}
  /** Teste si une lettre permet de passer à l'état voisin.
   *@param c un caractère quelconque.
   *@return true si et seulement si la lettre c permet 
   * de passer à l'état voisin.
   */     
  abstract protected boolean test(char c) ;  
  /** Retourne l'ensemble d'états atteints à partir 
   * de cet état en lisant la lettre c.
   *@param c un caractère quelconque.
  */   
  public Set action(char c) {
    Set set = super.action(c) ; 
    if (test(c)) set.add(voisin) ;
    return set ;
  }
}
