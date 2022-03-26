#include <signal.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>

static void signal_handler(int signo){
	printf("Catch SIGINT!, but no stop\n");
}

int main(){
	if(signal(SIGINT, signal_handler) == SIG_ERR){
		printf("Can't catch SIGINT!\n");
		exit(1);
	}
	for (;;)
		pause();	// 무한루프를 돌면서 멈추게 함
       				// -> 결과적으로 해당 프로그램 실행 시켜 놓고 터미널을 통해 해당프로세스에 시그널 보냄
	return 0;
}
