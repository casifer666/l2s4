TP3 ASD : la distance d'édition

1 Définition du problème et calcul récursif

Q1 Voir le fichier 'testtp3.ml'.

val distance_recursive : string -> string -> int = <fun>
# distance_recursive "carie" "durite";;
- : int = 3
# distance_recursive "aluminium" "albumine";;
- : int = 4
# distance_recursive "compilation" "arborescence";;
- : int = 12

Q2 L'équation de récurrence dépendant de la longueur des deux mots et donnant le nombre d'opérations d'additions dans le pire des cas est :
c(n,m) =
- 0 si n = 0 ou m = 0
- 1 + c(n-1,m-1) + c(n,m-1) + c(n-1,m) sinon

Q3 gnuplot> set term png
Terminal type set to 'png'
Options are 'nocrop font /usr/share/fonts/truetype/ttf-liberation/LiberationSans-Regular.ttf 12 '
gnuplot> set output 'distance_recursive.png'
gnuplot> c(n,m) = (n<=0 || m<=0) ? 0 : 1 + c(n-1,m-1) + c(n,m-1) + c(n-1,m);
gnuplot> set xrange[0:10];
gnuplot> set sample 11;
gnuplot> plot c(x,x) title 'Distance recursive', 4**x, 5*4**x;

Voir fichier 'distance_recursive.png'.

Une borne asymptotique de notre fonction f(x) pourrait être g(x) = 4**x. Ainsi 1*(4**x) < f(x) et 5*(4**x) > f(x).


2 Calcul par programmation dynamique de la distance

Q4 Voir fichier 'testtp3.ml'.

val construire_table : string -> string -> int array array = <fun>
val distance_dynamique : string -> string -> int = <fun>
# construire_table "carie" "durite" ;;
- : int array array =
[|[|0; 1; 2; 3; 4; 5; 6|]; [|1; 1; 2; 3; 4; 5; 6|]; [|2; 2; 2; 3; 4; 5; 6|];
  [|3; 3; 3; 2; 3; 4; 5|]; [|4; 4; 4; 3; 2; 3; 4|]; [|5; 5; 5; 4; 3; 3; 3|]|]
# distance_dynamique "carie" "durite" ;;
- : int = 3
# distance_dynamique "aluminium" "albumine" ;;
- : int = 4
# distance_dynamique "compilation" "arborescence" ;;
- : int = 12
# 

Q5 Si n = m, le nombre d'opérations d'additions dans le pire des cas est n*m = n².

Q6 La borne asymptotique est donc Θ(n²).

3 Obtention de l'alignement

Q7 Soient u = "carie", v = "durite", table = construire_table "carie" "durite"
=> |u| = 5, |v| = 6 et |table| = 6x7
Nous partons du dernier élément du tableau, à savoir table.(5).(6). Pour chaque élément table.(i).(j) de la table, il faut tester l'égalité de u.[i-1] et v.[j-1]. En partant de table.(5).(6) :
- u.[4] (e) = v.[5] (e), on n'effectue aucune opération ici car table.(5).(6) = table.(4).(5) => saut à table.(4).(5)
- u.[3] (i) ≠ v.[4] (t), ceci correspond à une opération, reste à savoir laquelle !
	- table.(4).(5) ≠ 1 + table.(3).(5) => ce n'est pas une suppression
	- table.(4).(5) ≠ 1 + table.(3).(4) => ce n'est pas une substitution
	- table.(4).(5) = 1 + table.(4).(4) => c'est une insertion de v.[4] (t) dans u entre u.[3] (i) et u.[4] (e), notre mot devient donc carite et on saute à table.(4).(4)
- u.[3] (i) = v.[3] (i), on n'effectue aucune opération ici car table.(4).(4) = table.(3).(3) => saut à table.(3).(3)
- u.[2] (r) = v.[2] (r), on n'effectue aucune opération ici car table.(3).(3) = table.(2).(2) => saut à table.(2).(2)
- u.[1] (a) ≠ v.[1] (u), ceci correspond à une opération :
  	- table.(2).(2) ≠ 1 + table.(1).(2) => ce n'est pas une suppression
 	- table.(2).(2) ≠ 1 + table.(2).(1) => ce n'est pas une substitution
  	- table.(2).(2) = 1 + table.(1).(1) => c'est une substitution de v.[1] sur u.[1], notre mot devient donc curite et on saute à table.(1).(1)
- u.[0] (c) ≠ v.[0] (d), ceci correspond à une opération :
	- table.(1).(1) ≠ 1 + table.(0).(1) => ce n'est pas une suppression
	- table.(1).(1) ≠ 1 + table.(1).(0) => ce n'est pas une insertion
	- table.(1).(1) = 1 + table.(0).(0) => c'est une substitution de v.[0] (d) dans u entre u.[0] (c) et u.[1] (a), notre mot devient donc durite et on arrive à notre point de départ, table.(0).(0)
Ainsi, la meilleure manière de passer de carie à durite est : 2 substitutions et une insertion.

Q8 Voir fichier 'testtp3.ml'.

val alignement : string -> string -> unit = <fun>

# alignement "carie" "durite" ;;
cari-e
  || |
durite
- : unit = ()
# alignement "aluminium" "albumine" ;;
al-uminium
|| ||||   
albumine--
- : unit = ()
# alignement "compilation" "arborescence" ;;
compilation--
          |  
arboresce-nce
- : unit = ()

Vérification générale des 3 fonctions depuis l'exécutable :

diagne@a10p26:~/Bureau/TP3$ make
ocamlc -o testtp3 testtp3.ml
diagne@a10p26:~/Bureau/TP3$ ./testtp3 carie durite
distance recursive = 3
distance dynamique = 3
alignement:
cari-e
  || |
durite
diagne@a10p26:~/Bureau/TP3$ ./testtp3 aluminium albumine
distance recursive = 4
distance dynamique = 4
alignement:
al-uminium
|| ||||   
albumine--
diagne@a10p26:~/Bureau/TP3$ ./testtp3 compilation arborescence
distance recursive = 12
distance dynamique = 12
alignement:
compilation--
          |  
arboresce-nce
diagne@a10p26:~/Bureau/TP3$ 
	
