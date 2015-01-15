type 'a bloomfilter

(**
   [new_bloomfilter n f m] : cree un nouveau filtre de bloom de taille 2^[n] avec [m] fonction de hachage [f]
*)
val new_bloomfilter : int -> ('a -> int -> int) -> int -> 'a bloomfilter


(**
   [add s] : ajoute la cle [s] au filtre de bloom
*)
val add : 'a bloomfilter -> 'a -> unit

(**
   [contains s] : test la presence de la cle [s] dans le filtre de bloom
*)
val contains : 'a bloomfilter -> 'a -> bool
