#!/bin/bash

# find .(현재 디렉토리) -type f(일반 파일) -name '파일명 검색어'(정규 표현식) -exec bash -c "명령1; 명령2; 명령3;"\;

# 정책
# 1. 로그 파일 2일 이상 -> 압축
# 2. 압축된 로그 파일 중 3일 이상 경과 -> 삭제
LOGDIR=/var/log
GZIPDAY=1
DELDAY=2

cd $LOGDIR
echo "cd $LOGDIR"

# 해당 파일 기록 시간 + 2일 이상 경과한 파일을 찾아 gzip {각각의 파일리스트} 실행
sudo find . -type f -name '*.log.?' -mtime +$GZIPDAY -exec bash 'gzip {}' \; 2> /dev/null
# 해당 파일 기록 시간 + 3일 이상 경과한 파일을 찾아 rm -f {} 실행
sudo find . -type f -name '*.gz' -mtime +$DELDAY -exec bash 'rm -f {}' \; 2> /dev/null
