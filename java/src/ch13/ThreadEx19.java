package ch13;

public class ThreadEx19 {

    static long startTime = 0L;

    public static void execute() {
        ThreadEx19_1 th1 = new ThreadEx19_1();
        ThreadEx19_2 th2 = new ThreadEx19_2();

        th1.start();
        th2.start();

        ThreadEx19.startTime = System.currentTimeMillis();
        try {
            th1.join(); // main 쓰레드가 th1이 끝날 때까지 대기
            th2.join(); // main 쓰레드가 th2이 끝날 때까지 대기
        } catch (InterruptedException e) {
        }
        System.out.println("소요 시간 : " + (System.currentTimeMillis() - ThreadEx19.startTime));
    }
}

class ThreadEx19_1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 300; ++i) {
            System.out.print(new String("-"));
        }
    }
}

class ThreadEx19_2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 300; ++i) {
            System.out.print(new String("|"));
        }
    }
}