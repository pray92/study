package ch13;

public class ThreadEx10 implements Runnable {
    static boolean autoSave = false;

    public static void execute() {
        Thread t = new Thread(new ThreadEx10());

        t.setDaemon(true);
        t.start();

        for (int i = 1; i <= 10; ++i) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println(i);
            if (i == 5) {
                autoSave = true;
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
            }

            if (autoSave) {
                autoSave();
            }
        }
    }

    public void autoSave() {
        System.out.println("파일이 자동 저장되었어요.");
    }
}
