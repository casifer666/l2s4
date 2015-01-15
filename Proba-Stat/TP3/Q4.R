n = 100; d = matrix(nrow = n,ncol = 2);

for (i in 1:n) {
	distance = 99999;
	while (distance > 1) {
		x = runif(1,-1,1); y = runif(1,-1,1);
		distance = sqrt(x^2 + y^2);
	}
	d[i,] = c(x,y);
}

plot(d)
	
