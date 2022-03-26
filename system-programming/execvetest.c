#include <unistd.h>
#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <sys/types.h>
#define MAXLINE 64

int main(int argc, char **argv)
{
	char buf[MAXLINE];
	pid_t pid;
	printf("Redgem92Shell ver 1.0\n");
	while(1){
		memset(buf, 0x00, MAXLINE);
		// stdin이라는 파일(표준 입력)에서 값을 가져오겠다
		fgets(buf, MAXLINE -1 , stdin);
		if(strncmp(buf, "exit\n", 5) == 0 ){
			break;
		}
		buf[strlen(buf) - 1] = 0x00;

		pid = fork();
		switch(pid){
			case -1:
				break;
			case 0:
				if(execlp(buf, buf, NULL) == -1){
					printf("command execution is failed\n");
					exit(0);
				}
				break;
			default:
				wait(NULL);

		}
	}
	return 0;
}
