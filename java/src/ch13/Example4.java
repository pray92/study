package ch13;

public class Example4 {
    
    public static void execute() {
        Thread t1 = new Example4_1();
        Thread t2 = new Example4_2();

        t2.setPriority(7);

        System.out.println("Priority of t1(-) : " + t1.getPriority());
        System.out.println("Priority of t2(|) : " + t2.getPriority());

        t1.start();
        t2.start();
    }
}

class Example4_1 extends Thread {
    @Override
    public void run() {
        for(int i = 0 ;i < 300; ++i){
            System.out.print("-");
            for(int x = 0; x < 10_000_000; ++x);
        }
    }
}

class Example4_2 extends Thread {
    @Override
    public void run() {
        for(int i = 0 ; i < 300 ; ++i){
            System.out.print("|");
            for(int x = 0; x < 10_000_000; ++x);
        }
    }
}