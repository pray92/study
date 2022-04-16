package ch7;

class Outer {
    class InstanceInner {
        int iv = 100;
    }

    static class StaticInner {
        int iv = 200;
        static int cv = 300;
    }

    void method() {
        class LocalInner {
            int iv = 400;
        }
    }
}

public class InnerEx4 {
    public static void execute() {
        // 인스턴스 클래스의 인스턴스 생성을 위해선
        // 외부 클래스의 인스턴스를 먼저 생성해야 해요.
        Outer oc = new Outer();
        Outer.InstanceInner ii = oc.new InstanceInner();

        System.out.println("ii.iv : " + ii.iv);
        System.out.println("Outer.StaticInner.cv : " + Outer.StaticInner.cv);

        // 스태틱 내부 클래스의 인스턴스는 외부 클래스를 먼저 생성하지 않아도 되요
        Outer.StaticInner si = new Outer.StaticInner();
        System.out.println("si.iv : " + si.iv);
    }
}
