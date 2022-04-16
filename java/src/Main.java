import ch7.InterfaceTest2;

interface a {
    default void func() {
        System.out.println("a");
    }
}

interface b {
    default void func() {
        System.out.println("b");
    }
}

// 클래스 B가 모호해요!
class B implements a, b{
    @Override 
    public void func() {

    }
}
public class Main{
    public static void main(String[] args) {
        InterfaceTest2.execute();
    }

}