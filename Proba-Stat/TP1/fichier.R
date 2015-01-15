taille=c(168,175,172,183)

poids=c(67,75,69,81)

taille_et_poids=data.frame(cbind(taille,poids),row.names=c("A","B","C","D"))

x=1:20

y=seq(from=1,to=10,by=0.5)

z=rep(2,12)

s=c(rep("A",12),rep("B",12),rep("C",12))

sample(0:1,1)

bernoulli = function(n)
{
	sample(0:1,n,replace=TRUE)
}
