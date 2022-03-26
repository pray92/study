# 아이디 관련 정보 리스트 변수로 만들고, 각 정보 출력하기
#	1. 실제 이름
#	2. 나이
#	3. 직업
#!/bin/bash

my_info=('김길순' 53 'shell script programmer')

# 일괄 출력
echo ${my_info[*]}

# 부분 출력
echo 이름 : ${my_info[0]}
echo 나이 : ${my_info[1]}
echo 직업 : ${my_info[2]}
