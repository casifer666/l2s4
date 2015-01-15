package src.motif ;

import java.util.Set ;
import java.util.HashSet ;
import java.util.Iterator ;
/** La _classe Automate définit__la notion d'automate
 *  associé_ à un motif.
 * @author yroos@lifl.fr
 * @version 1.12 <a HREF="./sujet/""sujet.html">TD de COO</a>, Licence d'informatique
 de Lille
 * @see <a HREF="../../src/motif/" "Automate.java">source</a>
*/
public class Automate {
  /** correspondent à l'état initial et à l'état final de l'automate. 
  */
  
  private static final char ETOILE = '*' ;
  private static final char POINT_INTERROGATION = '?' ;
  
  private Etat initial , terminal ;
  /** Crée un nouvel automate associé à un motif donné.
   *@param motif une chaine correspondant au motif définissant l'automate.
   *  Les occurences de caractères 
   * '*' et '?' y sont considérées comme des occurences de méta-caractères.
  */     
  public Automate(String motif) {
    Etat courant = new Terminal() ; terminal = courant ;
    for (int i = motif.length() - 1 ; i >= 0 ; i--)
      switch(motif.charAt(i)) {
        case ETOILE : courant.avecBoucle() ; break ;
        case POINT_INTERROGATION : courant = new AvecPoint(courant) ; break ;
        default  : courant = new AvecLettre(motif.charAt(i) , courant) ;
      }    
    initial = courant ;
  }
  /** Teste si une chaine est reconnue par l'automate.
   *@param s une chaine quelconque à tester. Les occurences de caractères 
   * '*' et '?' n'y ont aucune signification particulière.
   *@return true si et seulement si la chaine s est  
   * reconnue par l'automate.
   */         
  public boolean reconnait(String s) {
    Set courant = new HashSet() ; courant.add(initial) ;
    for (int i = 0 ; i < s.length() ; i++) {
      Set ancien = courant ; courant = new HashSet() ;
      Iterator j = ancien.iterator() ;
      while(j.hasNext()) courant.addAll(((Etat)j.next()).action(s.charAt(i))) ;
    }
    return courant.contains(terminal) ;
  }
}
    
  
  
      
      
    
  

