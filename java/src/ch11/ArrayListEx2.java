package ch11;

import java.util.ArrayList;
import java.util.List;

public class ArrayListEx2 {

    private static final int LIMIT = 10; // 자르고자 하는 글자 개수

    public static void execute() {
        String source = "0123456789abcdefghijABCDEFGHIJ!@#$%^&*()ZZZ";
        int length = source.length();

        List<String> list = new ArrayList<String>();
        for (int i = 0; i < length; i += LIMIT) {
            if (i + LIMIT < length) {
                list.add(source.substring(i, i + LIMIT));
            } else {
                list.add(source.substring(i));
            }
        }

        for (int i = 0; i < list.size(); ++i) {
            System.out.println(list.get(i));
        }
    }
}
