package src.motif ;

import java.util.Set ;

/** La classe NonTerminal d�finit la notion d'�tat non terminal
 *  d'un automate associ� � un motif. Il s'agit d'�tats d'o� part
 * une (unique) fl�che vers un �tat diff�rent appel� voisin.
 * @author yroos@lifl.fr
 * @version  . <a HREF="./sujet/sujet.html">TD de COO</a>, Licence d'informatique
 * @see <a HREF="../../src/motif/NonTerminal.java">source</a>
*/
public abstract class NonTerminal extends Etat {
  /** correspond au voisin de l'�tat. Le voisin existe toujours. 
  */
  private Etat voisin ;
  /** Cr�e un nouvel �tat non terminal avec un voisin donn�.
   *@param voisin un �tat quelconque qui deviendra l'�tat voisin du nouvel �tat.
  */   
  NonTerminal(Etat voisin) {this.voisin = voisin ;}
  /** Teste si une lettre permet de passer � l'�tat voisin.
   *@param c un caract�re quelconque.
   *@return true si et seulement si la lettre c permet 
   * de passer � l'�tat voisin.
   */     
  abstract protected boolean test(char c) ;  
  /** Retourne l'ensemble d'�tats atteints � partir 
   * de cet �tat en lisant la lettre c.
   *@param c un caract�re quelconque.
  */   
  public Set action(char c) {
    Set set = super.action(c) ; 
    if (test(c)) set.add(voisin) ;
    return set ;
  }
}
