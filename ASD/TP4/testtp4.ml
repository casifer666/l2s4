open Bloomfilter

let nb_hash_functions = 8

let random_tab = Array.make (128 * nb_hash_functions) 0

let init_random_tab () =
  Random.self_init ();
  for i = 0 to 127 do
    for j = 0 to nb_hash_functions - 1 do
      random_tab.(j*128+i) <- (Random.int 32000)
    done;
  done

let code_of_string str n =
	let somme = ref 0
	in
	for i = 0 to String.length str - 1 do
		somme := !somme + random_tab.(128*n+int_of_char(str.[i]))
	done;
	!somme

let random_word () =
  let letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWYXZ"
  and length = 4 + Random.int 4
  in
  let str = String.create length
  in
  for i = 0 to length - 1 do
    str.[i] <- letters.[(Random.int 51)]
  done;
  str

(*
let _ = 
  init_random_tab ();
  (* creation du filtre *)
  let bf = new_bloomfilter 1 code_of_string 8	
  and s = random_word ()
  in
  add bf "timoleon";
  Printf.printf "timoleon est present : %b\n" (contains bf "timoleon");
  Printf.printf "%s est present : %b\n" s (contains bf s)
*)

let _ =
	init_random_tab();
	let i = Hashtbl.create (int_of_float (2.**10.))
	in
	for b = 0 to 1023 do
		let s = random_word()
		in
		Hashtbl.add i s s;
	done;
	for n = 1 to 8 do
		for t = 10 to 20 do
			let cptm = ref 0 and cptf = ref 0 and bf = new_bloomfilter t code_of_string n
			in
			let f a b = add bf a;
			in
			Hashtbl.iter f i;
			for k = 1 to (int_of_float (2.**14.)) do
				let u = random_word()
				in
				if not (Hashtbl.mem i u) then
					begin
						cptm := !cptm + 1;
						if contains bf u then
						cptf := !cptf + 1
					end
			done;
			Printf.printf "%d %d %d %5d %6f\n" t n !cptm !cptf ((float_of_int (!cptf))/.(float_of_int (!cptm)));
		done;
		Printf.printf "\n\n";
	done
