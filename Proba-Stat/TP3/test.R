jours = rep(0,365);

for (i in 1:750) {
	jour = floor(runif(1,1,366));
	jours[jour] = jours[jour] + 1;
}

sum(jours > 1);
