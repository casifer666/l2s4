TD3 : programmation dynamique

Exercice 1 : Nombres de Catalan

Question 1.1

Voir feuille de TD

Question 1.2

Nous avons besoin des valeurs de catalan(k) pour k variant de 0 à n - 1.

Question 1.3

Le tableau doit être de taille (n + 1) avec t.(0) = 1 et t.(1) = 1.

Question 1.4

Voir fichier 'catalan.ml'

val catalan_dynamique : int -> int = <fun>

Question 1.5

Complexité en temps = (n*(n + 1))/2 => c(n) = Ɵ(n²)

Complexité en espace = n + 1 (taille du tableau).
