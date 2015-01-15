open Facturesetcheques
open Tris

let cpt = ref 0

let cmp x y =
  cpt := !cpt + 1;
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

(** 
    algorithme 1, on s'interdit tout pretraitement sur les factures et
    les cheques 
*)

let recherche_sequentielle x c =
	let i = ref 0
	in
	while (!i <= Array.length c - 1) && (cmp (numero_facture x) (numero_facture_cheque c.(!i)) <> 0) do
		i := !i + 1
	done;
	!i <= Array.length c - 1
	
let liste_des_factures_impayees_1 f c =
	if (Array.length c) > (Array.length f) then
		failwith "liste_des_factures_impayees_1 : le nombre de cheques doit etre inferieur au nombre de factures"
	else
	let l = ref []
	in
	cpt := 0;
	for i = 0 to Array.length f - 1 do
		if ((recherche_sequentielle (f.(i)) c) = false) then
			begin
				l := (f.(i))::(!l);
			end
	done;
	(List.rev !l,!cpt)

(** 
    algorithme 2, on s'autorise de pretraiter soit les factures, soit
    les cheques mais pas les deux
*)

let recherche_dichotomique x c =
	let (d,f) = (ref 0,ref (Array.length c - 1))
	in
	while (!d < !f) do
		let m = (!d + !f)/2
		in
		if (cmp (numero_facture x) (numero_facture_cheque c.(m)) <> 0) then
			begin
				d := m + 1
			end
		else
			begin
				f := m - 1
			end
	done;
	numero_facture_cheque c.(!d) = numero_facture x 

let liste_des_factures_impayees_2 f c =
	let t = trier c cmp_cheques and l = ref []
	in
	cpt := 0;
	for i = 0 to Array.length f - 1 do
		if ((recherche_dichotomique (f.(i)) t) = false) then
			l := (f.(i))::(!l)
	done;
	(List.rev !l,!cpt)

(** 
    algorithme 3, on s'autorise de pretraiter à la fois les factures et
    les cheques
*)

let liste_des_factures_impayees_3 f c =
	let f' = trier f cmp_factures and c' = trier c cmp_cheques and l = ref [] and i = ref 0 and j = ref 0
	in
	cpt := 0;
	while (!i <= Array.length f' - 1) && (!j <= Array.length c' - 1) do
		match cmp (numero_facture (f'.(!i))) (numero_facture_cheque c'.(!j)) with
			| 0 -> i := !i + 1; j := !j + 1
			| _ -> l := (f'.(!i))::(!l); i := !i + 1
	done;
	while (!i <= Array.length f' - 1) do
		l := (f'.(!i))::(!l);
		i := !i + 1
	done;
	(List.rev !l,!cpt)

(**
   [imprimer_liste_factures l] imprime les numeros de facture de la liste l
*)

let rec imprimer_liste_factures l =
  match l with
    | [] -> 
      Printf.printf "\n"
    | f::r -> 
      Printf.printf "%d " (numero_facture f);
      imprimer_liste_factures r

let _ = 
	let n = int_of_string Sys.argv.(1)
	in
	let ftab = factures n
	in
	for i = 1 to n do
		let ctab = cheques i ftab
		in
		Printf.printf "%d %3d %4d %3d %3d\n" n i (snd (liste_des_factures_impayees_1 ftab ctab)) (snd (liste_des_factures_impayees_2 ftab ctab)) (snd (liste_des_factures_impayees_3 ftab ctab))
	done
  