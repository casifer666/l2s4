TP2 ASD : le tri rapide

Voir le fichier tris.mli ou le dossier Doc pour voir la documentation du module Tris

1 Le tri rapide

Q1 Autres exemples de tri sur place : tri par sélection, tri par insertion, tri à bulle.

Q2 Voir fichiers tris.mli et tris.ml

Q3 Voir fichiers tris.mli et tris.ml

val partitionner : tranche -> (int -> int -> int) -> tranche * tranche =
  <fun>
# let tr = { t = [|3;8;9;6;2;1;5;7;4|] ; g = 0 ; d = 8 };;  
val tr : tranche = {t = [|3; 8; 9; 6; 2; 1; 5; 7; 4|]; g = 0; d = 8}
# partitionner tr cmp ;;                                
- : tranche * tranche =
({t = [|2; 1; 3; 8; 9; 6; 5; 7; 4|]; g = 0; d = 1},
 {t = [|2; 1; 3; 8; 9; 6; 5; 7; 4|]; g = 3; d = 8})
# 

Q4 Voir fichiers tris.mli et tris.ml

val tri_rapide_tranche : tranche -> (int -> int -> int) -> unit = <fun>
# let tr = { t = [|3;8;9;6;2;1;5;7;4|] ; g = 0 ; d = 8 };;
val tr : tranche = {t = [|3; 8; 9; 6; 2; 1; 5; 7; 4|]; g = 0; d = 8}
# tri_rapide_tranche tr cmp ;;                        
- : unit = ()
# tr ;;                                                   
- : tranche = {t = [|1; 2; 3; 4; 5; 6; 7; 8; 9|]; g = 0; d = 8}
# 

Q5 Voir fichiers tris.mli et tris.ml

val tri_rapide : int array -> (int -> int -> int) -> int array = <fun>
# let tab = [|3;8;9;6;2;1;5;7;4|] ;;      
val tab : int array = [|3; 8; 9; 6; 2; 1; 5; 7; 4|]
# tri_rapide tab cmp ;; 
- : int array = [|1; 2; 3; 4; 5; 6; 7; 8; 9|]
# 

Q6 Le tri rapide d'un tableau de longueur n n'utilise pas d'espace mémoire supplémentaire de longueur (n x le nombre de tranches).

2 Sélection du pivot

2.1 Pivot aléatoire

Q7 Voir fichiers tris.mli et tris.ml

val pivot_aleatoire : tranche -> int = <fun>
# let tr = { t = [|3;8;9;6;2;1;7;5;4|] ; g = 4 ; d = 7 } ;;
val tr : tranche = {t = [|3; 8; 9; 6; 2; 1; 7; 5; 4|]; g = 4; d = 7}
# pivot_aleatoire tr ;;
- : int = 4
# pivot_aleatoire tr ;;
- : int = 5
# pivot_aleatoire tr ;;
- : int = 6
# pivot_aleatoire tr ;;
- : int = 5
# pivot_aleatoire tr ;;
- : int = 7
# pivot_aleatoire tr ;;

L'appel à cette fonction me renvoie une valeur aléatoire entre tr.g et tr.d dans la tranche tr.

Q8 Voir fichiers tris.mli et tris.ml

val partitionner :
  'a tranche -> (int -> int -> int) -> int -> tranche * tranche = <fun>

Q9 Voir fichiers tris.mli et tris.ml

val tri_rapide : int array -> (int -> int -> int) -> 'a array * int =
  <fun>

Q10 Voir fichier testtp2.ml

salla@ubuntu:~/Dropbox/ASD/TP2$ ./testtp2 > test_pivots_premiere_position_et_aleatoire.txt

Les décomptes sont stockés dans le fichier test_pivots_premiere_position_et_aleatoire.txt

Conclusion : le tri rapide avec un pivot choisi en première position ou aléatoirement ont sensiblement le même coût.

2.2 Pivot optimal

Q11 La meilleure valeur à choisir pour le pivot est la valeur médiane parmi celles du tableau.

Q12 Voir fichiers tris.mli et tris.ml

val pivot_optimal : tranche -> int = <fun>
# let tr = { t = [|3;8;9;6;2;1;7;5;4|] ; g = 4 ; d = 8 } ;;
val tr : tranche = {t = [|3; 8; 9; 6; 2; 1; 7; 5; 4|]; g = 4; d = 8}
# pivot_optimal tr ;;
- : int = 8
# pivot_optimal tr ;;
- : int = 8
# pivot_optimal tr ;;
- : int = 8
# pivot_optimal tr ;;
- : int = 8
# 

L'appel à cette fonction me renvoie l'indice de la valeur médiane des éléments du tableau compris entre tr.g et tr.d (inclus).

Q13 Voir fichiers tris.mli et tris.ml

salla@ubuntu:~/Dropbox/ASD/TP2$ ./testtp2 > test_tous_pivots.txt

Les décomptes sont stockés dans le fichier test_tous_pivots.txt

Q14 Voir fichier tp2.png

Les valeurs de base sont stockées dans le fichier gnuplot.dat

gnuplot> set title 'Evolution du nombre de comparaisons du tri rapide'          
gnuplot> set term png
Terminal type set to 'png'
Options are 'nocrop font /usr/share/fonts/truetype/ttf-liberation/LiberationSans-Regular.ttf 12 size 640,480 '
gnuplot> set output 'tp2.png'                                                   
gnuplot> plot 'gnuplot.dat' using 2:1 title 'Pivot en premiere position' w l, '' using 3:1 title 'Pivot aleatoire' w l, '' using 4:1 title 'Pivot optimal'

Conclusion : le tri rapide avec un pivot optimal est plus efficace que les deux autres variantes.

Q15 Voir fichiers tris.mli et tris.ml

Pour pouvoir compter le nombre de comparaisons dans la recherche du pivot optimal, il suffit d'ajouter en paramètre la fonction de comparaison cmp. Appelons cette fonction pivot_optimal_bis.

val pivot_optimal_bis : tranche -> (int -> int -> int) -> int = <fun>
val tri_rapide_tranche_optimal_bis : tranche -> (int -> int -> int) -> unit =
  <fun>
val tri_rapide_optimal_bis : int array -> (int -> int -> int) -> int array =
  <fun>

salla@ubuntu:~/Dropbox/ASD/TP2$ ./testtp2 > test_tous_pivots_bis

Les décomptes sont stockés dans le fichier test_tous_pivots_bis.txt et l'ensemble de tous les décomptes du TP sont stockés dans le fichier tests_totaux.txt
Le tri rapide avec choix du pivot optimal n'est plus le meilleur.

