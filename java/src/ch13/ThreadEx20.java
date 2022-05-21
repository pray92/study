package ch13;

public class ThreadEx20 {
    public static void execute() {
        ThreadEx20_1 gc = new ThreadEx20_1();
        gc.setDaemon(true);
        gc.start();

        int requiredMemory = 0;
        for (int i = 0; i < 20; ++i) {
            requiredMemory = (int) (Math.random() * 10) * 20;

            // 필요한 메모리가 사용할 수 있는 양보다
            // 크거나, 전체 메모리의 60% 이상을 사용 시 gc
            if (gc.freeMemory() < requiredMemory
                    || gc.freeMemory() < gc.totalMemory() * 0.4) {
                gc.interrupt();
                try {
                    gc.join(100);
                } catch (InterruptedException e) {

                }
            }

            gc.usedMemory += requiredMemory;
            System.out.println("usedMemory : " + gc.usedMemory);
        }

    }
}

class ThreadEx20_1 extends Thread {

    final static int MAX_MEMORY = 1000;
    int usedMemory = 0;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000 * 10);
            } catch (InterruptedException e) {
                System.out.println("Awaken by interrupt()");
            }
            gc();
            System.out.println("Garbage collected. Free memory : " + freeMemory());
        }
    }

    public void gc() {
        usedMemory = Math.max(usedMemory - 300, 0);
    }

    public int totalMemory() {
        return MAX_MEMORY;
    }

    public int freeMemory() {
        return MAX_MEMORY - usedMemory;
    }
}
