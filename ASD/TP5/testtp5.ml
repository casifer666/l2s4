open Listeit

let imprimer_avec_iterateur l =
  Printf.printf "Impression avec iterateurs (en avant):\n";
  let it = iterateur_en_debut l
  in
  while not (est_en_fin it) do
    Printf.printf "%d " (valeur it);
    avancer it
  done;
  Printf.printf "%d " (valeur it);
  Printf.printf "\n"

let imprimer_avec_iterateur_envers l =
  Printf.printf "Impression avec iterateurs (en arriere):\n";
  let it = iterateur_en_fin l
  in
  while not (est_en_debut it) do
    Printf.printf "%d " (valeur it);
    reculer it
  done;
  Printf.printf "%d " (valeur it);
  Printf.printf "\n"

let inserer_trie l e =
  let it = iterateur_en_debut l
  in
  while (not (est_en_fin it)) && ((valeur it) <= e) do
    avancer it
  done;
  if (est_en_fin it) then
    inserer_apres it e
  else
    inserer_avant it e


let _ =
  let l1 = liste_vide ()
  in
  ajouter_en_tete l1 1;
  ajouter_en_tete l1 2;
  ajouter_en_tete l1 3;
  ajouter_en_tete l1 4;
  imprimer_sans_iterateur l1 (Printf.printf "%d ");
  imprimer_sans_iterateur_envers l1 (Printf.printf "%d ");

  (* test 1 : les itérateurs *)
  Printf.printf "=== Test 1 - impression avec iterateurs ===\n";
  imprimer_avec_iterateur l1;
  imprimer_avec_iterateur_envers l1;

  (* test 2 : insertion avant *)
  Printf.printf "=== Test 2 - insertion avant de 10 ===\n";
  let it = iterateur_en_fin l1
  in
  reculer it;
  inserer_avant it 10;
  Printf.printf "%d\n" (valeur it);
  imprimer_avec_iterateur l1;
  imprimer_avec_iterateur_envers l1;

  (* test 3 : insertion après *)
  Printf.printf "=== Test 3 - insertion après de 100 ===\n";
  let it = iterateur_en_debut l1
  in
  avancer it;
  inserer_apres it 100;
  Printf.printf "%d\n" (valeur it);
  imprimer_avec_iterateur l1;
  imprimer_avec_iterateur_envers l1;

  (* test 4 :  insertion avant le premier element *)
  Printf.printf "=== Test 4 - insertion avant le début de 20 ===\n";
  let it = iterateur_en_debut l1
  in
  inserer_avant it 20;
  (* ajout de l'element en tete *)
  ajouter_en_tete l1 20;
  Printf.printf "%d\n" (valeur it);
  imprimer_avec_iterateur l1;
  imprimer_avec_iterateur_envers l1;
  
  (* test 5 :  insertion après le dernier element *)
  Printf.printf "=== Test 5 - insertion après la fin de 200 ===\n";
  let it = iterateur_en_fin l1
  in
  inserer_apres it 200;
  (* ajout de l'element en queue *)
  ajouter_en_queue l1 200;
  Printf.printf "%d\n" (valeur it);
  imprimer_avec_iterateur l1;
  imprimer_avec_iterateur_envers l1;

  (* test 6 : insérer trier *)
  Printf.printf "=== Test 6 - insertion d'éléments tout en conservant l'ordre croissant ===\n";
  let l2 = liste_vide ()
  in
  ajouter_en_tete l2 7;
  ajouter_en_tete l2 6;
  ajouter_en_tete l2 5;
  ajouter_en_tete l2 3;
  ajouter_en_tete l2 2;
  ajouter_en_tete l2 1;
  Printf.printf "Insertion de 4\n";
  inserer_trie l2 4;
  imprimer_avec_iterateur l2;
  imprimer_avec_iterateur_envers l2;
  Printf.printf "Insertion de 0\n";
  inserer_trie l2 0;
  ajouter_en_tete l2 0;
  imprimer_avec_iterateur l2;
  imprimer_avec_iterateur_envers l2;
  Printf.printf "Insertion de 8\n";
  inserer_trie l2 8;
  ajouter_en_queue l2 8;
  imprimer_avec_iterateur l2;
  imprimer_avec_iterateur_envers l2;

  (* test 7 :  suppression devant *)
  Printf.printf "=== Test 7 - suppression du 2e element puis de la tete ===\n";
  let it = iterateur_en_debut l1
  in
  avancer it;
  Printf.printf "suppression de %d\n" (valeur it);
  supprimer it;
  imprimer_avec_iterateur l1;
  imprimer_avec_iterateur_envers l1;
  reculer it;
  Printf.printf "suppression de %d\n" (valeur it);
  supprimer it;
  Printf.printf "valeur de it apres suppression : %d\n" (valeur it);
  imprimer_avec_iterateur l1;
  imprimer_avec_iterateur_envers l1;

  (* test 8 :  suppression derriere *)
  Printf.printf "=== Test 8 - suppression de l'avant dernier element puis de la queue ===\n";
  let it = iterateur_en_fin l1
  in
  reculer it;
  Printf.printf "suppression de %d\n" (valeur it);
  supprimer it;
  imprimer_avec_iterateur l1;
  imprimer_avec_iterateur_envers l1;
  Printf.printf "suppression de %d\n" (valeur it);
  supprimer it;
  try
    (* devrait lever l'exception IterateurIndefini *)
    Printf.printf "valeur de it apres suppression : %d\n" (valeur it);
  with
      IterateurIndefini -> begin
	Printf.printf "l'iterateur est indéfini !\n";
    end;
  imprimer_avec_iterateur l1;
  imprimer_avec_iterateur_envers l1;
  
  (* test 9 : gestion de plusieurs itérateurs *)
  Printf.printf "=== Test 9 - gestion de plusieurs iterateurs ===\n";
  Printf.printf "creation de 4 iterateurs : it1, it2, it3 et it4\n";
  ajouter_iterateur l1;
  ajouter_iterateur l1;
  ajouter_iterateur l1;
  ajouter_iterateur l1;
  let it1 = ieme_iterateur l1 0 and it2 = ieme_iterateur l1 1 and it3 = ieme_iterateur l1 2 and it4 = ieme_iterateur l1 3
  in
  imprimer_avec_iterateur l1;
  imprimer_avec_iterateur_envers l1;
  Printf.printf "suppression de %d avec it1\n" (valeur it1);
  supprimer it1;
  Printf.printf "valeur de it1 apres suppression : %d\n" (valeur it1);
  imprimer_avec_iterateur l1;
  imprimer_avec_iterateur_envers l1;
  Printf.printf "verification de l'indefinition des 3 autres iterateurs\n";
  try
    Printf.printf "valeur de it2 apres suppression : %d\n" (valeur it2);
  with | IterateurIndefini -> begin
          Printf.printf "l'iterateur it2 est indefini !\n";
        end;
  try
    Printf.printf "valeur de it3 apres suppression : %d\n" (valeur it3);
  with | IterateurIndefini -> begin
          Printf.printf "l'iterateur it3 est indefini !\n";
        end;
  try
    Printf.printf "valeur de it4 apres suppression : %d\n" (valeur it4);
  with | IterateurIndefini -> begin
          Printf.printf "l'iterateur it4 est indefini !\n";
        end;
