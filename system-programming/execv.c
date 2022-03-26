#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>

int main()
{
	char *envp[] = {"USER=REDGEM92", NULL};
	char *arg[] = {"ls", "-al", NULL};
	
	printf("execute ls\n");
	execve("ls", arg, envp);
	perror("execve is failed\n");
	exit(1);
}
