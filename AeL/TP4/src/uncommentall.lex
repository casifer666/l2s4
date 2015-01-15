import java.io.* ;
// Fichier de description pour JFlex permettant
// de construire un analyseur lexical supprimant les
// commentaires de sources java

// classe principale
class uncommentall {
  public static void main(String arg[]) throws IOException {
    // cr�er un Yylex qui va prendre ses entr�es dans le fichier
    // de nom arg[0]
	  Yylex yy = new Yylex(new BufferedReader(new FileReader(arg[0]))) ;
	  Yytoken token ;
    // la fin de fichier est cod�e par un token null
	  while ((token = yy.yylex()) != null) System.out.print(token.image());
  }
}

// Yytoken d�fini sous la forme d'interface pour
// utiliser le polymorphisme
interface Yytoken {public String image() ;}

// token correspondant � du texte normal
class Normal implements Yytoken {
  private String image ;
  public Normal(String image) {this.image = image ;}
  public String image() {return image ;}
}

// on pourrait imaginer d'autres tokens ...

%%
%{
  private int compteurCommentaire = 0 ;
%} 

%unicode

%state COMMENTAIRE


NON_DEBUT_COMMENTAIRE=[^/]|"/"[^*/]


%% 

<YYINITIAL> {NON_DEBUT_COMMENTAIRE} {return new Normal(yytext()) ;}

<YYINITIAL> "//".* {}

<YYINITIAL> "/*" {compteurCommentaire++; yybegin(COMMENTAIRE);} 

<YYINITIAL> "*"+"/" {compteurCommentaire--;}

<COMMENTAIRE> "*"+"/" {compteurCommentaire --; yybegin(YYINITIAL);}

<COMMENTAIRE> "/*" {compteurCommentaire ++;}

<COMMENTAIRE> .|\n {}