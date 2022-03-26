package example.juice;

import example.box.Box;
import example.fruit.Fruit;

public class Juicer {
    public static Juice makeJuice(Box<? extends Fruit> box){
        String tmp = "";
        for(Fruit f : box.getList()){
            tmp += f + " ";
        }
        return new Juice(tmp);
    }
}
