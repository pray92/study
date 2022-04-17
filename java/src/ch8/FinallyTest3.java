package ch8;

public class FinallyTest3 {
    public static void execute() {
        method1();
        System.out.println("method1()의 수행을 마치고 main 메서드로 돌아왔어요.");
    }

    private static void method1(){
        try {
            System.out.println("method1이 호출되었어요.");
            return;
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            System.out.println("method1()의 finally 블록이 실행되었어요.");
        }
    }
}
