package ch11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListLinkedListTest {
    public static void execute() {
        ArrayList a1 = new ArrayList<>(20_000_000);
        LinkedList l1 = new LinkedList<>();

        System.out.print("순차적 추가");
        System.out.println("ArrayList : " + add1(a1));
        System.out.println("LinkedList : " + add1(l1));

        System.out.print("중간에 삽입");
        System.out.println("ArrayList : " + add2(a1));
        System.out.println("LinkedList : " + add2(l1));

        System.out.print("중간에 삭제");
        System.out.println("ArrayList : " + remove2(a1));
        System.out.println("LinkedList : " + remove2(l1));

        System.out.print("순차적 삭제");
        System.out.println("ArrayList : " + remove1(a1));
        System.out.println("LinkedList : " + remove1(l1));
    }

    private static long add1(List list) {
        long start = System.currentTimeMillis();
        for(int i = 0 ; i < 1_000_000; ++i) list.add(i + "");
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long add2(List list) {
        long start = System.currentTimeMillis();
        for(int i = 0 ; i < 10_000; ++i) list.add(500, "ㅌ");
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long remove1(List list) {
        long start = System.currentTimeMillis();
        for(int i = list.size() - 1; i >= 0 ; --i) list.remove(i);
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long remove2(List list) {
        long start = System.currentTimeMillis();
        for(int i = 0 ; i < 10_000; ++i) list.remove(0);
        long end = System.currentTimeMillis();
        return end - start;
    }
}
