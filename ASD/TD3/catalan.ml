let cpt = ref 0

let rec catalan_recursif n =
	if n = 0 || n = 1 then
		1
	else
		let somme = ref 0
		in
		for k = 0 to n - 1 do
			somme := !somme + ((catalan_recursif (n - k - 1)) * (catalan_recursif k));
			cpt := !cpt + 1
		done;
		!somme;;
		
let catalan_dynamique n =
	let table = Array.make (n+1) 1
	in
	for i = 1 to n do
		let somme = ref 0
		in
		for j = 0 to i - 1 do
			somme := !somme + (table.(j) * table.(i-j-1));
			cpt := !cpt + 1
		done;
		table.(i) <- !somme;
	done;
	table.(n)
	
let _ =
	let n = int_of_string Sys.argv.(1)
	in
	let c1 = catalan_recursif n
	in
	let cpt1 = !cpt
	in
	cpt := 0;
	let c2 = catalan_dynamique n
	in
	let cpt2 = !cpt
	in
	cpt := 0;
	Printf.printf "catalan_recursif : %d | %d\ncatalan_dynamique : %d | %d\n" c1 cpt1 c2 cpt2
