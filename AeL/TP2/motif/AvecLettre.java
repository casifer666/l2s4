package src.motif ;
  
/** La classe AvecLettre d�finit la notion d'�tat
 *  d'o� part une fl�che �tiquet�e par une lettre donn�e vers 
 *  vers un �tat diff�rent.
 * @author yroos@lifl.fr
 * @version .23 <a HREF="./sujet/sujet.html">TD de COO</a>, Licence d'informatique
 * @see <a HREF="../../src/motif/AvecLettre.java">source</a>
*/
public class AvecLettre extends NonTerminal {
  /** correspond � la lettre �tiquetant la fl�che vers le voisin. 
  */
   private char label ;
  /** Cr�e un nouvel AvecLettre avec un voisin donn� qu'on peut atteindre
  * avec une lettre donn�e.
   *@param label un caract�re quelconque qui �tiquette la fl�che vers le voisin.
   *@param voisin un �tat quelconque qui deviendra l'�tat voisin du nouvel �tat.
  */   
  public AvecLettre(char label , Etat voisin) {super(voisin) ; this.label = label ;}
  /** Teste si une lettre permet de passer � l'�tat voisin.
   *@param c1 un caract�re quelconque.
   *@return true si et seulement si la lettre c1 permet 
   * de passer � l'�tat voisin.
   */     
  protected boolean test(char c1) {return (c1 == label) ;}
}
