open Facturesetcheques
open Tris

let cpt = ref 0

let cmp x y =
  cpt := !cpt +1 ;
  if x < y then 
    -1
  else if x = y then
    0
  else 
    1

let cmp_cheques c1 c2 =
  cmp (numero_facture_cheque c1) (numero_facture_cheque c2) 

let cmp_factures f1 f2 =
  cmp (numero_facture f1) (numero_facture f2) 


(** factures = tableau de factures ; cheques = tableau de cheques ; 
  * recherche = fonction de recherche d'un numero de facture dans 
  * un tableau de cheque
*)
let liste_des_factures_impayees_avec_recherche factures cheques recherche =
  let n = Array.length factures
  and factures_impayees = ref []
  in
  cpt := 0 ;
  for i = 0 to n-1 do
    if not (recherche (numero_facture factures.(i)) cheques) then
      factures_impayees := factures.(i) :: !factures_impayees
  done;
  !factures_impayees

(** 
    algorithme 1, on s'interdit tout pretraitement sur les factures et
    les cheques 
*)

let est_present_1 facture cheques =
  let trouve = ref false
  and n = Array.length cheques
  and i = ref 0 
  in
  while !i < n && not !trouve do
    if (cmp facture (numero_facture_cheque cheques.(!i))) = 0 then 
    	trouve := true ;
    i := !i + 1
  done ;
  !trouve

let liste_des_factures_impayees_1 factures cheques =
  liste_des_factures_impayees_avec_recherche factures cheques est_present_1

(** 
    algorithme 2, on s'autorise de pretraiter soit les factures, soit
    les cheques mais pas les deux
*)

(** C.U. longueur du tableau cheques strictement positive *)
let est_present_2 facture cheques =
  let n = Array.length cheques in
  let gauche = ref 0
  and droit = ref (n - 1)
  in
  while !gauche < !droit do
    let milieu = (!gauche + !droit) / 2 in
    let comparaison = cmp facture (numero_facture_cheque cheques.(milieu))
    in
    if comparaison = 0 then
    	begin
    		gauche := milieu ; 
    		droit := milieu
    	end
    else
    	if comparaison = 1 then
    		gauche := milieu + 1 
    	else
    		droit := milieu - 1
  done;
  (cmp facture (numero_facture_cheque cheques.(!gauche))) = 0

let liste_des_factures_impayees_2 factures cheques =
    liste_des_factures_impayees_avec_recherche factures (Tris.trier cheques cmp_cheques) est_present_2
  

(** 
    algorithme 3, on s'autorise de pretraiter à la fois les factures et
    les cheques
*)


let liste_des_factures_impayees_3 factures cheques =
  let f_trie = Tris.trier factures cmp_factures
  and c_trie = Tris.trier cheques cmp_cheques
  and factures_impayees = ref []
  and p = Array.length cheques
  and n = Array.length factures
  and i_f = ref 0
  and i_c = ref 0 
  in
  cpt := 0 ;
  while !i_c < p do
  	let comparaison = cmp (numero_facture f_trie.(!i_f)) (numero_facture_cheque c_trie.(!i_c)) 
  	in
    if comparaison = 0 then
    	begin
    		i_f := !i_f + 1 ; 
    		i_c := !i_c + 1
    	end
    else
    	if comparaison = -1 then
    		begin
				factures_impayees := f_trie.(!i_f) :: !factures_impayees ;
				i_f := !i_f + 1
			end
  done;
  (* on n'oublie pas les factures restantes *)
  while !i_f < n do
	factures_impayees := f_trie.(!i_f) :: !factures_impayees ;
	i_f := !i_f + 1 ;
  done;
  !factures_impayees


let _ =
  let n = int_of_string Sys.argv.(1)
  and p = int_of_string Sys.argv.(2)
  in
  let ftab = factures n
  in
  let ctab = cheques p ftab
  in
  begin
  (* impression des numeros de factures *)
  	for i = 0 to n-1 do
    	Printf.printf "%d " (numero_facture ftab.(i))
  	done;
  	Printf.printf "\n";
  (* impression des numeros de facture au dos des cheques *)
  	for i = 0 to p-1 do
    	Printf.printf "%d " (numero_facture_cheque ctab.(i))
  	done;
  	Printf.printf "\n";
  (* test methode 1 *)
  	cpt := 0;
  	ignore (liste_des_factures_impayees_1 ftab ctab) ;
  	Printf.printf "M1 : %d\n" !cpt;
  (* test methode 2 *)
  	cpt := 0;
  	ignore (liste_des_factures_impayees_2 ftab ctab) ;
  	Printf.printf "M2 : %d\n" !cpt;
  (* test methode 3 *)
  	cpt := 0;
  	ignore (liste_des_factures_impayees_3 ftab ctab) ;
  	Printf.printf "M3 : %d\n" !cpt 
  end


(**
let _ =
  let n = int_of_string Sys.argv.(1)
  in
    for p = 1 to n do
      let ftab = factures n
      in
      let ctab = cheques p ftab
      in
      Printf.printf "%d " n;
      Printf.printf "%d " p;
      cpt := 0;
      ignore (liste_des_factures_impayees_1 ftab ctab);
      Printf.printf "%d " !cpt;
      cpt := 0;
      ignore (liste_des_factures_impayees_2 ftab ctab);
      Printf.printf "%d " !cpt;
      cpt := 0;
      ignore (liste_des_factures_impayees_3 ftab ctab);
      Printf.printf "%d\n" !cpt;
    done
*)