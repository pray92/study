package ch7;

public class PolyArgumentTest2 {
    public static void execute(){
        Buyer b = new Buyer();

        b.buy(new Tv());
        b.buy(new Computer());
        b.buy(new Computer());
        b.buy(new Computer());
        b.buy(new Computer());
        b.buy(new Computer());
        b.buy(new Computer());
        b.buy(new Computer());
        b.buy(new Computer());
        b.buy(new Computer());
        b.buy(new Computer());
        b.buy(new Audio());
        b.summary();
    }
}
