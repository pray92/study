package ch7;

public class InnerEx3 {
    private int outerIv = 0;
    static int outerCv = 0;

    class InstanceInner {
        int iiv = outerIv; // private 멤버 접근 가능
        int iiv2 = outerCv;
    }

    static class StaticInner {
        // 스태틱 클래스는 외부 클래스의 인스턴스 멤버에 접근 못해요
        // int siv = outerIv;
        static int scv = outerCv;
    }

    void myMethod() {
        int lv = 0;
        final int LV = 0; // 1.8부터 생략 가능해요
        //lv = 1;
        class LocalInner {
            int liv = outerIv;
            int liv2 = outerCv;
            // 외부 클래스의 지역 변수는 final이 붙은 변수(상수)만 접근 가능해요
            // 는 1.8부터 안 붙어도 가능해요
            int liv3 = lv;      // 1.8 이전에선 안되요
            int liv4 = LV;
        }
    }
}
