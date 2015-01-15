Exercice 1

Q1 salla@ubuntu:~/Dropbox/AeL/TP2/motif$ egrep ^/ *.java
Automate.java:/** La _classe Automate d�finit__la notion d'automate
AvecLettre.java:/** La classe AvecLettre d�finit la notion d'�tat
AvecPoint.java:/** La classe AvecPoint d�finit la notion d'�tat
Etat.java:/** La classe Etat d�finit la notion la plus g�n�rale d'�tat 
NonTerminal.java:/** La classe NonTerminal d�finit la notion d'�tat non terminal
Terminal.java:/** La classe Terminal d�finit la notion d'�tat terminal

Q2 diagne@a11p12:~/Bureau/TP2/motif$ egrep ^[:space:]?p.*{[:space:]?$ *.java
Automate.java:public class Automate {
AvecLettre.java:public class AvecLettre extends NonTerminal {
AvecPoint.java:public class AvecPoint extends NonTerminal {
Etat.java:public abstract class Etat {
NonTerminal.java:public abstract class NonTerminal extends Etat {


Q3 diagne@a11p12:~/Bureau/TP2/motif$ egrep int+ *.java
Automate.java:    for (int i = motif.length() - 1 ; i >= 0 ; i--)
Automate.java:        case POINT_INTERROGATION : courant = new AvecPoint(courant) ; break ;
Automate.java:    for (int i = 0 ; i < s.length() ; i++) {
AvecPoint.java:/** La classe AvecPoint d�finit la notion d'�tat
AvecPoint.java: * @see <a HREF="../../src/motif/AvecPoint.java">source</a>
AvecPoint.java:public class AvecPoint extends NonTerminal {
AvecPoint.java:  /** Cr�e un nouvel AvecPoint avec un voisin donn�.
AvecPoint.java:  public AvecPoint(Etat voisin) {super(voisin) ;}
Etat.java:  /** Retourne l'ensemble d'�tats atteints � partir 
NonTerminal.java:  /** Retourne l'ensemble d'�tats atteints � partir  

Q4 diagne@a11p12:~/Bureau/TP2/motif$ egrep [^[:alnum:]]int[^[:alnum:]] *.java
Automate.java:    for (int i = motif.length() - 1 ; i >= 0 ; i--)
Automate.java:    for (int i = 0 ; i < s.length() ; i++) {

Q5 diagne@a11p12:~/Bureau/TP2/motif$ grep [[:alpha:]][[:alnum:]] *.java
Automate.java:package src.motif ;
Automate.java:import java.util.Set ;
Automate.java:import java.util.HashSet ;
Automate.java:import java.util.Iterator ;
Automate.java:/** La _classe Automate dfinit__la notion d'automate
Automate.java: *  associ�_ � un motif.
Automate.java: * @author yroos@lifl.fr
Automate.java: * @version 1.12 <a HREF="./sujet/""sujet.html">TD de COO</a>, Licence d'informatique
Automate.java: de Lille
Automate.java: * @see <a HREF="../../src/motif/" "Automate.java">source</a>
Automate.java:public class Automate {
Automate.java:  /** correspondent � l'tat initial et � l'tat final de l'automate. 
Automate.java:  private static final char ETOILE = '*' ;
Automate.java:  private static final char POINT_INTERROGATION = '?' ;
Automate.java:  private Etat initial , terminal ;
Automate.java:  /** Cr�e un nouvel automate associ� � un motif donn�.
Automate.java:   *@param motif une chaine correspondant au motif dfinissant l'automate.
Automate.java:   *  Les occurences de caractres 
Automate.java:   * '*' et '?' y sont consid�res comme des occurences de mta-caractres.
Automate.java:  public Automate(String motif) {
Automate.java:    Etat courant = new Terminal() ; terminal = courant ;
Automate.java:    for (int i = motif.length() - 1 ; i >= 0 ; i--)
Automate.java:      switch(motif.charAt(i)) {
Automate.java:        case ETOILE : courant.avecBoucle() ; break ;
Automate.java:        case POINT_INTERROGATION : courant = new AvecPoint(courant) ; break ;
Automate.java:        default  : courant = new AvecLettre(motif.charAt(i) , courant) ;
Automate.java:    initial = courant ;
Automate.java:  /** Teste si une chaine est reconnue par l'automate.
Automate.java:   *@param s une chaine quelconque � tester. Les occurences de caractres 
Automate.java:   * '*' et '?' n'y ont aucune signification particulire.
Automate.java:   *@return true si et seulement si la chaine s est  
Automate.java:   * reconnue par l'automate.
Automate.java:  public boolean reconnait(String s) {
Automate.java:    Set courant = new HashSet() ; courant.add(initial) ;
Automate.java:    for (int i = 0 ; i < s.length() ; i++) {
Automate.java:      Set ancien = courant ; courant = new HashSet() ;
Automate.java:      Iterator j = ancien.iterator() ;
Automate.java:      while(j.hasNext()) courant.addAll(((Etat)j.next()).action(s.charAt(i))) ;
Automate.java:    return courant.contains(terminal) ;
AvecLettre.java:package src.motif ;
AvecLettre.java:/** La classe AvecLettre dfinit la notion d'tat
AvecLettre.java: *  d'o� part une flche tiquet�e par une lettre donn�e vers 
AvecLettre.java: *  vers un tat diffrent.
AvecLettre.java: * @author yroos@lifl.fr
AvecLettre.java: * @version .23 <a HREF="./sujet/sujet.html">TD de COO</a>, Licence d'informatique
AvecLettre.java: * @see <a HREF="../../src/motif/AvecLettre.java">source</a>
AvecLettre.java:public class AvecLettre extends NonTerminal {
AvecLettre.java:  /** correspond � la lettre tiquetant la flche vers le voisin. 
AvecLettre.java:   private char label ;
AvecLettre.java:  /** Cr�e un nouvel AvecLettre avec un voisin donn� qu'on peut atteindre
AvecLettre.java:  * avec une lettre donn�e.
AvecLettre.java:   *@param label un caractre quelconque qui tiquette la flche vers le voisin.
AvecLettre.java:   *@param voisin un tat quelconque qui deviendra l'tat voisin du nouvel tat.
AvecLettre.java:  public AvecLettre(char label , Etat voisin) {super(voisin) ; this.label = label ;}
AvecLettre.java:  /** Teste si une lettre permet de passer � l'tat voisin.
AvecLettre.java:   *@param c1 un caractre quelconque.
AvecLettre.java:   *@return true si et seulement si la lettre c1 permet 
AvecLettre.java:   * de passer � l'tat voisin.
AvecLettre.java:  protected boolean test(char c1) {return (c1 == label) ;}
AvecPoint.java:package src.motif ;
AvecPoint.java:/** La classe AvecPoint dfinit la notion d'tat
AvecPoint.java: *  d'o� part une flche tiquet�e par l'alphabet tout entier 
AvecPoint.java: *  vers un tat diffrent.
AvecPoint.java: * @author yroos@lifl.fr
AvecPoint.java: * @version 24. <a HREF="./sujet/sujet.html">TD de COO</a>, Licence d'informatique
AvecPoint.java: * @see <a HREF="../../src/motif/AvecPoint.java">source</a>
AvecPoint.java:public class AvecPoint extends NonTerminal {
AvecPoint.java:  /** Cr�e un nouvel AvecPoint avec un voisin donn�.
AvecPoint.java:   *@param voisin un tat quelconque qui deviendra l'tat voisin du nouvel tat.
AvecPoint.java:  public AvecPoint(Etat voisin) {super(voisin) ;}
AvecPoint.java:  /** Teste si une lettre permet de passer � l'tat voisin.
AvecPoint.java:   *@param c un caractre quelconque.
AvecPoint.java:   *@return toujours true.
AvecPoint.java:  protected boolean test(char c) {return true ;}
Etat.java:package src.motif ;
Etat.java:import java.util.Set ;
Etat.java:import java.util.HashSet ;
Etat.java:/** La classe Etat dfinit la notion la plus g�nrale d'tat 
Etat.java: *  d'un automate associ� � un motif.
Etat.java: * @author yroos@lifl.fr
Etat.java: * @version 2.3.4 <a HREF="./sujet/sujet.html">TD de COO</a>, Licence d'informatique
Etat.java: * @see <a HREF="../../src/motif/Etat.java">source</a>
Etat.java:public abstract class Etat {
Etat.java:  /** Indique l'existence ou non d'une boucle.
Etat.java:   * Un tat est sans boucle � la cration. 
Etat.java:  private boolean avec_boucle = false ;
Etat.java:  /** Ajoute une boucle tiquet�e par l'alphabet tout entier � l'tat */
Etat.java:  public void avecBoucle() {avec_boucle = true ;} 
Etat.java:  /** Retourne l'ensemble d'tats atteints � partir 
Etat.java:   * de cet tat en lisant la lettre c.
Etat.java:   *@param c un caractre quelconque.
Etat.java:  public Set action(char c) {
Etat.java:    Set set = new HashSet() ;
Etat.java:    if (avec_boucle) set.add(this) ;
Etat.java:    return set ;
NonTerminal.java:package src.motif ;
NonTerminal.java:import java.util.Set ;
NonTerminal.java:/** La classe NonTerminal dfinit la notion d'tat non terminal
NonTerminal.java: *  d'un automate associ� � un motif. Il s'agit d'tats d'o� part
NonTerminal.java: * une (unique) flche vers un tat diffrent appel� voisin.
NonTerminal.java: * @author yroos@lifl.fr
NonTerminal.java: * @version  . <a HREF="./sujet/sujet.html">TD de COO</a>, Licence d'informatique
NonTerminal.java: * @see <a HREF="../../src/motif/NonTerminal.java">source</a>
NonTerminal.java:public abstract class NonTerminal extends Etat {
NonTerminal.java:  /** correspond au voisin de l'tat. Le voisin existe toujours. 
NonTerminal.java:  private Etat voisin ;
NonTerminal.java:  /** Cr�e un nouvel tat non terminal avec un voisin donn�.
NonTerminal.java:   *@param voisin un tat quelconque qui deviendra l'tat voisin du nouvel tat.
NonTerminal.java:  NonTerminal(Etat voisin) {this.voisin = voisin ;}
NonTerminal.java:  /** Teste si une lettre permet de passer � l'tat voisin.
NonTerminal.java:   *@param c un caractre quelconque.
NonTerminal.java:   *@return true si et seulement si la lettre c permet 
NonTerminal.java:   * de passer � l'tat voisin.
NonTerminal.java:  abstract protected boolean test(char c) ;  
NonTerminal.java:  /** Retourne l'ensemble d'tats atteints � partir 
NonTerminal.java:   * de cet tat en lisant la lettre c.
NonTerminal.java:   *@param c un caractre quelconque.
NonTerminal.java:  public Set action(char c) {
NonTerminal.java:    Set set = super.action(c) ; 
NonTerminal.java:    if (test(c)) set.add(voisin) ;
NonTerminal.java:    return set ;
Terminal.java:package src.motif ;
Terminal.java:/** La classe Terminal dfinit la notion d'tat terminal
Terminal.java: *  d'un automate associ� � un motif. Elle concrtise la classe
Terminal.java: *  abstraite Etat sans possder de fonctionnalit� supplmentaire.
Terminal.java: * @author yroos@lifl.fr
Terminal.java: * @version <a HREF="./sujet/sujet.html">TD de COO</a>, Licence d'informatique
Terminal.java: * @see <a HREF="../../src/motif/Terminal.java">source</a>
Terminal.java:public class Terminal extends Etat {}

Q6 diagne@a11p12:~/Bureau/TP2/motif$ egrep [^[:lower:]][[:upper:]]+[^[:lower:]] *.java
Automate.java: * @version 1.12 <a HREF="./sujet/""sujet.html">TD de COO</a>, Licence d'informatique
Automate.java: * @see <a HREF="../../src/motif/" "Automate.java">source</a>
Automate.java:  private static final char ETOILE = '*' ;
Automate.java:  private static final char POINT_INTERROGATION = '?' ;
Automate.java:        case ETOILE : courant.avecBoucle() ; break ;
Automate.java:        case POINT_INTERROGATION : courant = new AvecPoint(courant) ; break ;
AvecLettre.java: * @version .23 <a HREF="./sujet/sujet.html">TD de COO</a>, Licence d'informatique
AvecLettre.java: * @see <a HREF="../../src/motif/AvecLettre.java">source</a>
AvecPoint.java: * @version 24. <a HREF="./sujet/sujet.html">TD de COO</a>, Licence d'informatique
AvecPoint.java: * @see <a HREF="../../src/motif/AvecPoint.java">source</a>
Etat.java: * @version 2.3.4 <a HREF="./sujet/sujet.html">TD de COO</a>, Licence d'informatique
Etat.java: * @see <a HREF="../../src/motif/Etat.java">source</a>
NonTerminal.java: * @version  . <a HREF="./sujet/sujet.html">TD de COO</a>, Licence d'informatique
NonTerminal.java: * @see <a HREF="../../src/motif/NonTerminal.java">source</a>
Terminal.java: * @version <a HREF="./sujet/sujet.html">TD de COO</a>, Licence d'informatique
Terminal.java: * @see <a HREF="../../src/motif/Terminal.java">source</a>

Exercice 2

Q1 egrep "<"[[:alpha:]] *.html

Q2 diagne@a11p12:~/Bureau/TP2/html$ egrep [[:space:]][[:digit:]]+[[[:space:]] *.html
planning.html:<!-- semaine 1 -->
planning.html:  Cours 1 : Logique propositionnelle. (<a
planning.html:<!-- semaine 2 -->
planning.html:  Cours 2 : Logique propositionnelle, suite et fin. (<a
planning.html:<!-- semaine 3 -->
planning.html:  Cours 3 : Logique des pr�dicats. (<a
planning.html:<!-- semaine 4 -->
planning.html:Cours 4 : Exemples d'introduction aux automates.
planning.html:<!-- semaine 5 -->
planning.html:Cours 5 : <a href="http://www.lifl.fr/~yroos/al/cours/c5.pdf">D�finitions et 
planning.html:<!-- semaine 6 -->
planning.html:Seul le groupe 1 a pu faire TD. 
planning.html:<!-- semaine 7 -->
planning.html:Seul le groupe 1 a pu faire TD
planning.html:<!-- semaine 8 -->
planning.html:<!-- semaine 9 -->
planning.html:<!-- semaine 10 -->
planning.html:<!-- semaine 11 -->
planning.html:Pas de cours : blocage vot� lors de l'AG �tudiante du 10 avril.
planning.html: 9 h pour r�fl�chir � l'organisation de la fin de l'ann�e.
planning.html:<tr><td>-</td><td>16 et 17 du 17/04 au
planning.html:<!-- semaine 12 -->
planning.html:<!-- semaine 13 -->
planning.html:lundi 8 mai f�ri
planning.html:<!-- semaine 14 -->
planning.html:<!-- semaine 15 -->
planning.html:jeudi 25 mai f�ri�</td>
planning.html:<!-- semaine 16 -->
planning.html:TP 4 : Analyse lexicale avec l'outil JLex. 
planning.html:<!-- semaine 17 -->
yroos.html:           59655 Villeneuve d'Ascq Cedex, FRANCE

