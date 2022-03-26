#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#define MSGSIZE 255

char* msg = "Hello Child Process!";

int main()
{
	char buf[255];
	int fd[2], pid, nbytes;
	if(pipe(fd) < 0){
		exit(1);	// pipe(fd)로 파이프 생성
	}
	pid = fork();	// 이 함수 실행 다음 코드부터 부모/자식 프로세스로 나뉘어짐
	if(pid > 0){
		printf("parent PID:%d, child PID:%d\n", getpid(), pid);
		write(fd[1], msg, MSGSIZE);	// fd[1]에 씁니다.
		exit(0);
	} else{
		printf("child PID:%d\n", getpid());
		nbytes = read(fd[0], buf, MSGSIZE);	// fd[0]으로 읽음
		printf("%d %s\n", nbytes, buf);
		exit(0);
	}
	return 0;
}
