all: testtp1

facturesetcheques.cmi: facturesetcheques.mli
	ocamlc -c facturesetcheques.mli
facturesetcheques.cmo: facturesetcheques.cmi facturesetcheques.ml
	ocamlc -c facturesetcheques.ml
tris.cmi : tris.mli
	ocamlc -c tris.mli
tris.cmo : tris.cmi tris.ml
	ocamlc -c tris.ml
testtp1 : testtp1.ml tris.cmo facturesetcheques.cmo
	ocamlc -o testtp1 tris.cmo facturesetcheques.cmo testtp1.ml


clean:
	rm *.cmi *.cmo testtp1 *~