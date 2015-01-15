#!/bin/sh
for i in 10 20 30 40 50 60 70 80 90 100
do
  testtp1 $i > tp1-${i}.dat
done