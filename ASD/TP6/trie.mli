type trie

(**
   new_trie : cree un nouveau trie, sans mot
*)
val new_trie : unit -> trie


(**
   add [t] [w] : ajoute le mot [w] au trie [t]
*)
val add : trie -> string -> unit

(**
   contains [t] [w] : vrai si le mot [w] est dans [t]
*)
val contains : trie -> string -> bool


(**
   print_tree [t] : imprime le trie [t] en suivant la syntaxe graphviz
*)
val print_trie : trie -> unit
