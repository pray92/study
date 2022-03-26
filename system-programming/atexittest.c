#include <stdlib.h>
#include <stdio.h>

int main(void){
	// main 함수에 콜백 함수 선언이 가능?!
	void exithandling(void);
	void goodbyemessage(void);
	int ret;
	
	ret = atexit(exithandling);
	if(ret != 0) perror("Error in atexit\n");
	ret = atexit(goodbyemessage);
	if(ret != 0) perror("Error in atexit\n");
	exit(EXIT_SUCCESS);
}

void exithandling(void){
	printf("exit handling\n");
}

void goodbyemessage(void){
	printf("see you again!\n");
}
