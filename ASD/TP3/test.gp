# on commence par definir la fonction recursive
# si n <= 0 c(n) = 0, sinon c(n) = 1 + 2 * c(n-1)
c(n) = (n<=0) ? 0 : 1 + 2 * c(n-1);
# puis on demande de la dessinner en precisant l'intervalle des
# abscisses [0:100] puis l'intervalle des ordonness [0:1e24] on ajoute
# egalement le trace de fonctions pour trouver une borne asymptotique
plot [0:100] [0:1e24] c(x) title 'Complexite', 2**x, 2*2**x;

# comme on est souvent interesse a des valeurs entieres de x, on peut
# le preciser a gnuplot
c(n) = (n<=0) ? 0 : 1 + 2 * c(n-1);
# d'abord on precise l'intervalle des abscisses
set xrange [0:10]
# puis on donne le nombre de points qu'on souhaite dans cet intervalle
set sample 11
# et enfin on trace
plot [0:100] [0:1e24] c(x) title 'Complexite', 2**x, 2*2**x;

# avec deux parametres, on definit la fonction recursive en prenant
# garde d'avoir un cas de base traitant les deux parametres
c(n,m) = (n<=0 || m <=0) ? 0 : 1 + c(n-1,m) + c(n,m-3);
# puis on trace en prenant garde au domaine de definiton, car si il y
# a de nombreux appels recursifs, cela peut prendre du temps ...
set xrange [0:10];
set sample 11;
plot c(x,x) title 'Complexite';

1 + c(n-1,m-1) + c(n,m-1) + c(n-1,m)
