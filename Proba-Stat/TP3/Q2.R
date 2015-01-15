n = 100;
d = rnorm(n,0,1);
d = exp(d) - 1;
d = (d + abs(d))/2;
print(mean(d))
