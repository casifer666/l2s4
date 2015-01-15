type facture = int
type cheque = int * int

let factures n =
  let f i = i
  in
  let t = Array.init n f
  in
  for i = 0 to n-1 do 
    let j = (Random.int n)
    in
    let aux = t.(i) 
    in
    t.(i) <- t.(j);
    t.(j) <- aux
  done;
  t

let numero_facture f =
  f

let cheques p f =
  let n = (Array.length f)
  in
  if p > n then
    failwith "Le nombre de cheques doit etre inferieur au nombre de factures"
  else
    let indices = factures p
    and t = Array.make p (0,0)
    in
    for i = 0 to p-1 do
	t.(i) <- (indices.(i),f.(indices.(i)))
    done;
    t

let numero_facture_cheque c  =
  snd c

let _ =
  Random.self_init ()
      
	
	