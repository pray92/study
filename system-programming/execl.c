#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{
	printf("execute ls\n");
	// 실행하려는 파일의 전체 파일 경로, argv, NULL
	execl("/bin/ls", "ls", "-l", NULL);
	perror("execl is failed\n");
	exit(1);
}
