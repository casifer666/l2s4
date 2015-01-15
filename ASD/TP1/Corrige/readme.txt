Yves Roos - ASD groupe 4 
TP1


1) voir testtp1.ml

2) on compte les comparaisons

3) toutes les factures impayées sont au début du tableau des factures

4) (n-p)p + (p(p+1))/2

 on parcourt tout le tableau de chèques pour les n-p factures impayées
 et on atteint chacune des cases du tableau de chèques pour chacune 
 des p factures restantes.

5) voir testtp1.ml

6) toutes les factures impayées sont au début du tableau des factures

dans cette version une majoration de la recherche d'un cheque
étant donnée une facture est log2(p)+ 1, on peut donc majorer par 
n (log2(p) + 1)

7) voir testtp1.ml

8) Le pire des cas survient quand on incrémente le moins possible 
la variable i_c. On peut donc supposer toutes les factures impayées au début.
Pour ces factures impayées, on a n - p comparaisons, puis on aura 
p comparaisons dont le résultat sera 0. On peut donc majorer  le nombre
de comparaisons par n.

9) voit testtp1.ml (incrémentation du compteur par effet de bord
dans la fonction de comparaison cmp)

10) la version 3 est toujours meilleure (ou égale aux 2 autres)

11) voir testtp1.ml

12) exécuter generer-dat.sh

13) exécuter generer-gnuplot.sh et gnuplot com.gnuplot

   La version 3 est nettement meilleure. La version 2 n'est pas si mal finalement
   et la version 1 n'est vraiment pas performante.