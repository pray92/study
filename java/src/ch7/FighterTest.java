package ch7;

public class FighterTest {
    public static void execute() {
        Fighter fighter = new Fighter();
        if (fighter instanceof Unit) {
            System.out.println("fighter는 Unit의 자손이에요.");
        }
        if (fighter instanceof Fightable) {
            System.out.println("fighter는 Fightable의 자손이에요.");
        }
        if (fighter instanceof Movable) {
            System.out.println("fighter는 Movable의 자손이에요.");
        }
        if (fighter instanceof Attackable) {
            System.out.println("fighter는 Attackable의 자손이에요.");
        }
        if (fighter instanceof Object) {
            System.out.println("fighter는 Object의 자손이에요.");
        }
    }
}
