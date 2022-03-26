#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <stdint.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <sys/mman.h>
#include <unistd.h>

int main(int argc, const char* argv[]){
	char* filePath = "link.txt";
	struct stat fileInfo;
	char* update = "hello mmap!";
	int fd = open(filePath, O_RDWR, (mode_t)0600);
	if (fd < 0){
		printf("can't open file for writing\n");
		exit(EXIT_FAILURE);
	}
	
	// fstat : fd인 파일의 정보를 해당 구조체에 담아줌
	fstat(fd, &fileInfo);
	printf("File size is %ld\n", fileInfo.st_size);
	char* map = mmap(0, fileInfo.st_size, PROT_READ | PROT_WRITE, MAP_SHARED, fd, 0);
	if(map == MAP_FAILED){
		close(fd);
		perror("Error mmapping the file");
		exit(EXIT_FAILURE);
	}
	
	printf("%ld\n", strlen(update));
	for(size_t i = 0 ; i < strlen(update); ++i){
		printf("Writing character %c at %zu\n", update[i], i);
		map[i] = update[i];
	}

	// 동기 방식은 디폴트라 아래 소스는 필요 없음	
//	if (msync(map, fileInfo.st_size, MS_SYNC) == -1) {
//		perror("Could not sync the file to disk");
//	}

//	if (munmap(map, fileInfo.st_size) == -1) {
//		close(fd);
//		perror("Error un-mapping the file");
//		exit(EXIT_FAILURE);
//	}
	
	close(fd);
	return 0;
}
