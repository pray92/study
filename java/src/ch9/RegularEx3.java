package ch9;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularEx3 {
    public static void execute() {
        String source = "HP:011-1111-1111, HOME:02-9999-9999";
        // 괄호로 그룹화!
        String pattern = "(0\\d{1,2})-(\\d{3,4})-(\\d{3,4})";

        Matcher m = Pattern.compile(pattern).matcher(source);
        int i = 0;
        while(m.find()){
            System.out.println(++i + ": " + m.group() + " -> " + m.group(1)
                                    + ", "+ m.group(2) + ", " + m.group(3));
        }
    }
}
