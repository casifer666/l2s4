/**
 *  Table des symboles
 *
 *@author     Anne-Cecile Caron
 */
public class TabSymboles {
  
  java.util.Map<String,java.util.LinkedList<Yytoken>> laTable = new java.util.HashMap<String,java.util.LinkedList<Yytoken>>();


  /**
   *  Permet de sauver une variable dans la table
   *
   *@param  variable  nom de la variable
   *@param  valeur    liste des unites lexicales a associer a cette variable
   */
  public void sauver(String variable, java.util.LinkedList<Yytoken> liste) {
    laTable.put(variable, liste);
  }


  /**
   *  Permet de relire la valeur associee a une variable
   *
   *@param  variable             Le nom de la variable
   *@return                      La liste associee (ou null si la variable est inconnue)
   */
  public java.util.LinkedList<Yytoken> lire(String variable) {
    return laTable.get(variable);
  }

}