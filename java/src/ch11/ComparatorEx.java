package ch11;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorEx {
    public static void execute() {
        String[] arrStr = { "cat", "Dog", "lion", "tiger" };
        
        Arrays.sort(arrStr);
        System.out.println("arrStr : " + Arrays.toString(arrStr));

        Arrays.sort(arrStr, String.CASE_INSENSITIVE_ORDER);
        System.out.println("arrStr : " + Arrays.toString(arrStr));
        
        Arrays.sort(arrStr, new Descending<String>());
        System.out.println("arrStr : " + Arrays.toString(arrStr));

    }

}

class Descending<T> implements Comparator<T> {
    @Override
    public int compare(Object obj1, Object obj2) {
        if(obj1 instanceof Comparable && obj2 instanceof Comparable){
            Comparable c1 = (Comparable)obj1;
            Comparable c2 = (Comparable)obj2;
            return -c1.compareTo(c2);
        }
        return -1;
    }
}
