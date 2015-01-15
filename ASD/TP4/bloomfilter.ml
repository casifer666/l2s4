type 'a bloomfilter = { filter : bool array ; code : 'a -> int -> int ; nb : int}

let new_bloomfilter n f m =
	let t = Array.make (int_of_float (2.**(float_of_int n))) false
	in
	{ filter = t ; code = f ; nb = m }

let add bf e =
	for i = 0 to bf.nb - 1 do
		let indice_cle = (bf.code e i) mod (Array.length bf.filter)
		in
		bf.filter.(indice_cle) <- true
	done

let contains bf e =
	let i = ref 0
	in
	while ((!i <= bf.nb - 1) && (bf.filter.((bf.code e !i) mod (Array.length bf.filter)) = true)) do
		i := !i + 1
	done;
	!i = bf.nb
