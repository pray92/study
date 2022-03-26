package example.fruit;

import java.util.Comparator;

public class FruitComp implements Comparator<Fruit> {
    @Override
    public int compare(Fruit src, Fruit dest){
        return dest.getWeight() - src.getWeight();
    }
}
