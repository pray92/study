package ch14;

@FunctionalInterface
interface MyFunction {
    public abstract void run();
}

public class LambdaEx1 {
    static void executeRun(MyFunction f) {
        f.run();
    }

    static MyFunction getMyFunction() {
        MyFunction f = () -> System.out.println("f3.run()");
        return f;
    }

    public static void execute() {
        MyFunction f1 = () -> System.out.println("f1.run()");

        MyFunction f2 = new MyFunction() {
            public void run() {
                System.out.println("f2.run()");
            }
        };

        MyFunction f3 = getMyFunction();

        f1.run();
        f2.run();
        f3.run();

        executeRun(f1);
        executeRun(() -> System.out.println("run()"));
    }
}
