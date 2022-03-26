#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

void *thread_func(void* ptr){
	char* message;
	message = (char*)ptr;
	printf("%s\n", message);
	pthread_exit((void*)100);
}

int main(void){
	pthread_t thread1, thread2;
	const char* message1 = "Thread 1";
	const char* message2 = "Thread 2";
	int ret, status;

	ret = pthread_create(&thread1, NULL, thread_func, (void*)message1);
	printf("ret=%d\n", ret);
	if(ret == 0) { 
		printf("pthread_create returns %d\n", ret);
	} else {
		printf("pthread_create returns error: %d\n", ret);
		exit(1);
	}
	ret = pthread_create(&thread2, NULL, thread_func, (void*)message2);
	if(ret == 0) {
		printf("pthread_create returns %d\n", ret);
	} else {
		printf("pthread_create returns error: %d\n", ret);
		exit(1);
	}
	// thread1 끝날 때까지 다음 코드 실행X
	pthread_join(thread1, (void**)&status);
	printf("thread1 returns: %d\n", status);
	// thread2 끝날 때까지 다음 코드 실행 X
	pthread_join(thread2, (void**)&status);
	printf("thread2 returns: %d\n", status);

	return 0;
}
