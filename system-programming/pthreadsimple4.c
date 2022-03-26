#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <unistd.h>

void *t_func(void* ptr){
	char* message;
	message = (char*)ptr;
	printf("%s start\n", message);
	sleep(5);	// 5초
	printf("%s end\n", message);
	return 0;
}

int main(){
	pthread_t thread1, thread2;
	const char* message1 = "Thread1";
	const char* message2 = "Thread2";
	int ret, status;

	ret = pthread_create(&thread1, NULL, t_func, (void*)message1);
	if (ret < 0) {
		perror("thread_create error");
	}
	pthread_detach(thread1);

	ret = pthread_create(&thread2, NULL, t_func, (void*)message2);
	if (ret < 0) {
		perror("thread_create error");
	}
	pthread_join(thread2, (void**)&status);
	printf("thread2 returns %d\n", status);

	sleep(10);
	return 0;
}
