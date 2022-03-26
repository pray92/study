#!/bin/bash

# while문으로 현 경로의 모든 파일 및 디렉토리 가져오기
list=$(ls)
num=${#list[@]}
index=0
while [ $num -ge 0 ]
do
	echo ${list[$index]}
	index=`expr $index + 1`
	num=`expr $num - 1`
done
