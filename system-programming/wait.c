#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>

int main()
{
	int pid;
	int child_pid;
	int status;
	pid = fork();
	switch(pid){
	case -1:
		perror("fork is failed\n");
		break;
	case 0: // 자식 프로세스
		execl("/bin/ls", "ls", "-al", NULL);
		break;
	default:
		child_pid = wait(NULL);	// 자식 프로세스가 끝날 때까지 대기
		printf("ls is complete\n");
		printf("Parent PID(%d), Child PID(%d)", getpid(), child_pid);
		exit(0);
	}
}
