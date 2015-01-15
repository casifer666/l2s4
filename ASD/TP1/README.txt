TP1 : trois algorithmes de pointage de paiements

1 Sans prétaitement des données

Q1 Voir fichier testtp1.ml

Je me suis préalablement servi de la fonction recherche_sequentielle que j'ai implémentée. Cette fonction recherche séquentiellement l'élément passé en premier paramètre dans le tableau passé en second paramètre. Il renvoie vrai si l'élément est présent dans le tableau et faux sinon.

salla@ubuntu:~/ASD/TP1$ ./testtp1 10 6
5 3 1 9 7 6 2 8 4 0 
1 9 5 7 6 3 
2 8 4 0 

Q2 L'opérateur OP comptera le nombre de comparaisons effectuées pour rechercher chaque élément du tableau des factures dans le tableau des chèques.

Q3 Le pire des cas correspond au meilleur cas quels que soient les tableaux initialisés.

Q4 Le nombre de comparaisons c1(n,p) = p (n - p) + (p (p + 1))/2 où l'expression p (n -p) correspond aux nombres de comparaisons réalisées pour les n - p factures impayées dans le tableau de chèques de longueur p et (p (p + 1))/2 correspond aux nombres de comparaisons réalisées pour les p factures réglées (somme de 1 à p).

2 Prétaitement des factures ou des chèques

Q5 Voir fichier testtp1.ml

Je me suis préalablement servi de la fonction recherche_dichotomique que j'ai implémentée. Cette fonction recherche par une dichotomie l'élément passé en premier paramètre dans le tableau passé en second paramètre. Il renvoie vrai si l'élément est présent dans le tableau et faux sinon.

salla@ubuntu:~/ASD/TP1$ ./testtp1 10 6
3 2 7 1 5 6 9 0 4 8 
5 7 3 2 1 6 
9 0 4 8 
9 0 4 8 

Q6 Le pire des cas correspond au meilleur des cas quels que soient les tableaux initialisés. Le nombre de comparaisons peut être majoré par c2(n,p) = p (log2 (n)).

3 Prétaitement des factures et des chèques

Q7 Voir fichier testtp1.ml

La fonction de recherche utilisée ici est dans la fonction liste_des_factures_impayees_3 elle-même. C'est une recherche par comparaison 2 à 2 des éléments des tableaux de factures avec les numéros de factures de ceux du tableau de chèques.

salla@ubuntu:~/ASD/TP1$ ./testtp1 10 6 
6 1 4 9 5 3 7 8 0 2 
3 6 9 1 5 4 
7 8 0 2 
7 8 0 2 
0 2 7 8

Q8 Le pire des cas serait correspond au cas où le numéro de facture du dernier élément du tableau des chèques correspond au dernier élément du tableau des factures. Le nombre de comparaisons c3(n,p) est majoré n parce qu'on peut au pire des cas parcourir le tableau de factures en entier.

4 Recherche empirique des cas favorables

Q9 Pour pouvoir compter le nombre d'opérations OP effectuées dans chacune des trois versions, il faut incrémenter le compteur dans les fonctions de comparaisons cmp_factures et cmp_cheques.

Q10 1er cas : n > p
Prenons n = 6 et p = 4

Pour la recherche séquentielle (fonction 1) :
c1(n,p) = p (n - p) + (p (p + 1))/2
c1(6,4) = 4 (6 - 4) + (4 x 5)/2 = 8 + 10 = 18

Pour la recherche dichotomique (fonction 2) :
c2(n,p) = n (log2 (p))
c2(6,4) = 6 (log2 (4)) = 12

Pour la recherche par comparaison (fonction 3) :
c3 (n,p) = n
c3 (6,4) = 6

2e cas : n = p
n = 4 et p = 4
Le tableau des factures est : [|3;1;0;2|] et celui des chèques est : [|(3,0);(1,3);(2,2);(0,1)|]
Pour la recherche séquentielle (fonction 1) :
c1(4,4) = 4 (4 - 4) + (4 x 5)/2 = 20/2 = 10
Pour la recherche dichotomique (fonction 2) :
c2(4,4) = 4 (log2 (4)) = 4 x 2 = 8
Pour la recherche par comparaison (fonction 3) :
c3(4,4) = 4

Je constate que dans tous les cas, la recherche par comparaison est plus efficace et la recherche séquentielle est plus coûteuse en terme de complexité. Il est donc préférable d'utiliser la fonction liste_des_factures_impayees_3 pour dresser la liste des factures impayées.

Q11 Pour n = 10
salla@ubuntu:~/ASD/TP1$ ./testtp1 10
10  1 10  0  6
10  2 19 10  6
10  3 27 10  9
10  4 34 19  9
10  5 40 20  9
10  6 45 20  9
10  7 49 20  9
10  8 52 28  9
10  9 54 29 10
10 10 55 30 10

Q12 Voir fichiers tp1-10.dat, tp1-20.dat, tp1-30.dat, tp1-40.dat, tp1-50.dat, tp1-60.dat, tp1-70.dat, tp1-80.dat, tp1-90.dat et tp1-100.dat 

salla@ubuntu:~/ASD/TP1$ ./testtp1 10 > tp1-10.dat
salla@ubuntu:~/ASD/TP1$ ./testtp1 20 > tp1-20.dat
salla@ubuntu:~/ASD/TP1$ ./testtp1 30 > tp1-30.dat
salla@ubuntu:~/ASD/TP1$ ./testtp1 40 > tp1-40.dat
salla@ubuntu:~/ASD/TP1$ ./testtp1 50 > tp1-50.dat
salla@ubuntu:~/ASD/TP1$ ./testtp1 60 > tp1-60.dat
salla@ubuntu:~/ASD/TP1$ ./testtp1 70 > tp1-70.dat
salla@ubuntu:~/ASD/TP1$ ./testtp1 80 > tp1-80.dat
salla@ubuntu:~/ASD/TP1$ ./testtp1 90 > tp1-90.dat
salla@ubuntu:~/ASD/TP1$ ./testtp1 100 > tp1-100.dat

Q13 Voir fichiers tp1-10.png, tp1-20.png, tp1-30.png, tp1-40.png, tp1-50.png, tp1-60.png, tp1-70.png, tp1-80.png, tp1-90.png et tp1-100.png 

Réponse du terminal pour n = 10
salla@ubuntu:~/ASD/TP1$ gnuplot

	G N U P L O T
	Version 4.4 patchlevel 3
	last modified March 2011
	System: Linux 3.0.0-30-generic

	Copyright (C) 1986-1993, 1998, 2004, 2007-2010
	Thomas Williams, Colin Kelley and many others

	gnuplot home:     http://www.gnuplot.info
	faq, bugs, etc:   type "help seeking-assistance"
	immediate help:   type "help"
	plot window:      hit 'h'

Terminal type set to 'unknown'
gnuplot> set title '10 factures'
gnuplot> set term png
Terminal type set to 'png'
Options are 'nocrop font /usr/share/fonts/truetype/ttf-liberation/LiberationSans-Regular.ttf 12 size 640,480 '
gnuplot> set output 'tp1-10.png'
gnuplot> plot 'tp1-10.dat' using 2:3 title 'Algo 1' w l, '' using 2:4 title 'Algo 2' w l , '' using 2:5 title 'Algo 3'

En conclusion, la recherche par comparaison (algo 3) est la plus efficace des 3 pour n'importe quelle valeur de n.

