package ch13;

public class ThreadEx21 {
    public static void execute() {
        Runnable r = new RunnableEx21();
        new Thread(r).start();
        new Thread(r).start();
    }
}

class RunnableEx21 implements Runnable {
    Account account = new Account();
    
    @Override
    public void run() {
        while(account.getBalance() >0 ){
            int money = (int)(Math.random() * 3 + 1) * 100;
            account.withdraw(money);
            System.out.println("balance : " + account.getBalance());
        }
    }
}