import java.io.IOException ;
import java.io.BufferedReader ;
import java.io.InputStreamReader ;

/**
 *  classe de test d'un analyseur lexical pour JADE
 *
 *@author     Anne-C�cile Caron
 */
public class TestLexic {
  /**
   *  m�thode principale : lecture d'un flot de caract�res saisie aux clavier
   *  et affichage des unites lexicales
   *
   *@param  args             pas de param�tre attendu
   *@exception  IOException  si un probl�me de lecture
   */
  public static void main(String args[]) throws IOException {
    // cr�er un Yylex qui va prendre ses entr�es au clavier
    Yylex yy = new Yylex(new BufferedReader(new InputStreamReader(System.in)));
    System.out.println("\nBievenue dans le programme de test de l'analyseur syntaxique de Jade !\n");
    System.out.print("Jade > ");
    Yytoken ul = yy.yylex(); // la premiere unite lexicale
    while (ul.getToken() != Token.eof){
      System.out.println("Token lu : " + ul);
      System.out.print("Jade > ");
      ul = yy.yylex();
    }
    System.out.println("\n\nMerci d'avoir utilis� le programme de test de l'analyseur syntaxique de Jade !\n");
  }
}

