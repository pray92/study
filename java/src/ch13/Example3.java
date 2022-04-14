package ch13;

public class Example3 {

    public static long startTime = 0;

    public static void execute() {
        Runnable r = new Example3_1();
        Thread t1 = new Thread(r);
        t1.start();

        startTime = System.currentTimeMillis();

        for(int i = 0; i < 300; ++i){
            System.out.printf("%s", new String("-"));
        }
        System.out.println("소요시간 1 : "  + (System.currentTimeMillis() - Example3.startTime));
    }
}

class Example3_1 implements Runnable {
    @Override
    public void run() {
        for(int i = 0; i < 300; ++i){
            System.out.printf("%s", new String("|"));
        }
        System.out.println("소요시간 2 : "  + (System.currentTimeMillis() - Example3.startTime));
    }
}