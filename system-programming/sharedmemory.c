#include <string.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <sys/wait.h>
#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>

int main(){
	int shmid, pid;
	char* shmaddr_parent, *shmaddr_child;
	shmid = shmget((key_t)1234, 10, IPC_CREAT | 0644);
	if(shmid == -1){
		perror("shmget error\n");
		exit(1);
	}
	pid = fork();
	if(pid > 0){		// Process 생성
		wait(0);	// 자식 프로세스 종료 때까지 대기
		shmaddr_parent = (char*)shmat(shmid, (char*)NULL, 0);
		printf("%s\n", shmaddr_parent);
		shmdt((char*)shmaddr_parent);
	} else{
		shmaddr_child = (char*)shmat(shmid, (char*)NULL, 0);
		strcpy((char*)shmaddr_child, "hello Parent!");
		shmdt((char*)shmaddr_child);	// NOTE : 이때 공유 메모리는 커널에 남아 있고, 붙어 있던 변수만 해제!
		exit(0);
	}
	shmctl(shmid, IPC_RMID, (struct shmid_ds*)NULL);
	return 0;
}
