import java.util.Collections;

import example.box.FruitBox;
import example.enumeration.Direction;
import example.enumeration.Tranportation;
import example.fruit.FruitComp;
import example.fruit.Grape;
import example.fruit.Apple;

class NewClass{
    private int newField;
    int getNewField() { return newField; }

    @Deprecated
    int oldField;
    @Deprecated     // Wrapper 메서드에도 선언하지 않으면 메시지 출력X(따라서 주의)
    int getOldField() { return oldField; }
}

public class Main {

    public static void main( String[] args ) {
        annotationEx2();
    }

    private static void annotationEx2(){
        NewClass nc = new NewClass();
        System.out.println(nc.getOldField());
    }

    private static void EnumEx(){
        for(Direction d : Direction.values()){
            System.out.printf("%s=%d%n", d.name(), d.getValue());
        }

        Direction d1 = Direction.EAST;
        Direction d2 = Direction.of(1);

        System.out.printf("d1=%s, %d%n", d1.name(), d1.getValue());
        System.out.printf("d2=%s, %d%n", d2.name(), d2.getValue());
        System.out.println(Direction.EAST.rotate(1));
        System.out.println(Direction.EAST.rotate(2));
        System.out.println(Direction.EAST.rotate(-1));
        System.out.println(Direction.EAST.rotate(-2));
    }

    private static void EnumEx2(){
        System.out.println("bus fare = " + Tranportation.BUS.fare(100));
        System.out.println("train fare = " + Tranportation.TRAIN.fare(100));
        System.out.println("ship fare = " + Tranportation.SHIP.fare(100));
        System.out.println("airplane fare = " + Tranportation.AIRPLANE.fare(100));
    }

    private static void FruitBoxEx(){
        FruitBox<Apple> appleBox = new FruitBox<Apple>();
        appleBox.add(new Apple("GreenApple", 300));
        appleBox.add(new Apple("GreenApple", 100));
        appleBox.add(new Apple("GreenApple", 200));
        Collections.sort(appleBox.getList(), new FruitComp());
        System.out.println(appleBox.toString());
        
        FruitBox<Grape> grapeBox = new FruitBox<Grape>();
        grapeBox.add(new Grape("GreenGrape", 400));
        grapeBox.add(new Grape("GreenGrape", 300));
        grapeBox.add(new Grape("GreenGrape", 200));
        Collections.sort(grapeBox.getList(), new FruitComp());
        System.out.println(grapeBox.toString());
    }
}