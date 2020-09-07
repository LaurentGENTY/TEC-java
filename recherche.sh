#!/bin/bash

touch tmp1.txt tmp2.txt
echo build/tec/Test* > tmp1.txt
sed 's/.class//g' tmp1.txt > tmp2.txt
sed 's/build\/tec\//tec./g' tmp2.txt > tmp1.txt
cat tmp1.txt
rm tmp1.txt tmp2.txt
