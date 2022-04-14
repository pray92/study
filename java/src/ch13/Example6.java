package ch13;

public class Example6 {
    public static void execute() {
        Example6_1 gc = new Example6_1();
        gc.setDaemon(true);
        gc.start();

        int requiredMemory = 0;
        for(int i = 0; i < 20; ++i){
            requiredMemory = (int)(Math.random() * 10) * 20;
            // 필요한 메모리가 사용할 수 있는 양보다 크거나 전체 메모리의 60% 이상을 사용했을 경우 gc를 깨웁니다.
            if(gc.getFreeMemory() < requiredMemory 
            || gc.getFreeMemory() < gc.getTotalMemory() * 0.4){
                // 잠자고 있는 gc를 깨웁니다.
                gc.interrupt();
            }
            gc.setUsedMemory(gc.getUsedMemory() + requiredMemory);
            System.out.println("usedMemory : " + gc.getUsedMemory());
        }
    }
}

class Example6_1 extends Thread{
    private final static int MAX_MEMORY = 1000;
    private int usedMemory = 0;
    public void setUsedMemory(int memory) { usedMemory = memory; }
    public int getUsedMemory() { return usedMemory; }

    @Override
    public void run() {
        while(true){
            try{
                Thread.sleep(10 * 1000);
            } catch(InterruptedException e){
                System.out.println("Awaken by interrupt().");
            }
            gc();
            System.out.println("Garbage Collected. Free Memory : " + getFreeMemory());
        }
    }

    private void gc() {
        usedMemory -= 300;
        if(usedMemory < 0){
            usedMemory = 0;
        }
    }

    public int getTotalMemory() { return MAX_MEMORY; }
    public int getFreeMemory() { return MAX_MEMORY - usedMemory; }
}