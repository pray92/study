#!/bin/bash

if [ $# -ne 2 ]
then
	echo 'Only 2 parameters required!'
	exit
fi

if [ $1 -eq $2 ]
then
	echo 'same values'
else
	echo 'different values'
fi
