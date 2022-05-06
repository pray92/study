package ch14;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx1 {
    public static void execute() {
        Student[] stdArr = {
            new Student("이자바", 3, 300),
            new Student("김자바", 1, 200),
            new Student("안자바", 2, 100),
            new Student("박자바", 2, 150),
            new Student("소자바", 1, 200),
            new Student("나자바", 3, 290),
            new Student("바자바", 3, 180)
        };

        Stream<Student> stream = Stream.of(stdArr);

        stream.sorted(Comparator.comparing(Student::getBan)
            .thenComparing(Comparator.naturalOrder()))
            .forEach(System.out::println);

        // 스트림 닫혔으니 재생성
        stream = Stream.of(stdArr);
        IntStream stuScoreStream = stream.mapToInt(Student::getTotalScore);
        IntSummaryStatistics stat = stuScoreStream.summaryStatistics();
        System.out.println("count = " + stat.getCount());
        System.out.println("sum = " + stat.getSum());
        System.out.println("average = " + stat.getAverage());
        System.out.println("max = " + stat.getMax());
        System.out.println("min = " + stat.getMin());
    }
    
}

class Student implements Comparable<Student> {
    private String name;
    private int ban;
    private int totalScore;

    Student(String name, int ban, int totalScore){
        this.name = name;
        this.ban = ban;
        this.totalScore = totalScore;
    }

    @Override
    public String toString() {
        return String.format("[%s %s %s]", this.name, this.ban, this.totalScore);
    }

    String getName() { return this.name; }
    int getBan() { return this.ban; }
    int getTotalScore() { return this.totalScore; }
    
    @Override
    public int compareTo(Student s) {
        return this.totalScore - s.totalScore;
    }
}
