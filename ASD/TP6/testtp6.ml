open Trie

let _ =
  let t = new_trie ()
  in
  add t "banane";
  add t "citronnier";
  add t "citron";
  add t "pomme";
  add t "poire";
  add t "ci";
  print_trie t;

