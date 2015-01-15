type 'a liste
type 'a iterateur


exception ListeVide
exception IterateurEnDebut
exception IterateurEnFin
exception IterateurIndefini

(**
   [liste_vide] : crée une nouvelle liste vide
*)
val liste_vide : unit -> 'a liste


(** [ajouter_en_tete l e] : ajoute l'élément [e] en tête de la liste
    [l]
*)
val ajouter_en_tete : 'a liste -> 'a -> unit

(** [ajouter_en_queue l e] : ajoute l'élément [e] en queue de la liste
    [l]
*)
val ajouter_en_queue : 'a liste -> 'a -> unit

(** [ajouter_iterateur l] : ajoute un itérateur a la liste d'itérateurs
    de [l] et le positionne au début de cette liste
*)
val ajouter_iterateur : 'a liste -> unit

(**
    [la_liste_it l] : renvoie la liste des itérateurs de [l]
*)
val la_liste_it : 'a liste -> 'a iterateur list

(**
    [ieme_iterateur l i] renvoie l'iterateur se trouvant à la position [i]
    de la liste d'itérateurs [l]
*)
val ieme_iterateur : 'a liste -> int -> 'a iterateur

(** [imprimer_sans_iterateur l f] : imprime le contenu de la liste [l]
    de la tête vers la queue en utilisant la fonction d'impression [f]
*)
val imprimer_sans_iterateur : 'a liste -> ('a -> unit) -> unit

(** [imprimer_sans_iterateur_envers l f] : imprime le contenu de la
    liste [l] de la queue vers la tête en utilisant la fonction
    d'impression [f]
*)
val imprimer_sans_iterateur_envers : 'a liste -> ('a -> unit) -> unit

(** [iterateur_en_debut l] : retourne un nouvel itérateur placé en
    début de la liste [l]

    Leve l'exception ListeVide si la liste est vide. 
*)
val iterateur_en_debut : 'a liste -> 'a iterateur

(** [iterateur_en_fin l] : retourne un nouvel itérateur placé en fin
    de la liste [l]

    Leve l'exception ListeVide si la liste est vide. 
*)
val iterateur_en_fin : 'a liste -> 'a iterateur

(** [est_en_debut it] : retourne vrai si l'itérateur [it] est en tête
    de liste

    Note : l'iterateur est en debut de liste si il est positionne sur
    le premier element de la liste.
*)
val est_en_debut : 'a iterateur -> bool

(** [est_en_debut it] : retourne vrai si l'itérateur [it] est en fin
    de liste

    Note : l'iterateur est en fin de liste si il est positionne sur le
    dernier element de la liste.
*)
val est_en_fin : 'a iterateur -> bool

(** [valeur it] : retourne la valeur de l'element ou se trouve
    positionne l'iterateur [it]
*)
val valeur : 'a iterateur -> 'a

(** [avancer it] : positionne l'itérateur [it] sur l'élément suivant
    de la liste

    Lève l'exception IterateurEnFin si on est en fin de liste. Dans ce
    cas l'itérateur n'est pas modifié.
*)
val avancer : 'a iterateur -> unit

(** [reculer it] : positionne l'itérateur [it] sur l'élément précédent
    de la liste

    Leve l'exception IterateurEnDebut si on est en fin de liste. Dans ce
    cas l'itérateur n'est pas modifié.
*)
val reculer : 'a iterateur -> unit

(** [inserer_avant it e] : insère l'élément [e] avant l'élément pointé
    par l'itérateur [it]
*)
val inserer_avant : 'a iterateur -> 'a -> unit

(** [inserer_apres it e] : insère l'élément [e] après l'élément pointé
    par l'itérateur [it]
*)
val inserer_apres : 'a iterateur -> 'a -> unit

(** [supprimer it] : supprime l'élément pointé par l'itérateur.

    L'itérateur passe à l'élément suivant s'il existe, ou rend l'itérateur indéfini sinon
*)
val supprimer : 'a iterateur -> unit
