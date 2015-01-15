open Tris;;
open Genere;;

let cpt = ref 0

let cmp a b =
  cpt := !cpt + 1;
  if a = b then
    0
  else if a < b then
    -1
  else
    1


let test_pivot_premiere_position_et_pivot_aleatoire =
	let somme1 = ref 0 and somme2 = ref 0
	in
	Printf.printf "\nNOMBRES DE COMPARAISONS PIVOTS PREMIERE POSITION ET ALEATOIRE :\n\nlongueur du tableau / pivot premiere position / pivot aleatoire\n";
	for i = 1 to 100 do
		let t = Genere.tableau_aleatoire i
		in
		let t1 = Array.copy t and t2 = Array.copy t
		in
		ignore (tri_rapide_premiere_position t1 cmp);
		somme1 := !somme1 + !cpt;
		let cpt1 = !cpt
		in
		cpt := 0;
		ignore (tri_rapide_aleatoire t2 cmp);
		somme2 := !somme2 + !cpt;
		let cpt2 = !cpt
		in
		Printf.printf "%10d %23d %22d\n" i cpt1 cpt2;
		cpt := 0;
	done;
	Printf.printf "\nMOYENNES DES COMPARAISONS :\n\npivot premiere position / pivot aleatoire\n%12d %22d\n\n********************************************************************************\n\n" (!somme1/100) (!somme2/100)


let test_tous_pivots =
	let somme1 = ref 0 and somme2 = ref 0 and somme3 = ref 0
	in
	Printf.printf "NOMBRES DE COMPARAISONS TOUS PIVOTS  :\n\nlongueur du tableau / pivot premiere position / pivot aleatoire / pivot optimal\n";
	for i = 1 to 100 do
		let t = Genere.tableau_aleatoire i
		in
		let t1 = Array.copy t and t2 = Array.copy t and t3 = Array.copy t
		in
		ignore (tri_rapide_premiere_position t1 cmp);
		somme1 := !somme1 + !cpt;
		let cpt1 = !cpt
		in
		cpt := 0;
		ignore (tri_rapide_aleatoire t2 cmp);
		somme2 := !somme2 + !cpt;
		let cpt2 = !cpt
		in
		cpt := 0;
		ignore (tri_rapide_optimal t3 cmp);
		somme3 := !somme3 + !cpt;
		let cpt3 = !cpt
		in 
		Printf.printf "%10d %23d %22d %15d\n" i cpt1 cpt2 cpt3;
		cpt := 0;
	done;
	Printf.printf "\nMOYENNES DES COMPARAISONS :\n\npivot premiere position / pivot aleatoire / pivot optimal\n%12d %22d %15d\n\n********************************************************************************\n\n" (!somme1/100) (!somme2/100) (!somme3/100)


let test_tous_pivots_bis =
	let somme1 = ref 0 and somme2 = ref 0 and somme3 = ref 0
	in
	Printf.printf "NOMBRES DE COMPARAISONS TOUS PIVOTS AVEC CMP PIVOT OPTIMAL :\n\nlongueur du tableau / pivot premiere position / pivot aleatoire / pivot optimal\n";
	for i = 1 to 100 do
		let t = Genere.tableau_aleatoire i
		in
		let t1 = Array.copy t and t2 = Array.copy t and t3 = Array.copy t
		in
		ignore (tri_rapide_premiere_position t1 cmp);
		somme1 := !somme1 + !cpt;
		let cpt1 = !cpt
		in
		cpt := 0;
		ignore (tri_rapide_aleatoire t2 cmp);
		somme2 := !somme2 + !cpt;
		let cpt2 = !cpt
		in
		cpt := 0;
		ignore (tri_rapide_optimal_bis t3 cmp);
		somme3 := !somme3 + !cpt;
		let cpt3 = !cpt
		in 
		Printf.printf "%10d %23d %22d %15d\n" i cpt1 cpt2 cpt3;
		cpt := 0;
	done;
	Printf.printf "\nMOYENNES DES COMPARAISONS :\n\npivot premiere position / pivot aleatoire / pivot optimal\n%12d %22d %15d\n" (!somme1/100) (!somme2/100) (!somme3/100)

