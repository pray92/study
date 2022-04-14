package ch13;

public class Example1 {
    public static void execute() {
        Example1_1 t1 = new Example1_1();
        Runnable r = new Example1_2();
        Thread t2 = new Thread(r);

        t1.start();
        t2.start();
    }
}

class Example1_1 extends Thread {
    @Override
    public void run() {
        for(int i = 0 ; i < 5; ++i){
            // 조상인 Thread의 getName() 호출
            System.out.println(getName());
        }
    }
}

class Example1_2 implements Runnable {
    @Override
    public void run() {
        for(int i = 0 ; i < 5; ++i){
            // Thread.currentThread() : 현재 실행 중인 Thread 반환
            System.out.println(Thread.currentThread().getName());
        }
    }
}