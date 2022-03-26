#!/bin/bash

if [ $# -ne 2 ]
then
	echo 'Only 2 parameters required!'
	exit
fi

# [[]]를 사용한 if문
if [[ $1 > $2 ]]
then
	echo $1 'is greater than' $2
fi

# 대소 비교 명령어를 사용한 if 문
if [ $1 -gt $2 ]
then
	echo $1 is greater than $2
fi
