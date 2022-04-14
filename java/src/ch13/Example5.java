package ch13;

public class Example5 {
    public static void execute() {
        Thread t = new Example5_1();
        t.setDaemon(true);  // 이 부분이 없으면 종료되지 않습니다.
        t.start();

        for(int i = 1; i <= 10; ++i){
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {}
            System.out.println(i);
            
            if(i == 5){
                Example5_1.autoSave = true;
            }
        }
        
        System.out.println("시스템을 종료합니다.");
    }
}

class Example5_1 extends Thread {

    static boolean autoSave = false;

    @Override
    public void run() {
        while(true) {
            try{
                Thread.sleep(3 * 1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            
            // autoSave 값이 true면, autoSave()가 호출됩니다.
            if(autoSave){
                autoSave();
            }
        }
    }

    public void autoSave() {
        System.out.println("작업 파일이 자동 저장되었습니다.");
    }
}
