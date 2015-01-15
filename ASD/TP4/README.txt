TP4 ASD : les filtres de Bloom

1 Fonctions de hachage d'une chaîne de caractères

Q1 Voir le fichier 'testtp4.ml'.

val code_of_string : string -> int -> int = <fun>

2 Le module Bloomfilter

Q2 Voir le fichier 'bloomfilter.ml'

val new_bloomfilter : int -> ('a -> int -> int) -> int -> 'a bloomfilter =
  <fun>
val add : 'a bloomfilter -> 'a -> unit = <fun>
val contains : 'a bloomfilter -> 'a -> bool = <fun>

Q3 diagne@a13p12:~/Bureau/TP4$ ./testtp4
timoleon est present : true
EWyh est present : false

Q4 Le mot tiré au hasard apparaît toujours présent pour un filtre de taille 1

3 L'analyse des faux-positifs

Q5 Voir fichier 'testtp4.ml'

Q6 diagne@a10p24:~/Bureau/TP4$ ./testtp4 > res.txt

Voir fichier 'res.txt'

Q7 diagne@a10p24:~/Bureau/TP4$ gnuplot < tp4.plt

Voir fichier 'tp4.png'

