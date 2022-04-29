package ch11;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorEx2 {
    public static void execute() {
        ArrayList original = new ArrayList<>();
        ArrayList copy1 = new ArrayList<>();
        ArrayList copy2 = new ArrayList<>();

        for(int i = 0 ; i < 10; ++i ){
            original.add(i + "");
        }

        Iterator iter = original.iterator();

        while(iter.hasNext()){
            copy1.add(iter.next());
        }

        System.out.println("Original에서 Copy1로 복사");
        System.out.println("Original : " + original);
        System.out.println("Copy1 : " + copy1);
        System.out.println();

        // 재사용이 안되므로 다시 초기화(커서)
        iter = original.iterator();
        while(iter.hasNext()){
            copy2.add(iter.next());
            iter.remove();
        }

        System.out.println("Original에서 Copy2 이동");
        System.out.println("Original : " + original);
        System.out.println("Copy2 : " + copy2);
        System.out.println();
    }
}
