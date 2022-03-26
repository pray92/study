#!/bin/bash

if [ $# -ne 1 ]
then
	echo Only 1 paramter required!
	exit
fi

if [ -e $1 ]
then
	echo $1 is exist!
else
	echo $1 isn\'t exist!
fi

