TP5 : listes avec itérateurs

1 La liste doublement chaînée

Q1 La définition de liste_interne permet de faire référence à une cellule de la liste.

Q2 La fonction la_cellule permet d'accéder à la cellule de la liste.

2 Création des itérateurs

Q3 Voir le fichier 'listeit.ml'

'a iterateur = {
  mutable position : 'a cellule;
  mutable la_liste : 'a liste;
}

Q4 Voir le fichier 'listeit.ml'

val iterateur_en_debut : 'a liste -> 'a iterateur = <fun>
val iterateur_en_fin : 'a liste -> 'a iterateur = <fun>
val est_en_fin : 'a iterateur -> bool = <fun>
val est_en_debut : 'a iterateur -> bool = <fun>
val avancer : 'a iterateur -> unit = <fun>
val reculer : 'a iterateur -> unit = <fun>
val valeur : 'a iterateur -> 'a = <fun>

Q5 Voir le fichier 'testtp5.ml'

val imprimer_avec_iterateur : int Listeit.liste -> unit = <fun>
val imprimer_avec_iterateur_envers : int Listeit.liste -> unit = <fun>

salla@ubuntu:~/Documents/TP5$ ./testtp5
4 3 2 1 
1 2 3 4 

Q6 Voir le fichier 'testtp5.ml'

=== Test 1 - impression avec iterateurs ===
Impression avec iterateurs (en avant):
4 3 2 1 
Impression avec iterateurs (en arriere):
1 2 3 4 

3 Insertion avec des itérateurs

Q7 Voir le fichier 'listeit.ml'

val inserer_avant : 'a iterateur -> 'a -> unit = <fun>
val inserer_apres : 'a iterateur -> 'a -> unit = <fun>

Q8 Voir le fichier 'testtp5.ml'

=== Test 2 - insertion avant de 10 ===
2
Impression avec iterateurs (en avant):
4 3 10 2 1 
Impression avec iterateurs (en arriere):
1 2 10 3 4 
=== Test 3 - insertion après de 100 ===
3
Impression avec iterateurs (en avant):
4 3 100 10 2 1 
Impression avec iterateurs (en arriere):
1 2 10 100 3 4 

Q9 === Test 4 - insertion avant le début de 20 ===
4
Impression avec iterateurs (en avant):
4 3 100 10 2 1 
Impression avec iterateurs (en arriere):
1 2 10 100 3 4 20 
=== Test 5 - insertion après la fin de 200 ===
1
Impression avec iterateurs (en avant):
4 3 100 10 2 1 200 
Impression avec iterateurs (en arriere):
1 2 10 100 3 4 20 

Je constate que 20 et 200 ne s'impriment pas pour l'une des deux fonctions d'impression. Ceci est dû au fait que la liste est définie par une tête et une queue, et si l'on insère un élément en début ou en fin de liste, il faut changer la tête ou la queue de la liste en le nouvel élément inséré. Et donc :
- lorsqu'on insère 20 en début de liste, il y a une nécessité de mettre à jour la tête de la liste
- lorsqu'on insère 200 au fin de liste, il y a une nécessité de mettre à jour la queue de la liste
Pour remédier à ce problème, il faut faire appel à la fonction ajouter_en_tete pour 20 et une fonction ajouter_en_queue que j'ai créée pour 200.

=== Test 4 - insertion avant le début de 20 ===
4
Impression avec iterateurs (en avant):
20 4 3 100 10 2 1 
Impression avec iterateurs (en arriere):
1 2 10 100 3 4 20 
=== Test 5 - insertion après la fin de 200 ===
1
Impression avec iterateurs (en avant):
20 4 3 100 10 2 1 200 
Impression avec iterateurs (en arriere):
200 1 2 10 100 3 4 20 

Q10 Voir le fichier 'testtp5.ml'

val inserer_trie : 'a Listeit.liste -> 'a -> 'a Listeit.liste = <fun>

Q11 Voir le fichier 'testtp5.ml'

=== Test 6 - insertion d'éléments tout en conservant l'ordre croissant ===
Insertion de 4
Impression avec iterateurs (en avant):
1 2 3 4 5 6 7 
Impression avec iterateurs (en arriere):
7 6 5 4 3 2 1 
Insertion de 0
Impression avec iterateurs (en avant):
0 1 2 3 4 5 6 7 
Impression avec iterateurs (en arriere):
7 6 5 4 3 2 1 0 
Insertion de 8
Impression avec iterateurs (en avant):
0 1 2 3 4 5 6 7 8 
Impression avec iterateurs (en arriere):
8 7 6 5 4 3 2 1 0 

4 Suppression avec des itérateurs

Q12 Rien à faire !

Q13 Voir le fichier 'listeit.ml'

exception IterateurIndefini

Q14 Les fonctions à modifier sont : avancer et valeur.

Q15 Voir le fichier 'listeit.ml'

val supprimer : 'a iterateur -> unit = <fun>

Q16 Voir le fichier 'testtp5.ml'

=== Test 7 - suppression du 2e element puis de la tete ===
suppression de 4
Impression avec iterateurs (en avant):
20 3 100 10 2 1 200 
Impression avec iterateurs (en arriere):
200 1 2 10 100 3 20 
suppression de 20
valeur de it apres suppression : 3
Impression avec iterateurs (en avant):
3 100 10 2 1 200 
Impression avec iterateurs (en arriere):
200 1 2 10 100 3 
=== Test 8 - suppression de l'avant dernier element puis de la queue ===
suppression de 1
Impression avec iterateurs (en avant):
3 100 10 2 200 
Impression avec iterateurs (en arriere):
200 2 10 100 3 
suppression de 200
l'itérateur est indéfini !
Impression avec iterateurs (en avant):
3 100 10 2 
Impression avec iterateurs (en arriere):
2 10 100 3 

Gestion de plusieurs itérateurs

Q17 Voir fichiers 'listeit.ml' et 'testtp5.ml'

Q18 Une solution serait d'ajouter un champ booléen au type iterateur qui permet
de renseigner sur la validité de l'itérateur en question et de définir une liste
comportant l'ensemble des itérateurs de la grande liste. Ainsi, si une suppression d'un
élément de la liste est effectuée avec un itérateur donné, il sera nécessaire
"d'indéfinir" tous les autres itérateurs de la liste.

Q19 Voir les fichiers 'listeit.ml' et 'testtp5.ml'

=== Test 9 - gestion de plusieurs iterateurs ===
Impression avec iterateurs (en avant):
3 100 10 2 
Impression avec iterateurs (en arriere):
2 10 100 3 
suppression de 3 avec it1
valeur de it1 apres suppression : 100
Impression avec iterateurs (en avant):
100 10 2 
Impression avec iterateurs (en arriere):
2 10 100 
verification de l'indefinition des 3 autres iterateurs
l'iterateur it2 est indefini !
l'iterateur it3 est indefini !
l'iterateur it4 est indefini !



