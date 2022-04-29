package ch11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListLinkedListTest2 {
    public static void execute() {

        ArrayList a1 = new ArrayList<>(20_000_000);
        LinkedList l1 = new LinkedList<>();

        add(a1);
        add(l1);

        System.out.print("접근시간 테스트");
        System.out.println("ArrayList : " + access(a1));
        System.out.println("LinkedList : " + access(l1));
    }

    private static long add(List list) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; ++i)
            list.add(i + "");
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long access(List list) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10_000; ++i)
            list.get(i);
        long end = System.currentTimeMillis();
        return end - start;
    }
}
