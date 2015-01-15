let sac_a_dos v w c =
	let t = Array.make (Array.length v) 0
	in
	t.(0) <- v.(0);
	for i = 1 to Array.length t - 1 do
		if w.(i) > c then
			t.(i) <- t.(i-1)
		else
			begin
				if (t.(i-1) + w.(i)) <= c then
					t.(i) <- t.(i-1) + v.(i)
				else
					t.(i) <- t.(i-1) 
			end
	done;
	t;;

sac_a_dos [|1;4;3|] [|1;3;2|] 4;;
