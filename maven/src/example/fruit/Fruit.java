package example.fruit;

public class Fruit { 
    
    private String name;
    private int weight;

    public Fruit(String name, int weight){
        this.name = name;
        this.weight = weight;
    }

    public String getName() { return name; }
    public int getWeight() { return weight; }

    public String toString() { 
        return name + "(" + weight + ")"; 
    } 
}