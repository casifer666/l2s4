(** une facture est modélisée par son numéro **)
type facture = int

let numero_facture f =
  f

(** un chèque est modélisée par un couple (numéro de chèque, numéro de facture) **)
type cheque = int * int

let numero_facture_cheque c  =
  snd c


(** mélange un tableau à une dimension "en place"
  * C.U. t est un tableau à une dimension
  * qui est mélangé par la fonction **)
let melange t =
  let n = Array.length t
  in
  for i = 0 to n-1 do 
    let j = (Random.int n)
    in
    let aux = t.(i) 
    in
    t.(i) <- t.(j);
    t.(j) <- aux
  done

(** retourne un tableau mélangé des n valeurs entières
  * de 0 à n-1 **)
let genere_tableau n =
  let f i = i
  in
  let t = Array.init n f
  in
  melange t ;
  t

(** retourne un tableau mélangé de factures numérotées
  * de 0 à n-1 **)
let factures n =
  genere_tableau n


(** retourne un tableau mélangé de chèques numérotés
  * de 0 à p-1 associés à p factures choisies dans 
  * un tableau f de factures.
  * C.U. la longueur du tableau f doit être supérieure 
  * ou égale à p **)
let cheques p f =
  let n = Array.length f
  and fm = Array.copy f
  in
  melange fm ;
  if p > n then
  	failwith "Le nombre de cheques doit etre inferieur au nombre de factures"
  else
    let indices = genere_tableau p
	and t = Array.make p (0,0)
    in
    for i = 0 to p-1 do
		t.(i) <- (indices.(i),fm.(indices.(i)))
    done;
    t

let _ =
  Random.self_init ()
