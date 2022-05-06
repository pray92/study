
import ch14.StreamEx1;

public class Main {

    public static void main(String[] args) {
        StreamEx1.execute();
        //Stream.iterate(0,(a) -> a + 1).limit(10).collect(Collectors.toList()).forEach(System.out::print);
        //List<Integer> list = Stream.iterate(0,(a) -> a + 1).limit(10).collect(Collectors.toList());
    }
}
