#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <sys/mman.h>
#include <unistd.h>

int main(int argc, const char* argv[]){
	char* filePath = "link.txt";
	struct stat fileInfo;
	int fd = open(filePath, O_RDONLY, (mode_t)0600);
	if (fd < 0){
		printf("can't open file\n");
		exit(EXIT_FAILURE);
	}
	
	// fstat : fd인 파일의 정보를 해당 구조체에 담아줌
	fstat(fd, &fileInfo);
	printf("File size is %ji\n", (intmax_t)fileInfo.st_size);
	char* map = mmap(0, fileInfo.st_size, PROT_READ, MAP_SHARED, fd, 0);
	if(map == MAP_FAILED){
		close(fd);
		perror("Error mmapping the file");
		exit(EXIT_FAILURE);
	}
	// No need fo scheduling, just access memory
	for(off_t i = 0 ; i < fileInfo.st_size; ++i){
		printf("Found character %c at %ji\n", map[i], (intmax_t)i);
	}
	
	if(munmap(map, fileInfo.st_size) == -1){
		close(fd);
		perror("Error un-mapping the file");
		exit(EXIT_FAILURE);
	}
	close(fd);
	return 0;
}
