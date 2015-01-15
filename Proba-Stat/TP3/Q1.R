unif = function(n,a,b,c,d) {
	matrix(c(runif(n,a,b),runif(n,c,d)),nrow=n)
}

plot(unif(100,0,10,0,10));


