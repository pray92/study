package ch14;

import java.util.Comparator;
import java.util.stream.Stream;

public class StreamEx1 {
    public static void execute() {
        Stream<Student> stream = Stream.of(
            new Student("이자바", 3, 300),
            new Student("김자바", 1, 200),
            new Student("안자바", 2, 100),
            new Student("박자바", 2, 150),
            new Student("소자바", 1, 200),
            new Student("나자바", 3, 290),
            new Student("바자바", 3, 180)
        );

        stream.sorted(Comparator.comparing(Student::getBan)
            .thenComparing(Comparator.naturalOrder()))
            .forEach(System.out::println);
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
