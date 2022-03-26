#!/bin/bash

# 백업하기
if [ -z $1 ] || [ -z $2 ]; then
	echo usage: $0 sourcedir targetdir
else
	SRCDIR=$1
	DSTDIR=$2
	BACKUPFILE=backup.$(date +%y%m%d%H%M%S).tar.gz	# 백업 파일 명(backup.현재시각(date는 명령어).tar.gz
	if [ -d $DSTDIR ]; then
		tar -cvzf $DSTDIR/$BACKUPFILE $SRCDIR
	else
		mkdir $DSTDIR
		tar -cvzf $DSTDIR/$BACKUPFILE $SRCDIR
	fi
fi
