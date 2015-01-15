all: testtp5

listeit.cmi : listeit.mli
	ocamlc -c listeit.mli
listeit.cmo : listeit.ml listeit.cmi
	ocamlc -c listeit.ml
testtp5: testtp5.ml listeit.cmo
	ocamlc -o testtp5 listeit.cmo testtp5.ml
