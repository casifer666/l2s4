exception ListeVide
exception IterateurEnDebut
exception IterateurEnFin
exception IterateurIndefini

type 'a liste = {
  mutable tete     : 'a liste_interne;
  mutable queue    : 'a liste_interne;
  mutable liste_it : 'a iterateur list }
and 'a liste_interne = 
  | Vide 
  | Cons of 'a cellule 
and 'a cellule = {
  valeur : 'a;
  mutable suivant   : 'a liste_interne;
  mutable precedent : 'a liste_interne }
and 'a iterateur = {
  mutable position : 'a liste_interne;
  mutable la_liste : 'a liste;
  mutable defini : bool }


let liste_vide () = 
  { tete = Vide; queue = Vide; liste_it = [] }

let la_cellule l =
  match l with
    | Vide -> raise ListeVide
    | Cons a -> a

let ajouter_en_tete l v =
  let nouvelle_tete = { valeur = v ; suivant = l.tete ; precedent = Vide }
  in
  match l.tete with
    | Vide -> 
      l.tete <- Cons nouvelle_tete;
      l.queue <- l.tete
    | Cons ancienne_tete ->
      l.tete <- Cons nouvelle_tete;
      ancienne_tete.precedent <- l.tete

let ajouter_en_queue l v =
  let nouvelle_queue = { valeur = v ; suivant = Vide ; precedent = l.queue }
  in
  match l.queue with
    | Vide -> 
      l.queue <- Cons nouvelle_queue;
      l.tete <- l.queue
    | Cons ancienne_queue ->
      l.queue <- Cons nouvelle_queue;
      ancienne_queue.suivant <- l.queue

let imprimer_sans_iterateur l imp =
  let rec imprimer_interne li =
    match li with
      | Vide -> 
	Printf.printf "\n"
      | Cons c -> 
	imp c.valeur;
	imprimer_interne c.suivant
  in
  imprimer_interne l.tete

let imprimer_sans_iterateur_envers l imp =
  let rec imprimer_interne li =
    match li with
      | Vide -> 
	Printf.printf "\n"
      | Cons c -> 
	imp c.valeur;
	imprimer_interne c.precedent
  in
  imprimer_interne l.queue

let iterateur_en_debut l = { position = l.tete ; la_liste = l ; defini = true }

let iterateur_en_fin l = { position = l.queue ; la_liste = l ; defini = true }

let est_en_fin it = ((la_cellule it.position).suivant = Vide)

let est_en_debut it = ((la_cellule it.position).precedent = Vide)

let avancer it =
    if (it.position = Vide) then
      raise IterateurIndefini
    else
      (it.position <- (la_cellule it.position).suivant)

let reculer it =
  if (est_en_debut it) then
    raise IterateurEnDebut
  else
    (it.position <- (la_cellule it.position).precedent)

let valeur it = 
  if it.position = Vide || not (it.defini) then
    raise IterateurIndefini
  else
  ((la_cellule it.position).valeur)

let inserer_avant it e =
    let l = Cons { valeur = e ; suivant = it.position ; precedent = Vide }
    in
    if (est_en_debut it) then
      (la_cellule it.position).precedent <- l
    else
      (la_cellule l).precedent <- (la_cellule it.position).precedent;
      (la_cellule (la_cellule it.position).precedent).suivant <- l;
      (la_cellule it.position).precedent <- l

let inserer_apres it e =
	let l = Cons { valeur = e ; suivant = Vide ; precedent = it.position }
  	in
  	if (est_en_fin it) then
    	(la_cellule it.position).suivant <- l
  	else
    	(la_cellule l).suivant <- (la_cellule it.position).suivant;
    	(la_cellule (la_cellule it.position).suivant).precedent <- l;
    	(la_cellule it.position).suivant <- l

let rend_indefinis it =
	let l = it.la_liste.liste_it
	in
	for i = 0 to List.length l - 1 do
		let it_courant = List.nth l i
		in
		if not (it == it_courant) then
			(List.nth l i).defini <- false
	done

let ajouter_iterateur l =
	let it = iterateur_en_debut l
	in
	(l.liste_it <- (l.liste_it)@[it])

let la_liste_it l = l.liste_it

let ieme_iterateur l i =
  (List.nth l.liste_it i)

let supprimer it =
	if (not (it.defini)) then
		raise IterateurIndefini
	else
  	begin
      rend_indefinis it;
    	if (est_en_debut it) then
      		begin
        		(la_cellule (la_cellule it.position).suivant).precedent <- Vide;
        		it.la_liste.tete <- (la_cellule it.position).suivant
      		end
    	else
      		begin
        		if (est_en_fin it) then
        			begin
          				(la_cellule (la_cellule it.position).precedent).suivant <- Vide;
          				it.la_liste.queue <- (la_cellule it.position).precedent
        			end
        		else
        			begin
          				(la_cellule (la_cellule it.position).precedent).suivant <- (la_cellule it.position).suivant;
          				(la_cellule (la_cellule it.position).suivant).precedent <- (la_cellule it.position).precedent
        			end
      		end
  end;
  avancer it
