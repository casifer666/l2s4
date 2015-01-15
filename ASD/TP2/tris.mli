type tranche

(**
   [tri_fusion t cmp] tri le tableau [t] selon la fonction de
   comparaison [cmp] en utilisant l'algorithme de tri fusion
*)
val tri_fusion : 'a array -> ('a -> 'a -> int) -> 'a array

(** 
    [partitionner tr cmp ind_pivot] partitionne la tranche [tr] en deux tranches
    et retourne un couple de tranches selon la fonction de comparaison [cmp] et avec
    le pivot en position [ind_pivot]
*)
val partitionner : tranche -> (int -> int -> int) -> int -> tranche * tranche

(**
   [tri_rapide_tranche_premiere_position tr cmp] trie la tranche [tr] selon la
   fonction de comparaison [cmp] en utilisant l'algorithme
   de tri rapide avec le pivot en premiere position
*)
val tri_rapide_tranche_premiere_position : tranche -> (int -> int -> int) -> unit

(**
   [tri_rapide_premiere_position tab cmp] trie le tableau [tab] selon la fonction de
   comparaison [cmp] en utilisant l'algorithme de tri rapide avec
   le pivot en premiere position
*)
val tri_rapide_premiere_position : int array -> (int -> int -> int) -> int array

(**
   [pivot_aleatoire tab] retourne une valeur aleatoire de la tranche tab
*)
val pivot_aleatoire : tranche -> int

(**
   [tri_rapide_tranche_aleatoire tr cmp] trie la tranche [tr] selon la
   fonction de comparaison [cmp] en utilisant l'algorithme
   de tri rapide avec un pivot aleatoire
*)
val tri_rapide_tranche_aleatoire : tranche -> (int -> int -> int) -> unit

(**
   [tri_rapide_aleatoire tab cmp] trie le tableau [tab] selon la fonction de
   comparaison [cmp] en utilisant l'algorithme de tri rapide avec
   un pivot aleatoire
*)
val tri_rapide_aleatoire : int array -> (int -> int -> int) -> int array

(**
  [pivot_optimal tr] calcule le pivot optimal à choisir pour la tranche tr
*)
val pivot_optimal : tranche -> int

(**
   [tri_rapide_tranche_optimal tr cmp] trie la tranche [tr] selon la
   fonction de comparaison [cmp] en utilisant l'algorithme
   de tri rapide avec le pivot optimal
*)
val tri_rapide_tranche_optimal : tranche -> (int -> int -> int) -> unit

(**
   [tri_rapide_optimal tab cmp] trie le tableau [tab] selon la fonction de
   comparaison [cmp] en utilisant l'algorithme de tri rapide avec
   le pivot optimal
*)
val tri_rapide_optimal : int array -> (int -> int -> int) -> int array

(**
   [pivot_optimal_bis tr] calcule le pivot optimal de la tranche tr en comptant
   le nombre de comparaisons
*)
val pivot_optimal_bis : tranche -> (int -> int -> int) -> int

(**
   [tri_rapide_tranche_optimal_bis tr cmp] trie la tranche [tr] selon la fonction
   de comparaison [cmp] en utilisant l'algorithme de tri rapide et en comptant
   le nombre de comparaisons effectuées pour faire la recherche du pivot optimal
*)
val tri_rapide_tranche_optimal_bis : tranche -> (int -> int -> int) -> unit

(**
   [tri_rapide_optimal_bis tab cmp] trie le tableau [tab] selon la fonction
   de comparaison [cmp] en utilisant l'algorithme de tri rapide et en comptant
   le nombre de comparaisons effectuées pour faire la recherche du pivot optimal
*)
val tri_rapide_optimal_bis : int array -> (int -> int -> int) -> int array














