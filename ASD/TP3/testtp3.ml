(* version recursive *)
let rec distance_recursive u v =  
	let n = String.length u and m = String.length v
	in
	if n = 0 then
		m
	else
	if m = 0 then
		n
	else
	if u.[0] = v.[0] then
		let u' = String.sub u 1 (n - 1) and v' = String.sub v 1 (m - 1)
		in
		distance_recursive u' v'
	else
		let u' = String.sub u 1 (n - 1) and v' = String.sub v 1 (m - 1)
		in
		1 + (min (min (distance_recursive u' v') (distance_recursive u v')) (distance_recursive u' v))


(* construction de la table *)
let construire_table u v =
	let n = String.length u and m = String.length v
	in
	let table = Array.make_matrix (n + 1) (m + 1) 0
	in
	for i = 0 to n do
		for j = 0 to m do
			if i = 0 then
				table.(i).(j) <- j
			else
			if j = 0 then
				table.(i).(j) <- i
			else
			if u.[i-1] = v.[j-1] then
				table.(i).(j) <- table.(i-1).(j-1)
			else
			table.(i).(j) <- 1 + min (min table.(i-1).(j-1) table.(i).(j-1)) table.(i-1).(j)
		done;
	done;
	table


(* version programmation dynamique *)
let distance_dynamique u v =
	let n = String.length u and m = String.length v and table = construire_table u v
	in
	table.(n).(m)


(* affichage de l'alignement *)
let alignement u v =
	let n = String.length u and m = String.length v and u' = ref "" and v' = ref "" and sub = ref ""
	in
	let table = construire_table u v and i = ref n and j = ref m
	in
	while (table.(!i).(!j) <> 0) || (!i <> 0) || (!j <> 0)  do
		if !i = 0 then
			begin
				v' := (String.make 1 v.[!j-1])^(!v');
				u' := "-"^(!u');
				sub := " "^(!sub);
				j := !j - 1
			end
		else
		if !j = 0 then
			begin
				u' := (String.make 1 u.[!i-1])^(!u');
				v' := "-"^(!v');
				sub := " "^(!sub);
				i := !i - 1
			end
		else
		if u.[!i-1] = v.[!j-1] then
			begin
				u' := (String.make 1 u.[!i-1])^(!u');
				v' := (String.make 1 v.[!j-1])^(!v');
				sub := "|"^(!sub);
				i := !i - 1;
				j := !j - 1
			end
		else
			begin
				if  table.(!i).(!j) = 1 + table.(!i).(!j-1) then
					begin
						u' := "-"^(!u');
						v' := (String.make 1 v.[!j-1])^(!v');
						sub := " "^(!sub);
						j := !j - 1
					end
				else
					if table.(!i).(!j) = 1 + table.(!i-1).(!j) then
						begin
							u' := (String.make 1 u.[!i-1])^(!u');
							v' := "-"^(!v');
							sub := " "^(!sub);
							i := !i - 1
						end
					else
						begin
							u' := (String.make 1 u.[!i-1])^(!u');
							v' := (String.make 1 v.[!j-1])^(!v');
							sub := " "^(!sub);
							i := !i - 1;
							j := !j - 1
						end
			end
	done;
	Printf.printf "%s\n%s\n%s\n" !u' !sub !v'


(* test *)
let _ =
  let u = Sys.argv.(1)
  and v = Sys.argv.(2)
  in
  Printf.printf "distance recursive = %d\n" (distance_recursive u v);
  Printf.printf "distance dynamique = %d\n" (distance_dynamique u v);
  Printf.printf "alignement:\n"; alignement u v
  