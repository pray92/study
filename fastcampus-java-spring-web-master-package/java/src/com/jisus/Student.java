package com.jisus;

public class Student {

    private int studentId;
    private String studentName;

    private Subject korean;
    private Subject math;

    public Student(int studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;

        korean = new Subject();
        math = new Subject();
    }

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public Subject getKorean() {
        return korean;
    }

    public Subject getMath() {
        return math;
    }

    public void setKorean(String name, int score) {
        this.korean.setSubjectName(name);
        this.korean.setScore(score);
    }

    public void setMath(String name, int score) {
        this.math.setSubjectName(name);
        this.math.setScore(score);
    }

    public void showScoreInfo(){
        int total = this.korean.getScore() + this.math.getScore();
        System.out.println(studentName + "학생의 총점은 " + total + "점입니다.");
    }

}
