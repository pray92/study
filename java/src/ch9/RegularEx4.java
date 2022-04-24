package ch9;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularEx4 {
    
    public static void execute() {
        String source = "A broken hand works, but not a broken heart.";
        String pattern = "broken";
        StringBuffer sb = new StringBuffer();

        Matcher m = Pattern.compile(pattern).matcher(source);
        System.out.println("source : " + source);

        int i = 0;
        while(m.find()){
            System.out.println(++i + "번째 매칭 : " + m.start() + "~" + m.end());
            // broken을 drunken으로 치환하여 sb에 저장해요.
            m.appendReplacement(sb, "drunken");
        }
        //m.appendTail(sb);
        System.out.println("Replacement count : " + i);
        System.out.println("Result : " + sb.toString());
    }
}
