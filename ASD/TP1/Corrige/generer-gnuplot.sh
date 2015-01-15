#!/bin/sh
echo set term png > com.gnuplot
for i in 10 20 30 40 50 60 70 80 90 100
do
	echo set output "'"tp1-${i}.png"'" >> com.gnuplot
	echo set title "'"${i} factures"'" >> com.gnuplot
	echo plot "'"tp1-${i}.dat"'" using 2:3 title "'"Algo 1"'" w l, "''" using 2:4 title "'"Algo 2"'" w l, "''" using 2:5 title "'"Algo 3"'" w l >> com.gnuplot
done