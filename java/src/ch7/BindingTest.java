package ch7;

public class BindingTest {
    public static void execute() {
        Parent p = new Child();
        Child c = new Child();

        System.out.println("p.x = " + p.x);
        p.method();
        System.out.println("c.x = " + c.x);
        c.method();
    }
}

class Parent {
    int x = 100;

    void method() {
        System.out.println("Parent method");
    }
}

class Child extends Parent {
    int x = 200;
    
    @Override
    void method() {
        System.out.println("Child method");
    }
}