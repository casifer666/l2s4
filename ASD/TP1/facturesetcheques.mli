type facture
type cheque

(**
   [factures n] genere un tableau de [n] factures
*)
val factures : int -> facture array

(** 
    [numero_facture f] retourne le numero de la facture [f]
*)
val numero_facture : facture  -> int

(** 
    [cheques p f] genere un tableau de [p] cheques au dos desquels est
    inscrit un des numeros de facture du tableau de factures [f]

    Note: si p est plus grand que n une exception est levee.
*)
val cheques : int -> facture array -> cheque array

(** 
    [numero_facture c] retourne le numero de la facture se trouvant
    au dos cheque [c]
*)
val numero_facture_cheque : cheque  -> int
