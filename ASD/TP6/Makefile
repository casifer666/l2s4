trie.cmi : trie.mli
	ocamlc -c trie.mli
trie.cmo : trie.ml trie.cmi
	ocamlc -c trie.ml

testtp6: testtp6.ml trie.cmo
	ocamlc -o testtp6 trie.cmo testtp6.ml

figure: testtp6
	./testtp6 > arbre.dot
	dot arbre.dot -Tpng -oarbrea.png
