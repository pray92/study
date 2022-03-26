package com.jisus;

public class Main {

    public static void main(String[] args) {
        // Student, Subject Test
        Student studentLee = new Student(100, "Lee");
        studentLee.setKorean("국어", 100);
        studentLee.setMath("수학", 94);
        studentLee.showScoreInfo();

        Student studentKim = new Student(200, "Kim");
        studentKim.setKorean("국어", 54);
        studentKim.setMath("수학", 83);
        studentKim.showScoreInfo();

        // 싱글톤 예제
        Company company = Company.getInstance();
        Company company2 = Company.getInstance();
        /*company = new Company();*/ // 사용 불가
        System.out.println(company == company2);

    }
}
