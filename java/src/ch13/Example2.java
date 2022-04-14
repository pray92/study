package ch13;

public class Example2 {
    public static void execute() {
        Example2_1 r = new Example2_1();
        Thread t1 = new Thread(r);
        t1.start();
    }   
}

class Example2_1 implements Runnable{
    @Override
    public void run() {
        throwException();
    }

    private void throwException() {
        try{
            throw new Exception();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
