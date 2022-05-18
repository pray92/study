package ch13;

import javax.swing.JOptionPane;

public class ThreadEx14 {
    public static void execute() {
        ThreadEx13_1 th1 = new ThreadEx13_1();
        th1.start();

        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
        System.out.println("입력하시 값은 " + input + "이에요.");
        th1.interrupt();
        System.out.println("isInterrupted() : " + th1.isInterrupted());
    }
}

class ThreadEx14_1 extends Thread {
    @Override
    public void run() {
        int i = 10;
        while(i != 0 && !interrupted()) {
            System.out.println(i--);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // 예외가 발생하고 난 이후에, interrupted는 다시 false로 돌아가요
            }
        }
        System.out.println("카운트가 종료되었어요.");
    }
}