package ch14;

import java.io.File;
import java.util.stream.Stream;

public class StreamEx2 {
    public static void execute() {
        File[] fileArr = {
            new File("Ex1.java"),
            new File("Ex1.bak"),
            new File("Ex2.java"),
            new File("Ex1"),
            new File("Ex1.txt"),
        };

        Stream<File> fileStream = Stream.of(fileArr);
        
        // map()을 통해 Stream<File>을 Stream<String>으로 변환
        Stream<String> fileNameStream = fileStream.map(File::getName);
        fileNameStream.forEach(System.out::println);    // 파일 이름 출력

        // 위에서 이미 한번 닫혔으므로 스트림을 다시 생성해야 함
        fileStream = Stream.of(fileArr);

        fileStream.map(File::getName)
            .filter(s -> s.indexOf('.') != -1)          // 확장자 없는 것 제외
            .map(s -> s.substring(s.indexOf('.') + 1))  // 확장자만 추출
            .map(String::toUpperCase)                   // 대문자 변환
            .distinct()                                 // 중복 제거
            .forEach(System.out::print);                // 전체 출력
        System.out.println();
    }
}
