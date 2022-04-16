package ch7;

public class InstanceofTest {
    public static void execute() {
        FireEngine fe = new FireEngine();
        if (fe instanceof FireEngine) {
            System.out.println("It's fire engine.");
        }
        if (fe instanceof Car) {
            System.out.println("It's car.");
        }
        if (fe instanceof Object) {
            System.out.println("It's object.");
        }
    }
}