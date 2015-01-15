package src.motif ;
  
/** La classe AvecPoint d�finit la notion d'�tat
 *  d'o� part une fl�che �tiquet�e par l'alphabet tout entier 
 *  vers un �tat diff�rent.
 * @author yroos@lifl.fr
 * @version 24. <a HREF="./sujet/sujet.html">TD de COO</a>, Licence d'informatique
 * @see <a HREF="../../src/motif/AvecPoint.java">source</a>
*/
public class AvecPoint extends NonTerminal {
  /** Cr�e un nouvel AvecPoint avec un voisin donn�.
   *@param voisin un �tat quelconque qui deviendra l'�tat voisin du nouvel �tat.
  */   
  public AvecPoint(Etat voisin) {super(voisin) ;}
  /** Teste si une lettre permet de passer � l'�tat voisin.
   *@param c un caract�re quelconque.
   *@return toujours true.
   */       
  protected boolean test(char c) {return true ;}
}
